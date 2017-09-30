<%@page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${username==null}">
	<div id="myAlert" class="alert alert-warning ">
		<a href="#" class="close" data-dismiss="alert">&times;</a> <strong>您好！</strong>您还没有登录!
	</div>
	<script type="text/javascript">
		$(function() {
			$(".close").click(function() {
				$("#myAlert").alert('close');
			});
		});
	</script>
</c:if>

<div class="row">
	<div class="col-md-12">
		<nav class="navbar navbar-default" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span><span
						class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">新闻</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li <c:if test="${param.type==null}">class="active" </c:if>><a
						href="${pageContext.request.contextPath}/news/news_list">首页</a></li>
					<c:if test="${sortlist ne null}">
						<c:forEach items="${sortlist}" var="sort" varStatus="vs">
							<li <c:if test="${sort.id==param.type}">class="active" </c:if>><a
								href="${pageContext.request.contextPath}/news/news_list?type=${sort.id}">${sort.sortname}</a></li>
						</c:forEach>
					</c:if>
				</ul>
				<c:if test="${username==null}">
					<ul class="nav navbar-nav navbar-right">
						<li><a id="modal-181250" href="#modal-container-181250"
							role="button" class="btn" data-toggle="modal">登录</a></li>
						<li style="margin-right: 50px"><a id="modal-181251"
							href="#modal-container-181251" role="button" class="btn"
							data-toggle="modal">注册</a></li>
					</ul>
				</c:if>
				<c:if test="${username!=null}">
					<ul class="nav navbar-nav navbar-right" style="margin-right: 15px">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">${username}<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li <c:if test="${param.type==null}">class="active" </c:if>><a
									href="${pageContext.request.contextPath}/news/news_list">首页</a></li>
								<li
									class="<%="inf".equals(request.getParameter("fun"))
						? "active"
						: ""%>"><a
									href="${pageContext.request.contextPath}/news/user_inf">个人中心</a></li>
								<li
									class="<%="collect".equals(request.getParameter("fun"))
						? "active"
						: ""%>"><a
									href="${pageContext.request.contextPath}/news/user_collect?userid=${userid}">我的收藏</a></li>
								<li
									class="<%="comment".equals(request.getParameter("fun"))
						? "active"
						: ""%>"><a
									href="${pageContext.request.contextPath}/news/user_comment?userid=${userid}">我的评论</a></li>
								<li class="divider"></li>
								<li><a
									href="${pageContext.request.contextPath}/news/userSignout">退出登录</a>
								</li>
							</ul></li>
					</ul>
				</c:if>
			</div>

		</nav>
	</div>

	<div class="modal fade" id="modal-container-181250" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">登录</h4>
				</div>
				<form role="form" method="post" action="userLogin">
					<div class="modal-body">
						<div style="width: 400px; margin-left: 90px">
							<div class="input-group">
								<span class="input-group-addon">昵称</span> <input type="text"
									name="username" class="form-control" placeholder="请输入用户名"
									data-toggle="tooltip" data-placement="right" title="请输入用户名">
							</div>
						</div>
						<div style="width: 400px; margin-left: 90px">
							<div class="input-group" style="margin-top: 20px">
								<span class="input-group-addon">密码</span> <input type="password"
									name="password" class="form-control" placeholder="请输入密码"
									data-toggle="tooltip" data-placement="right" title="请输入密码">
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-success"
							style="width: 400px; margin-right: 80px">
							<B> 登录 </B>
						</button>
						<button type="button" class="btn btn-default" data-dismiss="modal"
							style="width: 400px; margin-right: 80px; margin-top: 20px;">取消</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="modal fade" id="modal-container-181251" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">注册</h4>
				</div>
				<form method="post" action="register">
					<div class="modal-body">
						<div style="width: 400px; margin-left: 90px">
							<div class="input-group">
								<span class="input-group-addon">昵称</span> <input type="text"
									name="username" class="form-control" placeholder="请输入用户名"
									data-toggle="tooltip" data-placement="right" title="请输入用户名">
							</div>
						</div>
						<div style="width: 400px; margin-left: 90px">
							<div class="input-group" style="margin-top: 20px">
								<span class="input-group-addon">密码</span> <input type="password"
									name="password" class="form-control" placeholder="请输入密码"
									data-toggle="tooltip" data-placement="right" title="请输入密码">
							</div>
						</div>
						<div style="width: 400px; margin-left: 90px">
							<div class="input-group" style="margin-top: 20px">
								<span class="input-group-addon">性别</span> <select
									class="form-control" name="sex">
									<option value="0" selected="selected">男</option>
									<option value="1">女</option>
								</select>
							</div>
						</div>
						<div style="width: 400px; margin-left: 90px">
							<div class="input-group" style="margin-top: 20px">
								<span class="input-group-addon">邮箱</span> <input type="text"
									name="email" class="form-control" placeholder="请输入邮箱"
									data-toggle="tooltip" data-placement="right"
									title="邮箱格式:xx@xxx.com">
							</div>
						</div>
						<div style="width: 400px; margin-left: 90px">
							<div class="input-group" style="margin-top: 20px">
								<span class="input-group-addon">电话</span> <input type="text"
									name="telephone" class="form-control" placeholder="请输入手机号"
									data-toggle="tooltip" data-placement="right" title="请输入手机号">
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-success"
							style="width: 400px; margin-right: 80px">提交</button>
						<button class="btn btn-default" data-dismiss="modal"
							style="width: 400px; margin-right: 80px; margin-top: 20px;">取消</button>

					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
	$(function() {
		$("[data-toggle='tooltip']").tooltip();
	});
</script>