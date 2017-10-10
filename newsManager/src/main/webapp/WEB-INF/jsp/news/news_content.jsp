<%@page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="row">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-8">
                            <h2>${newsinf.title }</h2>
                            <div>
                                <c:if test="${collects==null}">
                                    <button type="button" class="btn btn-sm btn-warning pull-right"
                                            onclick="collect(this)">
                                        收藏
                                    </button>
                                </c:if>
                                <c:if test="${collects!=null}">
                                    <button type="button" class="btn btn-sm btn-warning pull-right"
                                            onclick="delete_do(this)">
                                        取消收藏
                                    </button>
                                </c:if>
                            </div>
                            <p>
                                <small>${newsinf.fromuser}<cite
                                        style="margin-left: 10px">${newsinf.time}</cite><br>${newsinf.fromto}
                                </small>
                            </p>
                            ${newsinf.contect}
                        </div>
                    </div>
                </div>
            </div>
            <div class="row" style="margin-top: 80px">
                <div class="col-md-12">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#">全部评论</a></li>
                    </ul>
                    <div class="media">

                        <c:if test="${commentslist ne null}">
                            <c:forEach items="${commentslist}" var="commentslist"
                                       varStatus="vs">
                                <a href="#" class="pull-left"><img
                                        alt="Bootstrap Media Preview"
                                        src="${pageContext.request.contextPath}/res/images/head.jpg"
                                        class="media-object" style="height: 30px"/></a>
                                <div class="media-body">
                                    <h4 class="media-heading">${commentslist.username}</h4>
                                        ${commentslist.contects}
                                    <p style="position: absolute; right: 10px">
                                        <small><cite>--${commentslist.time}</cite></small>
                                    </p>
                                    <div class="media">
                                        <a href="#" class="pull-left"><img
                                                alt="Bootstrap Media Another Preview"
                                                src="${pageContext.request.contextPath}/res/images/head.jpg"
                                                class="media-object" style="height: 30px"/></a>
                                        <div class="media-body">
                                            <h4 class="media-heading">回复功能</h4>
                                            回复功能暂未完成
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
            </div>
            <c:if test="${userid==null}">
                <center>
                    <h3>登录后才能评论</h3>
                    <button id="modal-181250" href="#modal-container-181250"
                            class="btn btn-success" data-toggle="modal">登录
                    </button>
                    <button id="modal-181251" href="#modal-container-181251"
                            class="btn btn-default" data-toggle="modal">注册
                    </button>
                </center>
            </c:if>
            <c:if test="${userid!=null}">
                <form action="add_comments" method="post">
                    <input type="hidden" name="userid" value="${userid }"> <input
                        type="hidden" name="newsid" value="${newsinf.id }">
                    <textarea rows="6" class="col-md-12" style="margin-top: 80px"
                              maxlength="100" name="contects"></textarea>
                    <button type="submit" style="margin-top: 10px; width: 100px"
                            class="btn btn-primary pull-right">发表评论
                    </button>
                </form>
            </c:if>
        </div>
        <div class="col-md-1"></div>
    </div>
</div>

<script>
    function collect(obj) {
        if ("${newsinf.id}" != "") {
            var AjaxURL = "${pageContext.request.contextPath}/collect/collect2?newsid=${newsinf.id}&userid=${userid}";
            var objFu = $(obj).parent();
            $.ajax({
                type: 'get',
                url: AjaxURL,
                cache: false,
                dataType: 'json',
                success: function (data) {
                    if (data["code"] == 0) {
                        alert(data["msg"]);
                        objFu.empty();
                        objFu.append($("<button type=\"button\" class=\"btn btn-sm btn-warning pull-right\" onclick=\"delete_do(this)\">\n" +
                            "                                    取消收藏\n" +
                            "                                </button>"));
                    }
                }
            });
        } else {
            alert("请先登录");
        }
    }

    function delete_do(obj) {
        var AjaxURL = "${pageContext.request.contextPath}/collect/delete_do?id=${collects.id}&userid=${userid}";
        var objFu = $(obj).parent();
        $.ajax({
            type: 'get',
            url: AjaxURL,
            cache: false,
            dataType: 'json',
            success: function (data) {
                if (data["code"] == 0) {
                    alert(data["msg"]);
                    objFu.empty();
                    objFu.append($(" <button type=\"button\" class=\"btn btn-sm btn-warning pull-right\"\n" +
                        "                                            onclick=\"collect(this)\">\n" +
                        "                                        收藏\n" +
                        "                                    </button>"));
                }
            }
        });
    }

</script>