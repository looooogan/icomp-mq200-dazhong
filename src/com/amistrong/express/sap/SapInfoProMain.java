package com.amistrong.express.sap;

import java.util.Calendar;
import java.util.List;
import java.util.Map;


import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.sap.conn.jco.JCoContext;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

public class SapInfoProMain implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger log = Logger.getLogger(SapInfoProMain.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		new RequestThread().start();
	}
	class RequestThread extends Thread {  
		@SuppressWarnings("rawtypes")
		@Override  
		public void run(){  
			while (true) {  
				try {
						Calendar cal = Calendar.getInstance();
						Integer year = cal.get(Calendar.YEAR); 
						Integer month = cal.get(Calendar.MONTH)+1; 
						Integer date = cal.get(Calendar.DATE); 
						Integer hour = cal.get(Calendar.HOUR_OF_DAY);
						Integer second = cal.get(Calendar.MINUTE);
						String to_date = year.toString()+"-"+month.toString()+"-"+date.toString();
						String time = hour.toString() + (second.toString().length()==1 ? "0"+second.toString() : second.toString());
						
						//每天23:59执行sap上传
						// todo 暂时屏蔽
						//if(time.equals("2359")){
						if(time.equals("0001")){
							
							JDBCConnection tc = new JDBCConnection();
							JCoFunction function = null;
							JCoDestination destination = SAPConn.connect();
							JCoContext.begin(destination);
							String n="4698057479";//调用接口返回状态
							try {
								String selSapsql = "select sapID,pstngDate,docDate,material,moveType"
										+ ",moveType,entryQnt,moveMat,costCenter,orderID,outInDate"
										+ ",outInUser,uploadDate,state,valType,poItem from sapuploadhistory where state = 0 and DelFlag = '0'";
								
								List list = tc.getData(selSapsql);
								
								for(int i = 0;i < list.size();i++){
									//输出列名
						            Map map = (Map) list.get(i);
						            //调用ZRFC_GET_REMAIN_SUM函数
									function = destination.getRepository().getFunction("BAPI_GOODSMVT_CREATE");
									
									JCoStructure header = function.getImportParameterList().getStructure("GOODSMVT_HEADER");
									JCoStructure code = function.getImportParameterList().getStructure("GOODSMVT_CODE");
									JCoTable table = function.getTableParameterList().getTable("GOODSMVT_ITEM");
									header.setValue("PSTNG_DATE", map.get("pstngDate"));// 过账日期
						            header.setValue("DOC_DATE", map.get("docDate"));// 凭证日期
						            header.setValue("PR_UNAME", " DAOJU01");//todo 取當前  用户名
						           
						            //01 有订单入库 05 无订单入库  03 出库
						            if("101".equals(map.get("moveType"))){
						            	 code.setValue("GM_CODE", "01");//  事务代码
						            }else if("201".equals(map.get("moveType"))){
						            	code.setValue("GM_CODE", "03");//  事务代码
						            }else{
						            	code.setValue("GM_CODE", "05");//  事务代码
						            }
						            //将当前传入的值赋予各个参数
						            table.appendRow();
						            table.setValue("MATERIAL", map.get("material"));// 物料号
						            table.setValue("PLANT", "0005");// 工厂
						            table.setValue("STGE_LOC", "1200");// 库存地点
						            table.setValue("MOVE_TYPE", map.get("moveType"));// 移动类型（库存管理）
						            table.setValue("ENTRY_QNT", map.get("entryQnt"));// 数量
//						            table.setValue("MOVE_MAT", map.get("material"));// 收货/发货物料
//						            table.setValue("MOVE_PLANT", "0005");// 收货/发货工厂
//						            table.setValue("MOVE_STLOC", "1200");// 收货/发货库存地点
						            if("201".equals(map.get("moveType"))){
						            	table.setValue("COSTCENTER", map.get("costCenter"));// 成本中心
						            }
						            
						            table.setValue("VAL_TYPE",  map.get("valType"));// 评估类型
						            table.setValue("MVT_IND", "B");// 指定类型为采购定单
						            //table.setValue("STCK_TYPE", "E");// 库存类型
						            table.setValue("VENDOR", "SG0605"); //供货商 *非必要？
						            // 有订单入库
						            if("101".equals(map.get("moveType"))){
						            	table.setValue("PO_NUMBER", map.get("orderID"));// 订单号  100000000060 100000021456 100000021457
						            	table.setValue("PO_ITEM", map.get("poItem")); //定单序号
						            }
						            //table.setValue("ASSET_NO", "000000300002");// todo 主资产号/资产号 12位补零
									function.getImportParameterList().setValue("GOODSMVT_HEADER", header);
									function.getImportParameterList().setValue("GOODSMVT_CODE", code);
									function.getTableParameterList().setValue("GOODSMVT_ITEM", table);
									
									function.execute(destination);
									
									JCoTable PRITEM = function.getTableParameterList().getTable("RETURN");
									
									JCoFunction function2 = destination.getRepository().getFunction("BAPI_TRANSACTION_COMMIT");
									function2.execute(destination);
									
									JCoStructure renHeaner = function.getExportParameterList().getStructure("GOODSMVT_HEADRET");
									Integer state;
									// TODO 成功判断空还是？
									if(null == renHeaner.getString("MAT_DOC")){
										// 上传成功
										state = 1;
										// 上传失败
									}else{
										state = 2;
									}
									
									String updateSapsql = "update sapuploadhistory set state = " + state + 
											",message = " + PRITEM.getString("MESSAGE") + " where sapID = " + map.get("sapID");;
									tc.update(updateSapsql);
									JCoContext.end(destination);
									//for (int i = 0; i < PRITEM.getNumRows(); i++) {
//										PRITEM.setRow(i);
//										System.out.println(PRITEM.getString("MESSAGE"));
//									}
//									System.out.println("NUMBER: "+PRITEM.getString("NUMBER")+" MESSAGE: "+PRITEM.getString("MESSAGE"));
								
								
//								//调用ZRFC_GET_REMAIN_SUM函数
//								function = destination.getRepository().getFunction("BAPI_GOODSMVT_CREATE");
//								
//								JCoStructure header = function.getImportParameterList().getStructure("GOODSMVT_HEADER");
//								JCoStructure code = function.getImportParameterList().getStructure("GOODSMVT_CODE");
//								JCoTable table = function.getTableParameterList().getTable("GOODSMVT_ITEM");
//								header.setValue("PSTNG_DATE", new Date());// 过账日期
//					            header.setValue("DOC_DATE", new Date());// 凭证日期
//					            header.setValue("PR_UNAME", " DAOJU01");//todo 取當前  用户名
//					            code.setValue("GM_CODE", "03");//  事务代码
//					            //将当前传入的值赋予各个参数
//					            table.appendRow();
//					            table.setValue("MATERIAL", "KZDFC1100-003");// 物料号
//					            table.setValue("PLANT", "0005");// 工厂
//					            table.setValue("STGE_LOC", "1200");// 库存地点
//					            table.setValue("MOVE_TYPE", "101");// 移动类型（库存管理）
//					            table.setValue("ENTRY_QNT", 1);// 数量
//					            table.setValue("MOVE_MAT", "KZDFC1100-003");// 收货/发货物料
//					            table.setValue("MOVE_PLANT", "0005");// 收货/发货工厂
//					            table.setValue("MOVE_STLOC", "1200");// 收货/发货库存地点
//					            table.setValue("COSTCENTER", "0000010101");// 成本中心 10位补零
//					            table.setValue("COSTCENTER", "17413");// 成本中心
//					            table.setValue("ORDERID", "100000021457");// 订单号  100000000060 100000021456 100000021457
//					            table.setValue("ASSET_NO", "000000300002");// 主资产号/资产号 12位补零
//								
//								
//								function.getImportParameterList().setValue("GOODSMVT_HEADER", header);
//								function.getImportParameterList().setValue("GOODSMVT_CODE", code);
//								function.getTableParameterList().setValue("GOODSMVT_ITEM", table);
//								
//								function.execute(destination);
//								JCoTable PRITEM = function.getTableParameterList().getTable("RETURN");
//								System.out.println("NUMBER: "+PRITEM.getNumRows());
//								for (int i = 0; i < PRITEM.getNumRows(); i++) {
//									PRITEM.setRow(i);
//									System.out.println(PRITEM.getString("MESSAGE"));
//								}
//								System.out.println("NUMBER: "+PRITEM.getString("NUMBER")+" MESSAGE: "+PRITEM.getString("MESSAGE"));
					           
								}
							}catch (Exception e) {
								
								e.printStackTrace();
								
							}
						}
						
				} catch (Exception e) {  
					try {
						Thread.sleep( 1 * 60 * 1000);
					} catch (InterruptedException e1) {  
						log.error(e1);  
					}
					log.error(e);  
				}
			}
		}
	}
}
