package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by lm on 16-7-21.
 * 提供一些方法， 具体增删改查由子类实现
 * 自己维护一个COnnection, 不知道有没有问题？
 */
public abstract class AbstractDB implements DB {

    private Connection conn;
    private String driver;
    private String url;
    private String userName;
    private String pass;

    public AbstractDB(String driver, String url, String userName, String pass) {
        this.driver = driver;
        this.url = url;
        this.userName = userName;
        this.pass = pass;
        try {
            this.conn = getConnection();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws Exception{
        if (conn == null) {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, pass);
        }
        return conn;
    }

    public ResultSet execute(String sql, Object... args) throws Exception {
        PreparedStatement stmt = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            stmt.setObject(i+1, args[i]);
        }
        return stmt.executeQuery();
    }

    public int update(String sql, Object... args ) throws Exception {
        PreparedStatement stmt = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            stmt.setObject(i+1, args[i]);
        }
        System.out.println(stmt.toString());
        return stmt.executeUpdate();
    }

    public void close() {
        try{
            if (conn != null && !conn.isClosed()) {
                conn.close();
                conn = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
