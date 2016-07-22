<%--
  Created by IntelliJ IDEA.
  User: lm
  Date: 16-7-20
  Time: 下午4:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="login_frame container-fluid">
        <form class="form-signin" action="login" method="post">
            <h2 class="form-signin-heading text-center">欢迎登陆</h2>
            <label for="usr" class="sr-only">用户：</label>
            <input type="text" name="usr" id="usr" class="form-control" placeholder="请输入用户名" required autofocus>
            <label for="pwd" class="sr-only">密码：</label>
            <input type="password" name="pwd" id="pwd" class="form-control" placeholder="请输入密码" required>
            <div class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me"> 记住我
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
        </form>

</div>