<%@page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="newshead.jsp">
	<jsp:param value="新闻-列表" name="title" />
</jsp:include>
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="newsnav.jsp">
			<jsp:param value="news_index" name="fun" />
		</jsp:include>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<c:if test="${newslist ne null}">
					<c:forEach items="${newslist}" var="news" varStatus="vs">
						<div style="margin-top: 30px">
							<h2 class="title">${news.title }</h2>
							<p class="text">${news.contect}</p>
							<p>
								<a class="btn pull-right"
									href="${pageContext.request.contextPath}/news/news_inf.action?detail=${news.id }&&type=${news.sort}">详情»</a>
							</p>
							<hr>
						</div>
					</c:forEach>
				</c:if>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>

	<jsp:include page="../footer.jsp"></jsp:include>

</body>
</html>