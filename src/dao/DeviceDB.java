package dao;

import java.sql.ResultSet;

/**
 * Created by lm on 16-7-21.
 */
public class DeviceDB extends AbstractDB {

    public DeviceDB(String driver, String url, String userName, String pass) {
        super(driver, url, userName, pass);
    }

    @Override
    public ResultSet query(String sql, Object... args) throws Exception {
        return execute(sql,args);
    }

    @Override
    public boolean insert(String sql, Object... args) throws Exception {
        return (update(sql, args) > 0)? true: false ;
    }

    @Override
    public boolean modify(String sql, Object... args) throws Exception {
        return (update(sql, args) > 0)? true: false;
    }

    @Override
    public boolean delete(String sql, Object... args) throws Exception {
        return (update(sql, args) > 0)? true: false;
    }
}
