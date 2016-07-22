package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lm on 16-7-20.
 */
public class SecondServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("second init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("this is second");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("second destory");
    }
}
