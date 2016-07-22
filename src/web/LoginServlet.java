package web;

import dao.AdminDB;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by lm on 16-7-20.
 */
@WebServlet(
        name = "login",
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        HttpSession session = req.getSession();
        String login = (String)session.getAttribute("login");
        String uu = (String)session.getAttribute("user");
        System.out.println(login);
        System.out.println(uu);
        String usr = req.getParameter("usr");
        String pwd = req.getParameter("pwd");
        if (login.equals("true")){
            req.setAttribute("login", true);
            req.setAttribute("user", usr);
            req.getRequestDispatcher("main.jsp").forward(req, resp);
            return;
        }
        //判断是否登陆
        ServletContext sc = getServletContext();
        String driver = sc.getInitParameter("driver");
        String url = sc.getInitParameter("url");
        String user = sc.getInitParameter("userName");
        String pass = sc.getInitParameter("pass");
        AdminDB admin = new AdminDB(driver, url, user, pass);
        boolean verified = admin.verify("select * from admin where usr=? and pwd=?", usr, pwd );
        admin.close();
        if ( !verified ) {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            session.setAttribute("login", "true");
            session.setAttribute("user", usr);
            req.setAttribute("login", true);
            req.setAttribute("user", usr);
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
    }
}
