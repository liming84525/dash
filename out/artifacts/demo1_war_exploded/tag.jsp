<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%--
  Created by IntelliJ IDEA.
  User: lm
  Date: 16-7-20
  Time: 下午1:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="WEB-INF/tag.tld" prefix="mytag" %>
<html>
<head>
    <title>tag</title>
</head>
<body>
    <mytag:Hello/>
    <%
        List<String> list = Arrays.asList("中国","美国","日本");
        pageContext.setAttribute("list",list);
    %>
    <table border="1px solid black">
        <mytag:list collection="list" obj="obj">
            <tr>
                <td>${pageScope.obj}</td>
            </tr>
        </mytag:list>
    </table>


    <%--<h2>fragemnt 标签</h2>--%>
    <%--<mytag:fragment>--%>
        <%--<jsp:attribute name="fragment">--%>
            <%--<mytag:Hello/>--%>
        <%--</jsp:attribute>--%>
    <%--</mytag:fragment>--%>
    <%--<br>--%>
    <%--<mytag:fragment>--%>
        <%--<jsp:attribute name="fragment">--%>
            <%--${pageContext.request.remoteAddr}--%>
        <%--</jsp:attribute>--%>
    <%--</mytag:fragment>--%>
</body>
</html>
