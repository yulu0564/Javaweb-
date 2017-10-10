package com.yulu.mangger.controller;

import com.alibaba.fastjson.JSONObject;
import com.yulu.mangger.bean.*;
import com.yulu.mangger.service.CollectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
// 定义该Controller的根访问路径 /collect
@RequestMapping("/collect")
public class CollectController {

	@Autowired
	@Qualifier("collectsService")
	private CollectsService collectsService;


	// 收藏新闻
	@RequestMapping("/collect")
	public String collect(HttpServletRequest request, Integer newsid,
						  Integer userid) throws Exception {
		Collects collects = new Collects();
		collects.setUserid(userid);
		collects.setNewsid(newsid);
		collects.setIsdelete(0);
		collectsService.add_do(collects);
		return "forward:user_collect?userid=" + userid;
	}

	// 收藏新闻
	@RequestMapping("/collect2")
	public void collect(Integer newsid, Integer userid,
						HttpServletResponse response) throws Exception {
		ResultBean<Collects> mResultBean = new ResultBean<Collects>();
		Collects collectsOld = collectsService.findCollects(newsid,userid);
		if (collectsOld != null) {
			mResultBean.setMsg("已经保存");
			mResultBean.setCode(1);
			mResultBean.setData(collectsOld);
		}else {
			mResultBean.setMsg("保存成功");
			mResultBean.setCode(0);
			Collects collects = new Collects();
			collects.setUserid(userid);
			collects.setNewsid(newsid);
			collects.setIsdelete(0);
			collectsService.add_do(collects);
		}
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().println(JSONObject.toJSONString(mResultBean));
	}

	// 收藏新闻
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
	public void delete_do( Integer id,
							Integer userid,HttpServletResponse response) throws Exception {
		collectsService.delete_do(id);
		ResultBean<Collects> mResultBean = new ResultBean<Collects>();
		response.setContentType("application/json; charset=utf-8");
		mResultBean.setMsg("取消收藏成功");
		mResultBean.setCode(0);
		response.getWriter().println(JSONObject.toJSONString(mResultBean));
	}

}
