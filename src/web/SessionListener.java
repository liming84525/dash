package web;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lm on 16-7-21.
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {

        HttpSession session = se.getSession();
        ServletContext app = session.getServletContext();
        //session id
        String sessionId = session.getId();
        if (session.isNew()) {
            session.setMaxInactiveInterval(24*60*60);
            String user = (String)session.getAttribute("user");
            String islogin = (String)session.getAttribute("login");
            islogin = (islogin == null)? "false" : islogin;
            user = (user == null)? "游客" : user;
            session.setAttribute("login", islogin);
            session.setAttribute("user", user);
            Map<String, String> online = (Map<String,String>)app.getAttribute("online");
            if (online == null) {
               online = new HashMap<String, String>();
            }
            online.put(sessionId, user);
            app.setAttribute("online", online);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session 销毁");
    }
}
