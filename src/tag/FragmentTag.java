package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by lm on 16-7-20.
 */
public class FragmentTag extends SimpleTagSupport {

    private JspFragment fragment;

    public JspFragment getFragment() {
        return fragment;
    }

    public void setFragment(JspFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("<div style=\"padding:10px; border: 1px solid black; border-radius: 25%;\">");
        out.println("动态输出的页面");
        fragment.invoke(null);
        out.println("</div>");
    }
}
