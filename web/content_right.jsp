<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <div id="user_content">
    <h1 class="page-header">用户管理</h1>
    <h2 class="sub-header">用户列表</h2>

    <table id="userlist" data-toggle="table"
           data-search="true"
           data-show-refresh="true"
           data-show-toggle="true"
           data-show-columns="true">
    </table>

    <div id="toolbar" class="btn-group">
        <button id="btn_add" type="button" class="btn btn-default" data-toggle="modal"
                data-target="#myModal">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
        </button>
        <button id="btn_edit" type="button" class="btn btn-default"  >
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
        </button>
        <button id="btn_delete" type="button" class="btn btn-default" >
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
        </button>
    </div>

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close"
                            data-dismiss="modal" aria-hidden="true">
                    </button>
                    <h4 class="modal-title text-center" id="myModalLabel">
                        添加用户
                    </h4>
                </div>
                <div class="modal-body">
                    <div class=" container-fluid">
                        <form class="form-signin" action="login" method="post">
                            <label for="user" class="sr-only">用户：</label>
                            <input type="text" name="user" id="user" class="form-control" placeholder="请输入用户名" required autofocus>
                            <label for="unit" class="sr-only">部门：</label>
                            <input type="text" name="unit" id="unit" class="form-control" placeholder="请输入部门" required>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="open" id="open"> 开启
                                </label>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="modal-footer user">
                    <button type="button" class="btn btn-default"
                            data-dismiss="modal">关闭
                    </button>
                    <button type="button" class="btn btn-primary" id="user_new"
                            data-dismiss="modal">
                        提交
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
    </div>


    <div id="device_content" style="display: none;">
        <h1 class="page-header">设备管理</h1>
        <h2 class="sub-header">设备列表</h2>

        <table id="deviceList" data-toggle="table"
               data-search="true"
               data-show-refresh="true"
               data-show-toggle="true"
               data-show-columns="true">
        </table>

        <div id="toolbar1" class="btn-group">
            <button id="btn_add1" type="button" class="btn btn-default" data-toggle="modal"
                    data-target="#myModal1">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
            </button>
            <button id="btn_edit1" type="button" class="btn btn-default"  >
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
            </button>
            <button id="btn_delete1" type="button" class="btn btn-default" >
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
            </button>
        </div>

        <!-- 模态框（Modal） -->
        <div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
             aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close"
                                data-dismiss="modal" aria-hidden="true">
                        </button>
                        <h4 class="modal-title text-center" id="myModalLabel1">
                            添加设备
                        </h4>
                    </div>
                    <div class="modal-body">
                        <div class=" container-fluid">
                            <form class="form-signin" action="login" method="post">
                                <label for="user" class="sr-only">用户：</label>
                                <input type="text" name="user" id="user1" class="form-control" placeholder="请输入设备别名" required autofocus>
                                <select class="form-control" id="sel1">
                                    <optgroup label="离娄">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                    </optgroup>
                                    <optgroup label="南京">
                                        <option>1</option>
                                        <option>2</option>
                                        <option>3</option>
                                        <option>4</option>
                                    </optgroup>
                                </select>
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox" value="open" id="open1"> 开启
                                    </label>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="modal-footer device">
                        <button type="button" class="btn btn-default"
                                data-dismiss="modal">关闭
                        </button>
                        <button type="button" class="btn btn-primary" id="device_new"
                                data-dismiss="modal">
                            提交
                        </button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
    </div>