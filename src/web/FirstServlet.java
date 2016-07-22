package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lm on 16-7-20.
 * servlet with annotation
 */
@WebServlet(name = "first",
        urlPatterns = {"/first"},
        initParams = {
                @WebInitParam(name = "name", value = "liming", description = "prank"),
                @WebInitParam(name = "age", value = "32", description = "age")
        },
        loadOnStartup = 1
)
public class FirstServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init");
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.write("hello, this is first");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy");
    }
}
