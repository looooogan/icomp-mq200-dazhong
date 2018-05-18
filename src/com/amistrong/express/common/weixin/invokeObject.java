package com.amistrong.express.common.weixin;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class invokeObject {
	public static String getObjectValue(Object object) throws Exception {  
		String[] strList = {"","","","","","","","","","","","","","","","","","","","",""};
		String rtnStr = "";
		int i = 0;
        if (object != null) {
            // 拿到该类  
            Class<?> clz = object.getClass();  
            // 获取实体类的所有属性，返回Field数组  
            Field[] fields = clz.getDeclaredFields();  
            for (Field field : fields) {
            	if ("sign".equals(field.getName()) || "paySign".equals(field.getName()) || "successflg".equals(field.getName())){
            		continue;
            	}
                // 如果类型是String  
                if (field.getGenericType().toString().equals(  
                        "class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名  
                    // 拿到该属性的gettet方法  
                    Method m = (Method) object.getClass().getMethod(  
                            "get" + getMethodName(field.getName()));  
                    // 调用getter方法获取属性值  
                    String val = (String) m.invoke(object);
                    if (val != null) {  
                    	if ("pay_package".equals(field.getName())){
                    		strList[i] = "package="+val;
                    	} else {
                    		strList[i] = field.getName()+"="+val;
                    	}
                    	i++;
                    }
                }  
                // 如果类型是Integer  
                if (field.getGenericType().toString().equals(  
                        "class java.lang.Integer")) {  
                    Method m = (Method) object.getClass().getMethod(  
                            "get" + getMethodName(field.getName()));  
                    Integer val = (Integer) m.invoke(object);  
                    if (val != null) {  
                    	strList[i] = field.getName()+"="+val;
                    	i++;
                    }
                }
                
                // 如果类型是long  
                if (field.getGenericType().toString().equals(  
                        "class java.lang.Long")) {  
                    Method m = (Method) object.getClass().getMethod(  
                            "get" + getMethodName(field.getName()));  
                    Long val = (Long) m.invoke(object);  
                    if (val != null) {  
                    	strList[i] = field.getName()+"="+val;
                    	i++;
                    }
                }
            }
        }
        Arrays.sort(strList); // 字典序排序
        for (int j =0 ; j< strList.length;j++){
        	if ("".equals(strList[j]))continue;
        	rtnStr += strList[j] + "&";
        }
        return rtnStr;
    }  
    // 把一个字符串的第一个字母大写、效率是最高的、  
    private static String getMethodName(String fildeName) throws Exception{  
        byte[] items = fildeName.getBytes();  
        items[0] = (byte) ((char) items[0] - 'a' + 'A');  
        return new String(items);  
    } 
}
