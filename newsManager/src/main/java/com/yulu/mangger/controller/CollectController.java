package com.yulu.mangger.controller;

import com.alibaba.fastjson.JSONObject;
import com.yulu.mangger.ErrorCode;
import com.yulu.mangger.bean.*;
import com.yulu.mangger.service.CollectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
// 定义该Controller的根访问路径 /collect
@RequestMapping("/collect")
public class CollectController {

	@Autowired
	@Qualifier("collectsService")
	private CollectsService collectsService;

	// 收藏新闻
	@RequestMapping("/collect")
	public void collect(HttpSession session, Integer newsid,
						HttpServletResponse response) throws Exception {
		Integer userid = (Integer) session.getAttribute("userid");
		ResultBean<Collects> mResultBean = new ResultBean<Collects>();
		response.setContentType("application/json; charset=utf-8");
		if(userid!=null) {
			Collects collectsOld = collectsService.findCollects(newsid, userid);
			if (collectsOld != null) {
				mResultBean.setMsg(ErrorCode.getMsg(ErrorCode.COLLECT_SAVE_ALREADY));
				mResultBean.setCode(ErrorCode.COLLECT_SAVE_ALREADY);
				mResultBean.setData(collectsOld);
			} else {
				mResultBean.setMsg("保存成功");
				mResultBean.setCode(ErrorCode.SUCCESS);
				Collects collects = new Collects();
				collects.setUserid(userid);
				collects.setNewsid(newsid);
				collects.setIsdelete(0);
				collectsService.add_do(collects);
			}
		}else{
			mResultBean.setMsg(ErrorCode.getMsg(ErrorCode.LOGIN_NOT_LOGIN));
			mResultBean.setCode(ErrorCode.LOGIN_NOT_LOGIN);
		}
		response.getWriter().println(JSONObject.toJSONString(mResultBean));
	}

	// 是否收藏新闻
	@RequestMapping("/isCollect")
	public void isCollect(Integer newsid, Integer userid,
						  HttpServletResponse response) throws Exception {
		ResultBean<Collects> mResultBean = new ResultBean<Collects>();
		Collects collectsOld = collectsService.findCollects(newsid,userid);
		if (collectsOld != null) {
			mResultBean.setMsg("已经保存");
			mResultBean.setCode(0);
			mResultBean.setData(collectsOld);
		}else {
			mResultBean.setMsg("未成功");
			mResultBean.setCode(1);
		}
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().println(JSONObject.toJSONString(mResultBean));
	}

	// 取消收藏
	@RequestMapping("/delete_do")
	public void delete_do( HttpSession session,Integer id,HttpServletResponse response) throws Exception {
		ResultBean<Collects> mResultBean = new ResultBean<Collects>();
		response.setContentType("application/json; charset=utf-8");

		Integer userid = (Integer) session.getAttribute("userid");
		if(userid!=null) {
			Collects collectsOld = collectsService.findCollects(id, userid);
			if (collectsOld != null) {
				collectsService.delete_do(id);
				mResultBean.setMsg("取消收藏成功");
				mResultBean.setCode(ErrorCode.SUCCESS);
			}else{
				mResultBean.setMsg(ErrorCode.getMsg(ErrorCode.COLLECT_NOT_COLLECT));
				mResultBean.setCode(ErrorCode.COLLECT_NOT_COLLECT);
			}
		}

		response.getWriter().println(JSONObject.toJSONString(mResultBean));
	}

}
