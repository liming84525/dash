<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-sm-3 col-md-2 sidebar">
    <ul class="mynav nav nav-sidebar">
        <li class="active" id="users"><a href="#">用户管理 <span class="sr-only">(current)</span></a></li>
        <li id="devices"><a href="#">设备管理</a></li>
        <li id="messages"><a href="#">消息管理</a></li>
    </ul>
    <script>
        $(function(){
            $(".mynav li").on("click",function(){
                $(this).addClass("active").siblings().removeClass("active");
                switch ($(this).attr("id")) {
                    case "users":
                        $("#user_content").show().siblings().hide();
                        break;
                    case "devices":
                        $("#device_content").show().siblings().hide();
                        break;
                    case "messages":
                        break;
                }
            })
        })
    </script>
</div>