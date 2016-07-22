package web;

import bean.User;
import com.alibaba.fastjson.JSONObject;
import dao.UserDB;

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
 * 用户的增删改查
 */
@WebServlet(
        name = "user",
        urlPatterns = {"/user"}
)
public class UserServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=UTF-8");
        String type = req.getParameter("type");
        ServletContext sc = getServletContext();
        String driver = sc.getInitParameter("driver");
        String url = sc.getInitParameter("url");
        String user = sc.getInitParameter("userName");
        String pass = sc.getInitParameter("pass");
        UserDB db = new UserDB(driver,url,user,pass);
        String name = req.getParameter("name");
        boolean open = Boolean.parseBoolean(req.getParameter("open")); //req.getParameter("open")
        String unit = req.getParameter("unit");
        String id = req.getParameter("id");
        PrintWriter out = resp.getWriter();
        try {
            Map<String,Object>  map = new HashMap<String,Object>();
            List<User> users = new ArrayList<User>();
            switch (type) {
                case "insert":
                    db.insert("INSERT INTO user VALUES(?,?,?,?,?)", UUID.randomUUID().toString(), name, unit, open, new Timestamp(System.currentTimeMillis()));
                    break;
                case "query" :
                    ResultSet rs = db.query("select * from user");
                    while (rs.next()) {
                        User u = new User();
                        u.setId(rs.getString("id"));
                        u.setName(rs.getString("name"));
                        u.setOpen(rs.getBoolean("open"));
                        u.setUnit(rs.getString("unit"));
                        u.setCreated(rs.getTimestamp("created"));
                        System.out.println(u.getCreated().toString());
                        users.add(u);
                    }
                    map.put("users", users);
                    break;
                case "update" :
                    db.update("update user set name=?, unit=?, open=? where id=?", name, unit, open, id );
                    break;
                case "delete" :
                    db.delete("delete from user where id=?", id);
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
