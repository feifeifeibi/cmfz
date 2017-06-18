
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/css/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/css/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/js/form.validator.rules.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/js/easyui-lang-zh_CN.js"></script>

    <script>
        $(function () {
            $("#btn").linkbutton({
                onClick:subForm,
            })
        })
        //用来提交表单
        function subForm(){
            $("#ff").form('submit',{
                url:'/baizhi-cmfz-sys/admin/selectByName',
                success:function(date){
                    /*把json转化为前端对象*/
                    var e=eval('('+date+')');
                    console.log(e.name);
                    if(e.name){
                        location.href="/baizhi-cmfz-sys/back/page/main/main.jsp";
                    }
                }
            })

        }
    </script>
</head>
    <body style="background-image:url(/baizhi-cmfz-sys/back/img/CM.png);">
        <form method="post" id="ff">
            <div id="w" style="width:250px;height:310px;padding:0px 70px 20px 70px;margin-left:auto;margin-top: 150px;margin-right:auto;border:transparent solid 1px;background-color:navajowhite";>
                <div style="text-align: center;height:88px;">
                    <p  style="font-size: 50px; font-family:'Adobe Caslon Pro Bold'; color:#b83400;">持明法洲</p><br><br>
                </div>
                <div>
                    <div style="margin-bottom:10px">
                        <input class="easyui-textbox" name="username" id="logname" style="width:100%;height:30px;padding:12px" data-options="prompt:'用户',required:true,iconCls:'icon-man',iconWidth:38"><br>
                    </div>
                    <div style="margin-bottom:20px">
                        <input class="easyui-textbox" name="password" id="logpass" type="password" style="width:100%;height:30px;padding:12px;" data-options="prompt:'登录密码',required:true,iconCls:'icon-lock',iconWidth:38">
                    </div>
                    <div style="margin-bottom:20px">
                        <input type="checkbox" checked="checked" id="logrem">
                        <span>Remember me</span>
                    </div>
                    <div>
                        <a href="javascript:;" id="btn" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:49%;">
                            <span style="font-size:14px;">登录</span>
                        </a>
                        <a href="javascript:;" id="btn1" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:49%;">
                            <span style="font-size:14px;">注册</span>
                        </a>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
