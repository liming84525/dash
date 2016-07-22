package dao;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by lm on 16-7-21.
 * 数据库操作的接口
 */
public interface DB {

    Connection getConnection() throws Exception;
    ResultSet query(String sql, Object... args) throws Exception;
    boolean insert(String sql, Object... args) throws Exception;
    boolean modify(String sql, Object... args) throws Exception;
    boolean delete(String sql, Object... args) throws Exception;
    void close();
}
