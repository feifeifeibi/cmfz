<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<div style="text-align: center;">
    <form id="addAlbumForm" method="post" enctype="multipart/form-data">
        <div style="margin-top: 70px;">
            图片 : <input name="pic" class="easyui-filebox" data-options="required:true"/><br/><br/>
            标题 : <input name="title" class="easyui-textbox" data-options="required:true"/><br/><br/>
            评分 : <input name="score" class="easyui-textbox" data-options="required:true"/><br/><br/>
            作者 : <input name="author" class="easyui-textbox" data-options="required:true"/><br/><br/>
            播音 : <input name="broadcast" class="easyui-textbox" data-options="required:true"/><br/><br/>
            详情 : <input name="brief" class="easyui-textbox" data-options="required:true"/><br/><br/>
            <%--id, thumbnail, title, score, author, broadcast, createDate, brief--%>
        </div>
    </form>
</div>