package com.amistrong.express.sap;

import com.sap.conn.jco.JCoAbapObject;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

/**
 * 从sap中取得借款余额
 * @author kmd
 * 2013-06-05
 *
 */
public class LoadBorrowMoneyBalanceFromSAP {

	/*
	 * balanceType	借款类型  01：个人借款余额	02：其他应付借款余额 	 03：供应商的应付款余额
	 * customerEmployeeNumber  客户员工编号
	 * supplierCode  供应商编码
	 * companyCode  公司代码(法人体)
	 * accountNumber  会计科目编号
	 * year   年
	 * month  月
	 */
//	public static String LoadBorrowMoneyBalance(String balanceType,String customerEmployeeNumber,String supplierCode,String companyCode,String accountNumber,String year,String month){
//		String balance="";
//		JCoFunction function = null;
//		//连接sap，其实就类似于连接数据库
//		JCoDestination destination = SAPConn.connect();
//		try {
//			//调用ZRFC_GET_REMAIN_SUM函数
//			function = destination.getRepository().getFunction("ZRFC_GET_REMAIN_SUM");
//			//将当前传入的值赋予各个参数
//			function.getImportParameterList().setValue("I_PARAM", balanceType);
//			function.getImportParameterList().setValue("I_KUNNR", customerEmployeeNumber);		
//			function.getImportParameterList().setValue("I_LIFNR", supplierCode);		
//			function.getImportParameterList().setValue("I_BUKRS", companyCode);		
//			function.getImportParameterList().setValue("I_KOBEZ", accountNumber);
//			function.getImportParameterList().setValue("I_YEAR", year);		
//			function.getImportParameterList().setValue("I_MONTH", month);		
//			function.execute(destination);
//			//获取借款余额
//			balance=function.getExportParameterList().getString("E_REMAIN_SUM");
//			//获返回状态
//			String state=function.getExportParameterList().getString("E_STATUS");
//			//获返回信息
//			String message=function.getExportParameterList().getString("E_MESSAGE");
//			System.out.println("调用返回状态--->"+state);
//			System.out.println("调用返回信息--->"+message);
//		} catch (JCoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		return balance;
//	}
	public static void main(String[] args) {
		JCoFunction function = null;
		JCoDestination destination = SAPConn.connect();
		String n="TL0512007W";//调用接口返回状态
		try {
			//调用ZRFC_GET_REMAIN_SUM函数
			function = destination.getRepository().getFunction("BAPI_PR_GETDETAIL");
			//将当前传入的值赋予各个参数
			function.getImportParameterList().setValue("NUMBER", "TL0512007W");
//			function.getImportParameterList().setValue("ACCOUNT_ASSIGNMENT", "");
//			function.getImportParameterList().setValue("ITEM_TEXT", "");
//			function.getImportParameterList().setValue("HEADER_TEXT", "");
//			function.getImportParameterList().setValue("DELIVERY_ADDRESS", "");
//			function.getImportParameterList().setValue("VERSION", "");
//			String PO_HEADER = function.getExportParameterList().getStructure("PRHEADER").getString("PREQ_NO");
			JCoTable PRITEM = function.getTableParameterList().getTable("PRITEM");
//			JCoTable PRITEM = function.getTableParameterList().getTable("RETURN");
			
			function.execute(destination);
			System.out.println("NUMBER: "+PRITEM.getNumRows());
			for (int i = 0; i < PRITEM.getNumRows(); i++) {
				PRITEM.setRow(i);
				System.out.println(PRITEM.getString("MATERIAL"));
			}
//			System.out.println("NUMBER: "+PRITEM.getString("NUMBER")+" MESSAGE: "+PRITEM.getString("MESSAGE"));
//			function.get
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}