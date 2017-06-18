<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center;">
    <form id="addChapterForm" method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            标题 : <input name="title" class="easyui-textbox" data-options="required:true"/><br/><br/>
            地址 : <input name="pic" class="easyui-filebox" data-options="required:true"/><br/><br/>
            专辑 : <input id="cc" name="album.id" ><br>
            时长 : <input name="duration" class="easyui-textbox" data-options="required:true"/><br/><br/>
            <%--id, title, url, csize, pid, duration--%>
        </div>

    </form>
</div>
<script>
    $(function () {
        $('#cc').combobox({
            url:'/baizhi-cmfz-sys/album/selectAll',
            valueField:'id',
            textField:'title'
        });
    })
</script>