package web;

import bean.Device;
import com.alibaba.fastjson.JSONObject;
import dao.DeviceDB;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by lm on 16-7-21.
 */
@WebServlet(
        name = "device",
        urlPatterns = {"/device"}
)
public class DeviceServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=UTF-8");
        String type = req.getParameter("type");
        ServletContext sc = getServletContext();
        String driver = sc.getInitParameter("driver");
        String url = sc.getInitParameter("url");
        String user = sc.getInitParameter("userName");
        String pass = sc.getInitParameter("pass");
        DeviceDB db = new DeviceDB(driver,url,user,pass);
        String alias = req.getParameter("alias");
        boolean open = Boolean.parseBoolean(req.getParameter("open"));
        String belong = req.getParameter("belong");
        String modified = req.getParameter("modified");
        String id = req.getParameter("id");
        PrintWriter out = resp.getWriter();
        try {
            Map<String,Object> map = new HashMap<String,Object>();
            List<Device> devices = new ArrayList<Device>();
            switch (type) {
                case "insert":
                    db.insert("INSERT INTO device VALUES(?,?,?,?,?)", UUID.randomUUID().toString(), alias, open, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), belong);
                    break;
                case "query" :
                    ResultSet rs = db.query("select * from device");
                    while (rs.next()) {
                        Device d = new Device();
                        d.setId(rs.getString("id"));
                        d.setCreated(rs.getTimestamp("created"));
                        d.setModified(rs.getTimestamp("modified"));
                        d.setAlias(rs.getString("alias"));
                        d.setBelong(rs.getString("belong"));
                        devices.add(d);
                    }
                    map.put("devices", devices);
                    break;
                case "update" :
                    db.update("update user set alias=?, modified=?, open=?, belong=? where id=?", alias, modified, open, belong, id );
                    break;
                case "delete" :
                    db.delete("delete from device where id=?", id);
                    break;
            }
            map.put("errcode", 100);
            map.put("errmsg","ok");
            JSONObject root = new JSONObject(map);
            out.print(root.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }
}
