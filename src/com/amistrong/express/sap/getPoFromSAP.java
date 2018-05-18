package com.amistrong.express.sap;

import java.util.List;
import java.util.Map;



//import com.sap.conn.jco.JCoAbapObject;
import com.sap.conn.jco.JCoDestination;
//import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
//import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

/**
 * 从sap中取得借款余额
 * @author kmd
 * 2013-06-05
 *
 */
public class getPoFromSAP {

	public static void main(String[] args) {
		JCoFunction function = null;
		JCoDestination destination = SAPConn.connect();
		String n="4698057479";//调用接口返回状态
		try {
			
			//调用ZRFC_GET_REMAIN_SUM函数
			function = destination.getRepository().getFunction("BAPI_PO_GETDETAIL");
			//将当前传入的值赋予各个参数
			function.getImportParameterList().setValue("PURCHASEORDER", "4698057479");
//			function.getImportParameterList().setValue("ACCOUNT_ASSIGNMENT", "");
//			function.getImportParameterList().setValue("ITEM_TEXT", "");
//			function.getImportParameterList().setValue("HEADER_TEXT", "");
//			function.getImportParameterList().setValue("DELIVERY_ADDRESS", "");
//			function.getImportParameterList().setValue("VERSION", "");
//			String PO_HEADER = function.getExportParameterList().getStructure("PRHEADER").getString("PREQ_NO");
			JCoTable PRITEM = function.getTableParameterList().getTable("PO_ITEMS");
//			JCoTable PRITEM = function.getTableParameterList().getTable("RETURN");
			
			function.execute(destination);
			System.out.println("NUMBER: "+PRITEM.getNumRows());
			for (int i = 0; i < PRITEM.getNumRows(); i++) {
				PRITEM.setRow(i);
				System.out.println(PRITEM.getString("PO_NUMBER"));
			}
//			System.out.println("NUMBER: "+PRITEM.getString("NUMBER")+" MESSAGE: "+PRITEM.getString("MESSAGE"));
//			function.get
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}