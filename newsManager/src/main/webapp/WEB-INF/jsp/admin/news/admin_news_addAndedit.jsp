<%@page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../../newshead.jsp">
        <jsp:param value="新闻信息" name="title"/>
    </jsp:include>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/res/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/res/ueditor/ueditor.all.min.js"></script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/res/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
<div class="container-fluid">
    <jsp:include page="../../admin/adminnav.jsp">
        <jsp:param value="newslist" name="fun"/>
    </jsp:include>
</div>
<div class="container-fluid" style="margin-top: 120px">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-10">
            <div class="panel panel-warning">
                <div class="panel-heading">
                    <h3 class="panel-title">新闻信息</h3>
                </div>
                <div class="panel-body">
                    <c:if test="${newsinf.id==null }">
                    <form  id="myform" >
                        </c:if>
                        <c:if test="${newsinf.id!=null }">
                        <form method="post" action="edit_do.action">
                            </c:if>
                            <input name="id" type="hidden" value="${newsinf.id}">
                            <div style="width: 660px; margin-left: 100px">
                                <div class="input-group">
                                    <span class="input-group-addon">标题</span> <input type="text"
                                                                                     maxlength="20" name="title"
                                                                                     value="${ newsinf.title}"
                                                                                     class="form-control"
                                                                                     placeholder="请输入新闻标题" required>
                                </div>
                            </div>
                            <div style="width: 660px; margin-left: 100px">
                                <div class="input-group" style="margin-top: 30px">
                                    <span class="input-group-addon">分类</span> <select
                                        class="form-control" name="sort">
                                    <c:if test="${sortlist ne null}">
                                        <c:forEach items="${sortlist}" var="sort" varStatus="vs">
                                            <c:if test="${sort.id==1 }">
                                                <option value="${sort.id}" selected="selected">${sort.sortname}</option>
                                            </c:if>
                                            <c:if test="${sort.id!=1 }">
                                                <option value="${sort.id}">${sort.sortname}</option>
                                            </c:if>
                                        </c:forEach>
                                    </c:if>
                                </select>
                                </div>
                            </div>

                                <div style="width: 660px; margin-left: 100px">
                                    <div class="input-group" style="margin-top: 30px">
                                        <span class="input-group-addon">来源</span> <input type="text"
                                                                                         maxlength="50" name="fromto"
                                                                                         value="${newsinf.fromto }"
                                                                                         class="form-control"
                                                                                         placeholder="请输入新闻来源">

                                    </div>
                                </div>
                                <div style="width: 660px; margin-left: 100px">
                                    <div class="input-group" style="margin-top: 30px">
                                        <span class="input-group-addon">摘要</span>
                                        <textarea maxlength="300" rows="10" name="digest"
                                                  class="form-control" placeholder="请输入内容">${newsinf.digest}</textarea>
                                    </div>
                                </div>

                            <div style="width: 660px; margin-left: 100px">
                                <div class="input-group" style="margin-top: 30px">
                                    <span class="input-group-addon">内容</span>
                                    <%--<textarea maxlength="500" rows="10" name="contect"--%>
                                              <%--class="form-control" placeholder="请输入内容">${newsinf.contect }</textarea>--%>
                                        <script id="editor" type="text/plain"
                                                style="height:300px;width: 600px"></script>
                                </div>
                            </div>

                        </form>
                         <button class="btn btn-success"
                                style="width: 400px; margin-top: 30px; margin-left: 230px"
                                onclick="addDo()">提交
                                    </button>
                        <button class="btn btn-default"
                                style="width: 400px; margin-top: 20px; margin-left: 230px"
                                onClick="javascript :history.back(-1);">返回
                        </button>
                </div>
            </div>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>
<script type="text/javascript">

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');
     function  addDo(){
         var AjaxURL= "${pageContext.request.contextPath}/admin/news/add_do";
         var contect = UE.getEditor('editor').getContent()
         var dataParam = $("#myform").serializeArray();
         dataParam.push({"name":"contect","value":contect})
         alert(AjaxURL);
         $.ajax({
             type:'post',
             url:AjaxURL,
             data:dataParam,
             cache:false,
             success:function(data){
                 alert("请求成功");
             }
         });
     }
</script>
</body>
</html>