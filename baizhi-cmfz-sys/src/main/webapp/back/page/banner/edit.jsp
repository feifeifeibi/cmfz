<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center;">
    <form id="editBannerForm" method="post" enctype="multipart/form-data">
        <input type="hidden" value="${param.id}" name="id">
        <div style="margin-top: 10px;">
            名称:<input name="name" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
        <div style="margin-top: 10px;">
            图片:<input name="pic" class="easyui-filebox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            状态:<input name="status" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'"/><br/>
        </div>
    </form>
</div>
<script>

    $(function(){
        //构建子页面元素的操作
        console.log("${param.id}");
        $("#editBannerForm").form('load','/baizhi-cmfz-sys/banner/selectOne?id=${param.id}');

    });



</script>