<%@ page import="com.sun.org.apache.xerces.internal.impl.dtd.models.DFAContentModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">管理控制台</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <%
                    String login = (String)session.getAttribute("login");
                    String user = (String)session.getAttribute("user");
                    if (login.equals("true")) {
                        out.println("<li><a href=\"/admin.jsp\">"+ user +"</a></li>");
                    } else {
                        out.println("<li><a href=\"/login.jsp\">登陆</a></li>");
                    }
                %>
            </ul>
        </div>
    </div>
</nav>
