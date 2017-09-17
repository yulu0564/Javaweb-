<%@page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../adminhead.jsp">
	<jsp:param value="新闻信息" name="title" />
</jsp:include>
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="../../admin/adminnav.jsp">
			<jsp:param value="newslist" name="fun" />
		</jsp:include>
	</div>
	<div class="container-fluid" style="margin-top: 120px">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div class="panel panel-warning">
					<div class="panel-heading">
						<h3 class="panel-title">新闻信息</h3>
					</div>
					<div class="panel-body">
						<c:if test="${newsinf.id==null }">
							<form method="post" action="add_do.action">
						</c:if>
						<c:if test="${newsinf.id!=null }">
							<form method="post" action="edit_do.action">
						</c:if>
						<input name="id" type="hidden" value="${newsinf.id}">
						<div style="width: 400px; margin-left: 230px">
							<div class="input-group">
								<span class="input-group-addon">标题</span> <input type="text"
									maxlength="20" name="title" value="${ newsinf.title}"
									class="form-control" placeholder="请输入新闻标题" required>
							</div>
						</div>
						<div style="width: 400px; margin-left: 230px">
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

						<div style="width: 400px; margin-left: 230px">
							<div class="input-group" style="margin-top: 30px">
								<span class="input-group-addon">内容</span>
								<textarea maxlength="500" rows="10" name="contect"
									class="form-control" placeholder="请输入内容">${newsinf.contect }</textarea>
							</div>
						</div>
						<div style="width: 400px; margin-left: 230px">
							<div class="input-group" style="margin-top: 30px">
								<span class="input-group-addon">来源</span> <input type="text"
									maxlength="50" name="fromto" value="${newsinf.fromto }"
									class="form-control" placeholder="请输入新闻来源">
							</div>
						</div>
						<button class="btn btn-success"
							style="width: 400px; margin-top: 30px; margin-left: 230px"
							type="submit">提交</button>
						</form>
						<button class="btn btn-default"
							style="width: 400px; margin-top: 20px; margin-left: 230px"
							onClick="javascript :history.back(-1);">返回</button>
					</div>
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>