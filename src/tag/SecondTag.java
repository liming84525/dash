package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by lm on 16-7-20.
 * 迭代一个集合
 */
public class SecondTag extends SimpleTagSupport {

    //标签属性
    private String collection;
    private String obj;

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    @Override
    public void doTag() throws JspException, IOException {
        Collection items = (Collection)getJspContext().getAttribute(collection);
        for (Object item : items ) {
            getJspContext().setAttribute(obj,item);
            System.out.println(item+";"+obj);
            getJspBody().invoke(null);
        }

    }
}
