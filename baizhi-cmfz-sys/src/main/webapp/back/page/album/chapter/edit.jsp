<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center;">
    <form id="editChapterForm" method="post" enctype="multipart/form-data">
        <input type="hidden" value="${param.id}" name="id">
        <%--id, title, url, csize, pid, duration--%>
        <div style="margin-top: 10px;">
            标题:<input name="title" class="easyui-textbox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            地址:<input name="pic" class="easyui-filebox" data-options="required:true"/><br/>
        </div>
        <div style="margin-top: 10px;">
            专辑:<input id="cc" name="album.id" ><br>

        </div>
        <div style="margin-top: 10px;">
            时长:<input name="duration" class="easyui-textbox" data-options="required:true"/><br/>
        </div>

    </form>
</div>
<script>

    $(function(){
        //构建子页面元素的操作
        console.log("${param.id}");
        $("#editChapterForm").form('load','/baizhi-cmfz-sys/chapter/selectOne?id=${param.id}');
        $('#cc').combobox({
            url:'/baizhi-cmfz-sys/album/selectAll',
            valueField:'id',
            textField:'title'
        });

    });



</script>