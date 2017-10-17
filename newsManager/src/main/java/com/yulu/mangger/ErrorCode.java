package com.yulu.mangger;

/**
 * 错误码
 */
public class ErrorCode {

    /*本地错误码*/
    /*请求错误*/
    public static final int FAILED_REQUEST_ERROR = -1;
    /*HTTP response 为空的错误*/
    public static final int FAILED_RESPONSE_NULL_ERROR = -2;
    /*HTTP网络错误*/
    public static final int FAILED_HTTP_ERROR = -3;
    /*其他网络请求未捕获的错误*/
    public static final int FAILED_HTTP_UNCATCH_ERROR = -4;
    /*无网络*/
    public static final int FAILED_NO_NET = -5;
    /*关注错误*/
    public static final int FAILED_ISSUSE_ERROR = -6;
    /*参数错误*/
    public static final int FAILED_PARAMS_ERROR = -7;

    public static final int SUCCESS = 0;
    public static final int ALREADY_STOCK = 140108;// 已经关注了这支股票
    public static final int CANCEL_STOCK_FAILED = 140106;// 没有关注这支股票

    public static final int ALREADY_FRIEND = 140107;// 已经关注了这个好友
    public static final int CANCEL_FRIEND_FAILED = 140104;// 没有关注这个好友

    public static final int ALREADY_COLLECT = 220803;// 已经收藏了这篇文章
    public static final int CANCEL_COLLECT_FAILED = 140109;// 没有收藏这篇文章

    public static final int SMS_CODE_PHONE_EXISTENCE = 200106; //手机号已存在
    public static final int SMS_CODE_PHONE_NOT_NULL = 200107; //手机号不能为空
    public static final int SMS_CODE_PHONE_OVER = 110101; //同一手机号当天发送量达限制
    public static final int SMS_CODE_CLIENT_OVER = 110102; //同一客户端当天发送量达限制
    public static final int SMS_CODE_DAY_OVER = 110103; //同一天发送量达限制

    public static final int REGISTRATION_FAILED = 2001; //注册失败
    public static final int USERNAME_CANNOT_EMPTY = 200101; //账号不能为空
    public static final int PASSWORD_CANNOT_EMPTY = 200102; //密码不能为空
    public static final int PASSWORD_OLD_FAILED = 200401; //旧密码不正确
    public static final int NICKNAME_CANNOT_EMPTY = 200103; //昵称不能为空
    public static final int NICKNAME_ALREADY_EXISTS = 200104; //昵称已存在
    public static final int NICKNAME_FORMAT_ERROR = 200108; //昵称格式不正确
    public static final int USERNAME_DOES_NOT_EXISTS = 200201; //用户名不存在
    public static final int USERID_DOES_NOT_EXISTS = 200202; //用户Id不存在
    public static final int NICKNAME_DOES_NOT_EXISTS = 200203; //昵称不存在
    public static final int USER_FAILED_MORE = 200504; //用户登录失败超过5次
    public static final int NICKNAME_NO_LEGAL = 2010; //昵称不合法
    public static final int UNBINDING_PHONE = 2005; //未绑定手机号
    public static final int OTHER_UNBINDING_PHONE = 2009;  //第三方登录未绑定

    public static final int LOGIN_EXIST_USERNAME = 10001;// username已经存在
    public static final int LOGIN_EXIST_PHONE = 10002;// 手机号已经存在
    public static final int LOGIN_NULL_USERNAME = 10003;// username为空
    public static final int LOGIN_FORMAT_PHONE =  10004;// 手机号格式不正确
    public static final int LOGIN_FORMAT_EMAIL = 10005; //邮箱格式不正确
    public static final int LOGIN_EXIST_EMAIL = 10006; //邮箱已经存在
    public static final int LOGIN_FORMAT_PASSWORD = 10007; //密码格式不正确
    public static final int LOGIN_NOT_LOGIN= 10008; //未登录
    public static final int LOGIN_USERNAME_OR_PASSWORD_ERROR = 10009; //用户名或密码错误

    public static final int COLLECT_SAVE_ALREADY  = 20001;//文章已经保存
    public static final int COLLECT_NOT_COLLECT = 20002;//该用户未收藏
    public static String getMsg(int code) {
        switch (code) {
            case SUCCESS:
                return "请求成功！";
            /*用户注册登录部分*/
            case LOGIN_EXIST_USERNAME:
                return "用户名已存在！";
            case LOGIN_EXIST_PHONE:
                return "手机号已存在！";
            case LOGIN_NULL_USERNAME:
                return "username为空！";
            case LOGIN_FORMAT_PHONE:
                return "手机号格式不正确！";
            case LOGIN_FORMAT_EMAIL:
                return "邮箱格式不正确！";
            case LOGIN_EXIST_EMAIL:
                return "邮箱已经存在！";
            case LOGIN_FORMAT_PASSWORD:
                return "密码格式不正确！";
            case LOGIN_NOT_LOGIN:
                return "未登录！";
            case LOGIN_USERNAME_OR_PASSWORD_ERROR:
                return "用户名或密码错误！";

            case COLLECT_SAVE_ALREADY:
                return "文章已经保存！";
            case COLLECT_NOT_COLLECT:
                return "该用户未收藏！";


            case SMS_CODE_PHONE_NOT_NULL:
                return "手机号不能为空！";
            case SMS_CODE_PHONE_OVER:
                return "同一手机号当天发送量达限制！";
            case SMS_CODE_CLIENT_OVER:
                return "同一客户端当天发送量达限制！";
            case SMS_CODE_DAY_OVER:
                return "同一天发送量达限制！";
            case REGISTRATION_FAILED:
                return "注册失败！";
            case USERNAME_CANNOT_EMPTY:
                return "账号不能为空！";
            case PASSWORD_CANNOT_EMPTY:
                return "密码不能为空！";
            case PASSWORD_OLD_FAILED:
                return "旧密码不正确！";
            case NICKNAME_CANNOT_EMPTY:
                return "昵称不能为空！";
            case NICKNAME_ALREADY_EXISTS:
                return "昵称已被注册！";
            case NICKNAME_FORMAT_ERROR:
                return "昵称长度2到8个字符，支持中英文、数字和_、-\n！";
             /*用户修改信息部分*/
            case USERNAME_DOES_NOT_EXISTS:
                return "用户名不存在！";
            case USERID_DOES_NOT_EXISTS:
                return "用户Id不存在！";
            case NICKNAME_DOES_NOT_EXISTS:
                return "昵称不存在！";
            case USER_FAILED_MORE:
                return "用户登录失败超过5次！";
            case NICKNAME_NO_LEGAL:
                return "昵称包含违禁词！";
            /*关注用户部分*/
            case ALREADY_STOCK:
                return "已经关注了这支股票！";
            case CANCEL_STOCK_FAILED:
                return "没有关注这支股票！";
            case ALREADY_FRIEND:
                return "已经关注了这个好友！";
            case CANCEL_FRIEND_FAILED:
                return "没有关注这个好友！";
            case ALREADY_COLLECT:
                return "已经收藏了这篇文章！";
            case CANCEL_COLLECT_FAILED:
                return "没有收藏这篇文章！";
            case ISSUSE_FRIEND_NO_FRIEND:
                return "还没有关注用户！";
            case ISSUSE_FRIEND_SAVE_FAILD:
                return "关注用户失败！";
//            case ISSUSE_FRIEND_CANCEL_FAILD:
//                return "取消关注用户失败！";
//            case ISSUSE_FRIEND_ALREADY:
//                return "已关注该用户！";
            case ISSUSE_FRIEND_NO_USER:
                return "该用户不存在！";
            case ISSUSE_FRIEND_NO_STOCK:
                return "该股票不存在！";
            case ISSUSE_STOCK_SAVE_FAILD:
                return "关注股票失败！";
//            case ISSUSE_STOCK_CANCEL_FAILD:
//                return "取消关注股票失败！";
//            case ISSUSE_STOCK_ALREADY:
//                return "已关注该股票！";

        }
        return null;
    }

    public static final int ISSUSE_FRIEND_NO_FRIEND = 1401;
    public static final int ISSUSE_FRIEND_SAVE_FAILD = 140103;
//    public static final int ISSUSE_FRIEND_CANCEL_FAILD = 140104;
//    public static final int ISSUSE_FRIEND_ALREADY = 140107;

    public static final int ISSUSE_FRIEND_NO_USER = 140101;
    public static final int ISSUSE_FRIEND_NO_STOCK = 140102;

    public static final int ISSUSE_STOCK_SAVE_FAILD = 140105;
//    public static final int ISSUSE_STOCK_CANCEL_FAILD = 140106;
//    public static final int ISSUSE_STOCK_ALREADY = 140108;

    //关注
}
