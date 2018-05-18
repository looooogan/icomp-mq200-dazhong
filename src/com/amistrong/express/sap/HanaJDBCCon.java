package com.amistrong.express.sap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class HanaJDBCCon {
 
    /**
     * 定义链接需要的字符串
     */
    private static final String str1 = "com.sap.db.jdbc.Driver";
    private static final String url = "jdbc:sap://10.228.4.238:30115?reconnect=true";
    private static final String user = "HANA_PBW_CONNECT_READ";
    private static final String password = "PrdInit1234!";
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
 
    /**
     * 加载驱动类
     */
    static {
 
        try {
            Class.forName(str1);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
    /**
     * 建立链接的方法
     *
     * @return
     */
    private Connection getConnection() {
 
        try {
            conn = DriverManager.getConnection(url, user, password);
 
        } catch (Exception e) {
            // TODO: handle exception
        }
        return conn;
 
    }
 
    /**
     * 使用prepareStatement来预编译查询语句 然后传参数的值来作为条件查询数据库 返回list
     *
     * @param id
     * @return
     */
    public List getData(String sql, Object[] array) {
        // SQL语句
        List list = new ArrayList();
        conn = this.getConnection();
        try {
            // 预编译
            st = conn.prepareStatement(sql);
            // 利用方法传入参数
            for (int i = 0; i < array.length; i++) {
                st.setObject(i + 1, array[i]);
            }
            // 执行查询
            rs = st.executeQuery();
            while (rs.next()) {
                Map map = new HashMap();
 
                ResultSetMetaData rsmd = rs.getMetaData();
                // 以列名为键 存储每一行数据进map
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
 
                    map.put(rsmd.getColumnName(i), rs.getObject(i));
 
                }
                // 将每一个map加入list 这样list的到就是每一行
                list.add(map);
 
            }
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // 关闭连接
            this.close();
        }
        return list;
 
    }
    
    public List getData(String sql) {
        // SQL语句
        List list = new ArrayList();
        conn = this.getConnection();
        try {
            // 预编译
            st = conn.prepareStatement(sql);
            // 执行查询
            rs = st.executeQuery();
            while (rs.next()) {
                Map map = new HashMap();
 
                ResultSetMetaData rsmd = rs.getMetaData();
                // 以列名为键 存储每一行数据进map
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
 
                    map.put(rsmd.getColumnName(i), rs.getObject(i));
 
                }
                // 将每一个map加入list 这样list的到就是每一行
                list.add(map);
 
            }
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // 关闭连接
            this.close();
        }
        return list;
 
    }
 
    /**
     * 更新数据的方法
     *
     * @param sql
     * @param array
     * @return
     */
    public int update(String sql, Object array[]) {
        conn = this.getConnection();
        int line = 0;
        try {
 
            st = conn.prepareStatement(sql);
            // 传参数
            for (int i = 0; i < array.length; i++) {
                st.setObject(i + 1, array[i]);
            }
 
            line = st.executeUpdate();
            // 判断是否修改成功
            if (line > 0) {
                return line;
 
            } else {
 
                System.out.println("更新失败");
            }
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        } finally {
            // 关闭连接
            this.close();
        }
        return 0;
    }
    
    public int update(String sql) {
        conn = this.getConnection();
        int line = 0;
        try {
 
            st = conn.prepareStatement(sql);
 
            line = st.executeUpdate();
            // 判断是否修改成功
            if (line > 0) {
                return line;
 
            } else {
 
                System.out.println("更新失败");
            }
 
        } catch (SQLException e) {
 
            e.printStackTrace();
        } finally {
            // 关闭连接
            this.close();
        }
        return 0;
    }
 
    /**
     * 关闭连接
     */
    private void close() {
 
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
 
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
 
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
