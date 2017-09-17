<%@page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="../news/newshead.jsp">
	<jsp:param value="新闻-首页" name="title" />
</jsp:include>
</head>
<body>
	<div class="container-fluid">
		<jsp:include page="newsnav.jsp" />
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="carousel slide" id="carousel-876572">
					<ol class="carousel-indicators">
						<li class="active" data-slide-to="0"
							data-target="#carousel-876572"></li>
						<li data-slide-to="1" data-target="#carousel-876572"></li>
						<li data-slide-to="2" data-target="#carousel-876572"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<img alt="Carousel Bootstrap First"
								src="${pageContext.request.contextPath}/res/images/banner1.jpg"
								style="height: 300px; width: 1500px" />
							<div class="carousel-caption">
								<h4>First Thumbnail label</h4>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.</p>
							</div>
						</div>
						<div class="item">
							<img alt="Carousel Bootstrap Second"
								src="${pageContext.request.contextPath}/res/images/banner2.jpg"
								style="height: 300px; width: 1500px" />
							<div class="carousel-caption">
								<h4>Second Thumbnail label</h4>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.</p>
							</div>
						</div>
						<div class="item">
							<img alt="Carousel Bootstrap Third"
								src="${pageContext.request.contextPath}/res/images/banner3.jpg"
								style="height: 300px; width: 1500px" />
							<div class="carousel-caption">
								<h4>Third Thumbnail label</h4>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.</p>
							</div>
						</div>
					</div>
					<a class="left carousel-control" href="#carousel-876572"
						data-slide="prev"><span
						class="glyphicon glyphicon-chevron-left"></span></a> <a
						class="right carousel-control" href="#carousel-876572"
						data-slide="next"><span
						class="glyphicon glyphicon-chevron-right"></span></a>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="container col-md-12" style="margin-top: 20px">
					<div class="tab" role="tabpanel">
						<!-- Nav tabs -->
						<ul class="nav nav-tabs" role="tablist" style="margin-top: 0px;"
							id="docTabs">
							<li role="presentation" class="active"><a
								href="#Section_new" aria-controls="home" role="tab"
								data-toggle="tab"> 最新</a>
							<li role="presentation"><a href="#Section_week"
								aria-controls="profile" role="tab" data-toggle="tab">热门分类</a>
							<li role="presentation"><a href="#Section_month"
								aria-controls="messages" role="tab" data-toggle="tab">热门关注</a>
						</ul>
						<!-- Tab panes -->
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane fade in active"
								id="Section_new">
								<div class="container-fluid">
									<div class="row">
										<div class="col-md-12">
											<c:if test="${hotNews ne null}">
												<c:forEach items="${hotNews}" var="news" varStatus="vs">
													<div class="col-md-3" style="width: 262px">
														<div class="thumbnail">
															<img alt="Bootstrap Thumbnail First"
																src="${pageContext.request.contextPath}/res/images/img.jpg" />
															<div class="caption">
																<h3 class="title">${news.title}</h3>
																<p class="text">${news.contect}</p>
																<p>
																	<a class="btn btn-warning"
																		href="${pageContext.request.contextPath}/news/collect.action?newsid=${news.id}&&userid=${userid}">收藏</a>
																	<a
																		href="${pageContext.request.contextPath}/news/news_inf.action?detail=${news.id }&&type=${news.sort}"
																		class="btn btn-success">查看</a>
																</p>
															</div>
														</div>
													</div>
												</c:forEach>
											</c:if>
										</div>
									</div>
								</div>
							</div>
							<div role="tabpanel" class="tab-pane fade" id="Section_week">
								<div class="container-fluid">
									<div class="row">
										<div class="col-md-12">
											<c:if test="${hotNews7 ne null}">
												<c:forEach items="${hotNews7}" var="news" varStatus="vs">
													<div class="col-md-3" style="width: 262px">
														<div class="thumbnail">
															<img alt="Bootstrap Thumbnail First"
																src="${pageContext.request.contextPath}/res/images/img.jpg" />
															<div class="caption">
																<h3 class="title">${news.title}</h3>
																<p class="text">${news.contect}</p>
																<p>
																	<a class="btn btn-warning"
																		href="${pageContext.request.contextPath}/news/collect.action?newsid=${news.id}&&userid=${userid}">收藏</a>
																	<a
																		href="${pageContext.request.contextPath}/news/news_inf.action?detail=${news.id }&&type=${news.sort}"
																		class="btn btn-success">查看</a>
																</p>
															</div>
														</div>
													</div>
												</c:forEach>
											</c:if>
										</div>
									</div>
								</div>
							</div>

							<div role="tabpanel" class="tab-pane fade" id="Section_month">
								<div class="container-fluid">
									<div class="row">
										<div class="col-md-12">
											<c:if test="${hotNews30 ne null}">
												<c:forEach items="${hotNews30}" var="news" varStatus="vs">
													<div class="col-md-3" style="width: 262px">
														<div class="thumbnail">
															<img alt="Bootstrap Thumbnail First"
																src="${pageContext.request.contextPath}/res/images/img.jpg" />
															<div class="caption">
																<h3 class="title">${news.title}</h3>
																<p class="text">${news.contect}</p>
																<p>
																	<a class="btn btn-warning"
																		href="${pageContext.request.contextPath}/news/collect.action?newsid=${news.id}&&userid=${userid}">收藏</a>
																	<a
																		href="${pageContext.request.contextPath}/news/news_inf.action?detail=${news.id }&&type=${news.sort}"
																		class="btn btn-success">查看</a>
																</p>
															</div>
														</div>
													</div>
												</c:forEach>
											</c:if>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container-fluid" style="margin-top: 10px">
		<div class="row">
			<div class="col-md-9">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-9">
							<h2 class="text-left text-danger">影视娱乐</h2>
						</div>
						<div class="thumbnail" style="height: 335px">
							<div class="col-md-5">
								<ul>
									<c:if test="${sort2 ne null}">
										<c:forEach items="${sort2}" var="news" varStatus="vs">
											<li><a
												href="${pageContext.request.contextPath}/news/news_inf.action?detail=${news.id }&&type=${news.sort}">${news.title
													}</a></li>
										</c:forEach>
									</c:if>
								</ul>
							</div>
							<div class="col-md-7">
								<c:if test="${sort2 ne null}">
									<c:forEach items="${sort2}" var="news" varStatus="vs">
										<c:if test="${vs.count==1 }">
											<a
												href="${pageContext.request.contextPath}/news/news_inf.action?detail=${news.id}&&type=${news.sort}">
												<img alt="Bootstrap Thumbnail First"
												src="${pageContext.request.contextPath}/res/images/img.jpg"
												style="height: 80px; width: 500px" />
												<div class="caption">
													<h3>${news.title }</h3>
													<p class="text1">${news.contect }</p>
												</div>
											</a>
										</c:if>
									</c:forEach>
								</c:if>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-9">
							<h2 class="text-left text-danger">国际社会</h2>
						</div>
						<div class="thumbnail" style="height: 335px">
							<div class="col-md-5">
								<ul>
									<c:if test="${sort7 ne null}">
										<c:forEach items="${sort7}" var="news" varStatus="vs">
											<li><a
												href="${pageContext.request.contextPath}/news/news_inf.action?detail=${news.id}&&type=${news.sort}">${news.title}</a></li>
										</c:forEach>
									</c:if>
								</ul>
							</div>
							<div class="col-md-7">
								<c:if test="${sort7 ne null}">
									<c:forEach items="${sort7}" var="news" varStatus="vs">
										<c:if test="${vs.count==1 }">
											<a
												href="${pageContext.request.contextPath}/news/news_inf.action?detail=${news.id}&&type=${news.sort}">
												<img alt="Bootstrap Thumbnail First"
												src="${pageContext.request.contextPath}/res/images/img.jpg"
												style="height: 80px; width: 500px" />
												<div class="caption">
													<h3>${news.title }</h3>
													<p class="text1">${news.contect }</p>
												</div>
											</a>
										</c:if>
									</c:forEach>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-3">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<h4 class="text-left text-warning">今日头条</h4>
						</div>
					</div>
				</div>
				<ul>
					<c:if test="${newslist ne null}">
						<c:forEach items="${newslist}" var="news" varStatus="vs">
							<c:if test="${vs.count<4 }">
								<li style="line-height: 30px"><B><a
										href="${pageContext.request.contextPath}/news/news_inf.action?detail=${news.id }&&type=${news.sort}">${news.title}</a></B></li>
							</c:if>
							<c:if test="${vs.count>3 &&vs.count<=30}">
								<li style="line-height: 25px"><a
									href="${pageContext.request.contextPath}/news/news_inf.action?detail=${news.id }&&type=${news.sort}">${news.title}</a></li>
							</c:if>
						</c:forEach>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>

	<script type="text/javascript">
		//tabs自动轮换
		function timer(i) {
			interval = setInterval(function() {
				$("#docTabs li:eq(" + i + ") a").tab('show');
				i++;
				if (i > 2)
					i = 0;
			}, 5000);
			return interval;
		}
		$(function() {
			var i = 0;
			interval = timer(i);
			//当鼠标悬停在列表区域时暂停轮换
			$(".tab-pane").mouseover(function() {
				clearInterval(interval);
			});
			//鼠标移开时继续轮换
			$(".tab-pane").mouseout(function() {
				timer(i);
			});
		});
	</script>

</body>
</html>