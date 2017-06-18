<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2017/6/11
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        var $dg,$da;
        $(function(){
            $dg = $("#albumdg");
            $da = $("#albumda");
            $dg.datagrid({
                url:'/baizhi-cmfz-sys/album/selectAll',
                // fit:true,
                autoRowHeight:true,
                /*图片:<input name="thumbnail" class="easyui-filebox" data-options="required:true"/><br/>
                 标题:<input name="title" class="easyui-textbox" data-options="required:true"/><br/>
                 评分:<input name="score" class="easyui-textbox" data-options="required:true"/><br/>
                 作者:<input name="author" class="easyui-textbox" data-options="required:true iconCls='icon-man'"/><br/>
                 播音员:<input name="broadcast" class="easyui-textbox" data-options="required:true"/><br/>
                 创建日期:<input name="createDate" class="easyui-textbox" data-options="required:true"/><br/>
                 详情:<input name="brief" class="easyui-textbox" data-options="required:true"/><br/>*/
                columns:[[
                    {title:"编号",field:"id",width:220,align:'center'},
                    {title:"图片",field:"thumbnail",width:300,align:'center'},
                    {title:"标题",field:"title",width:200,align:'center'},
                    {title:"评分",field:"score",width:50,align:'center'},
                    {title:"作者",field:"author",width:250,align:'center'},
                    {title:"播音",field:"broadcast",width:250,align:'center'},
                    {title:"日期",field:"createdate",width:250,align:'center'},
                    {title:"详情",field:"brief",width:250,align:'center'},
                    {title:"操作",field:"options",width:250,align:'center',
                        formatter:function(value,row,index){
                            return  "<a class='del' onClick=\"del('"+ row.id +"')\" href='javascript:;'>删除</a>&nbsp;&nbsp;" +
                                    "<a class='edit' onClick=\"editRow('"+ row.id +"')\"  href='javascript:;'>修改</a>";
                        }
                    }
                ]],
                onLoadSuccess:function(data){
                    $(".del").linkbutton({
                        plain:true,
                        iconCls:'icon-remove',

                    });
                    $(".edit").linkbutton({
                        plain:true,
                        iconCls:'icon-edit',
                    });
                },
                pagination:true,
                pageNumber:1,
                pageSize:10,
                pageList:[2,4,6,8,10],
                toolbar:'#albumtb',
            });
        });

        //删除的操作
        function del(id){
            $.messager.confirm("提示","您确定要删除吗?",function(r){
                if(r){
                    //发送异步请求删除数据
                    $.get('/baizhi-cmfz-sys/album/delete',{"id":id});
                    $dg.datagrid('reload');
                }
            });
        }

        //添加的操作
        function addAl() {
            $da.dialog({
                width:600,
                height:400,
                title:"请填写轮播图的信息",
                iconCls:"icon-man",
                href:'/baizhi-cmfz-sys/back/page/album/info/add.jsp',
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:saveAlbum,
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:closeAl,
                }],

            });

        }

        //修改的操作
        function editRow(id){
            $da.dialog({
                width:600,
                height:300,
                title:"轮播图信息",
                iconCls:"icon-man",
                href:'${pageContext.request.contextPath}/back/page/album/info/edit.jsp?id='+id,
                buttons:[{
                    text:'保存',
                    iconCls:'icon-save',
                    handler:upAlbum,
                },{
                    text:'关闭',
                    iconCls:'icon-cancel',
                    handler:closeAl,
                }]

            });

        }


        //修改
        function upAlbum(){
            $("#editAlbumForm").form('submit',{
                url:'/baizhi-cmfz-sys/album/update',
                success:function(){
                    $da.dialog('close',true);
                    $dg.datagrid('reload');
                }
            });
        }

        //保存
        function saveAlbum(){
            $("#addAlbumForm").form('submit',{
                url:'/baizhi-cmfz-sys/album/insert',
                success:function(){
                    $da.dialog('close',true);
                    $dg.datagrid('reload');
                }
            });
        }

        //关闭对话框
        function closeAl(){
            $da.dialog('close',true);
        }
    </script>
</head>


<div data-options="region:'center',">
    <table id="albumdg" ></table>

    <div id="albumda"></div>

    <div id="albumtb">
        <a href="javascript:;" onClick="addAl()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
    </div>
</div>

</html>
