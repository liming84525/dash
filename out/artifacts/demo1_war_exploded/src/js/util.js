/**
 * Created by lm on 16-7-22.
 */
function date2str(x, y) {
    var z = {
        y: x.getFullYear(),
        M: x.getMonth() + 1,
        d: x.getDate(),
        h: x.getHours(),
        m: x.getMinutes(),
        s: x.getSeconds()
    };
    return y.replace(/(y+|M+|d+|h+|m+|s+)/g, function(v) {
        return ((v.length > 1 ? "0" : "") + eval('z.' + v.slice(-1))).slice(-(v.length > 2 ? v.length : 2))
    });
}



$(function() {
        $usertable = $('#userlist');
        $devicetable =$('#deviceList');
        var list = new Array();

        $usertable.bootstrapTable({
            url:'/user',
            queryParams: function(p) {
                return {type:"query"};
            },
            responseHandler: function(res) {
                populate(res.users);
                return res.users;  //这里拿到要解析的数据
            },
            height: 460,
            toolbar: '#toolbar',
            columns: [{
                    field: 'select',
                    title: '选择',
                    checkbox: true
            }, {
                   field: 'id',
                   title: '序号',
                   sortable: true
               }, {
                   field: 'name',
                   title: '姓名',
                   sortable: true,
                    editable: {
                        type: 'text'
                    }
               }, {
                   field: 'unit',
                   title: '部门',
                   sortable: true,
                   editable: {
                       type: 'text'
                   }
               }, {
                   field: 'open',
                   title: '是否开启',
                   sortable: true,
                   editable: {
                       type: 'text'
                   }
               }, {
                   field: 'created',
                   title: '创建时间',
                   sortable: true
               }],
               search:true,
               clickToSelect: true
        });


    $(".modal-footer.user .btn-primary").on("click",function(){
        var name = $("#user").val();
        var unit = $("#unit").val();
        var open = $("#open").is(":checked");
        $.get( "user", {
            type:"insert",
            name:name,
            unit:unit,
            open:open
        },function(res){
            $usertable.bootstrapTable('refresh');
        },'json')
    });

    $("#btn_delete").on("click",function(){
        var selects = $usertable.bootstrapTable('getSelections');
        for (var i in selects) {
            var item = selects[i];
            $.get("user",{
                type:"delete",
                id: item.id
            },function(res){
                $usertable.bootstrapTable('refresh');
            },'json')
        }
    });

    $("#btn_edit").on("click",function(){
        var selects = $usertable.bootstrapTable('getSelections');
        for (var i in selects) {
            var item = selects[i];
            alert(item.name);
            $.get("user",{
                type:"update",
                id: item.id,
                name: item.name,
                unit: item.unit,
                open: item.open
            },function(res){
                $usertable.bootstrapTable('refresh');
            },'json')
        }
    });


    $devicetable.bootstrapTable({
        url:'/device',
        queryParams: function(p) {
            return {type:"query"};
        },
        responseHandler: function(res) {
            return res.devices;  //这里拿到要解析的数据
        },
        height: 460,
        toolbar: '#toolbar1',
        columns: [{
            field: 'select',
            title: '选择',
            checkbox: true
        }, {
            field: 'id',
            title: '序号',
            sortable: true
        }, {
            field: 'alias',
            title: '别名',
            sortable: true,
            editable: {
                type: 'text'
            }
        }, {
            field: 'open',
            title: '是否开启',
            sortable: true,
            editable: {
                type: 'text'
            }
        }, {
            field: 'created',
            title: '创建时间',
            sortable: true
        }, {
            field: 'modified',
            title: '修改时间',
            sortable: true
        }, {
            field: 'associated',
            title: '外键',
            visible: false
        }],
        search:true,
        clickToSelect: true
    });

    $("#btn_delete1").on("click",function(){
        var selects = $devicetable.bootstrapTable('getSelections');
        for (var i in selects) {
            var item = selects[i];
            $.get("device",{
                type:"delete",
                id: item.id
            },function(res){
                $usertable.bootstrapTable('refresh');
            },'json')
        }
    });

    $("#btn_edit1").on("click",function(){
        var selects = $devicetable.bootstrapTable('getSelections');
        for (var i in selects) {
            var item = selects[i];
            alert(item.name);
            $.get("device",{
                type:"update",
                id: item.id,
                name: item.alias,
                open: item.open,
                modified: item.modified
            },function(res){
                $devicetable.bootstrapTable('refresh');
            },'json')
        }
    });

    $(".modal-footer.device .btn-primary").on("click",function(){
        var name = $("#user1").val();
        var open = $("#open1").is(":checked");
        $.get( "device", {
            type:"insert",
            alias:name,
            open:open
        },function(res){
            $usertable.bootstrapTable('refresh');
        },'json')
    });

    function populate(elm){
        list = [];
        for (var i in elm) {
            var item = elm[i];
            if (list.length == 0) {
                var obj = {
                    sup: item.unit,
                    sub: {
                        name : new Array(),
                        id : new Array()
                    }
                }
                obj.sub.name.push(item.name);
                obj.sub.id.push(item.id);
                list.push(obj)
            } else {
                for (var k in list) {
                    var o = list[k]
                    if (item.unit == o.sup) {
                        for (var j in o.sub.name) {
                            var s = o.sub.name[j]
                            if (s.name == item.name) {
                                continue;
                            }else {
                                o.sub.name.push(item.name )
                                o.sub.id.push(item.id)
                            }
                        }
                    } else {
                        for (var kk in list) {
                            var ss = list[kk]
                            if (ss.unit == item.unit) {
                                continue
                            } else {
                                var oo = {
                                    sup: item.unit,
                                    sub: {
                                        name : new Array(),
                                        id : new Array()
                                    }
                                }
                                oo.sub.name.push(item.name);
                                oo.sub.id.push(item.id);
                                list.push(oo);
                                break;
                            }
                        }
                    }
                }
            }
        }
        alert(JSON.stringify(list));
    }
});
