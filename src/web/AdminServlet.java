package web;

import bean.Admin;
import com.alibaba.fastjson.JSONObject;
import dao.AdminDB;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lm on 16-7-21.
 * 管理员的增删改查
 */
@WebServlet(
        name = "admin",
        urlPatterns = {"/admin"}
)
public class AdminServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        ServletContext sc = getServletContext();
        String driver = sc.getInitParameter("driver");
        String url = sc.getInitParameter("url");
        String user = sc.getInitParameter("userName");
        String pass = sc.getInitParameter("pass");
        AdminDB db = new AdminDB(driver,url,user,pass);
        String userName = req.getParameter("usr");
        String passWord = req.getParameter("pwd");
        PrintWriter out = resp.getWriter();
        try {
            Map<String,Object>  map = new HashMap<String,Object>();
            List<Admin> admins = new ArrayList<Admin>();
            switch (type) {
                case "insert":
                    db.insert("INSERT INTO admin VALUES(?,?)", userName, passWord);
                    break;
                case "query" :
                    ResultSet rs = db.query("select * from admin");
                    while (rs.next()) {
                        Admin admin = new Admin();
                        admin.setAdmin(rs.getString("usr"));
                        admin.setPassWord(rs.getString("pwd"));
                        admins.add(admin);
                    }
                    map.put("admins", admins);
                    break;
                case "update" :
                    db.update("update admin set pwd=? where usr= ?", passWord, userName);
                    break;
                case "delete" :
                    db.delete("delete from admin where usr=?", userName);
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
