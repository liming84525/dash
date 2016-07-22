package web;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by lm on 16-7-20.
 */
public class TimerServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
//        Timer t = new Timer(1000, (event) -> System.out.println(new Date()));
//        t.start();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
