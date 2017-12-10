package com.yulu.mangger.constants;

public class AddressConstants {
    public static final String REDIRECT = "redirect";
    public static final String FORWARD = "forward";

    public interface NewsURL {
        String NEWS = "/news";
        String LIST = "/list";
        String SEARCH_LIST = "/search_list";
        String NEWS_INF = "/news_inf";
        String NEWS_DETAILS = "/news_details";
    }

    public interface CollectURL {
        String COLLECT = "/collect";
    }

    public interface CommentURL {
        String COMMENT = "/comment";
        String LIST = "/list";
    }

    public interface UserURL {
        String USER = "/user";
        String LOGIN = "/login";// 登录
        String SIGNOUT = "/userSignout";// 退出登录
        String USER_INF = "/user_inf";// 个人中心
        String USER_INF_EDIT = "/user_inf_edit";// 修改用户页面
        String COLLECT = "/user_collect";  // 我的收藏
        String COMMENT = "/user_comment"; // 我的评论
    }
}
