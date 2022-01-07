package com.traveler.server.model.entity;

public interface ConstantType {

    String HTTP = "http://";
    String HTTPS = "https://";
    String INTERNET_ADDRESS_MAPPING = "221.122.89.125:61239";


    /** http 访问自定义状态 */
    String HTTP_SUCCESS_CODE = "200";
    String HTTP_ERROR_CODE = "500";
    String HTTP_NO_LOGIN_CODE = "300";

    /** SQL语句执行返回结果 */
    int SQL_RESULT_IS_SUCCESS = 1;
    int SQL_RESULT_IS_HAVE = 1;
    int SQL_RESULT_IS_NULL = 0;


    //数值常量
    public static final int NUMBER_VALUE_MINUS_1 = -1;
    public static final int NUMBER_VALUE_0 = 0;
    public static final int NUMBER_VALUE_1 = 1;
    public static final int NUMBER_VALUE_2 = 2;
    public static final int NUMBER_VALUE_3 = 3;
    public static final int NUMBER_VALUE_4 = 4;
    public static final int NUMBER_VALUE_5 = 5;
    public static final int NUMBER_VALUE_10 = 10;
    public static final int NUMBER_VALUE_16 = 16;
    public static final int NUMBER_VALUE_20 = 20;
    public static final int NUMBER_VALUE_30 = 30;
    public static final int NUMBER_VALUE_50 = 50;
    public static final int NUMBER_VALUE_32 = 32;
    public static final int NUMBER_VALUE_24 = 24;
    public static final int NUMBER_VALUE_500 = 500;
    public static final int NUMBER_VALUE_100 = 100;
    public static final int NUMBER_VALUE_150 = 150;

    /**
     * 盐值位数
     */
    public static final int SALT_LENGTH = 6;
    /** SQL 语句 */
    String FAMILY_SQL_LIMITONE = "limit 1";
    String FAMILY_SQL_ALL = "*";

    /** SQL 逻辑删除状态 */
    int FAMILY_MYSQL_IS_DELETED_Y = 1;
    int FAMILY_MYSQL_IS_DELETED_N = 0;

    /** 数据库表字段 */
    String FAMILY_ID = "id";
    String FAMILY_IMCORE_ID = "user_id";
    String FAMILY_USER_ID = "user_id";
    String FAMILY_USER_STATUS = "status";
    String FAMILY_REPORT_USER_ID = "target_id";
    String FAMILY_BLACK_USER_ID = "black_user_id";
    String FAMILY_FOLLOW_USER_ID = "follow_user_id";
    String FAMILY_FOLLOW_STATUS = "follow_status";
    String FAMILY_LAST_NOTIC_TIME = "last_notic_time";
    String FAMILY_PHONE_AREA_CODE = "phone_area_code";
    String FAMILY_LIKE_STATUS = "like_status";
    String FAMILY_LIKE_USER_ID = "like_user_id";
    String FAMILY_REPLY_LIKE_USER_ID = "reply_like_user_id";
    String FAMILY_USER_ICON = "home_img_url";
    String FAMILY_SEX = "sex";
    String FAMILY_BIRTHDAY = "birthday";
    String FAMILY_PERSONALIZED_SIGNATURE = "personalized_signature";
    String FAMILY_NICKNAME = "home_nickname";
    String FAMILY_REGION_ID = "region_id";
    String FAMILY_HOMELAND_LEVEL = "level";
    String FAMILY_HOMELAND_WEALTH_VALUE = "wealth_value";
    String FAMILY_REGION_LEVEL = "level";
    String FAMILY_ROOM_LEVEL = "level";
    String FAMILY_PARENT_ID = "parent_id";
    String FAMILY_DISTURB_PM_STATUS = "disturb_pm_status";
    String FAMILY_DISTURB_FOLLOW_STATUS = "disturb_follow_status";
    String FAMILY_DISTURB_GROUP_STATUS = "disturb_group_status";
    String FAMILY_DISTURB_LIKE_STATUS = "disturb_like_status";
    String FAMILY_DISTURB_SYSTEM_STATUS = "disturb_system_status";
    String FAMILY_DISTURB_SYSTEM_MOMENT_LIKE = "disturb_moment_like";
    String FAMILY_DISTURB_SYSTEM_MOMENT_COMMENT = "disturb_moment_comment";
    String FAMILY_DISTURB_SYSTEM_MOMENT_AT = "disturb_moment_at";
    String FAMILY_POWER_PM_STARS = "pm_stars";
    String FAMILY_POWER_PM_HOMELAND_LEVEL = "pm_homeland_level";
    String FAMILY_POWER_PM_HOMELAND_LEVEL_DEFIND = "pm_homeland_level_defind";
    String FAMILY_POWER_PV_STARS = "pv_stars";
    String FAMILY_POWER_PV_HOMELAND_LEVEL = "pv_homeland_level";
    String FAMILY_POWER_PV_HOMELAND_LEVEL_DEFIND = "pv_homeland_level_defind";
    String FAMILY_VERSIONS_VERSION_CODE = "version_code";
    String FAMILY_FILE_TYPE = "type";
    String FAMILY_REPORT_CONFIG_TYPE = "type";
    String FAMILY_FILE_STATUS = "status";
    String FAMILY_MESSAGE_TO_USERID = "to_user_id";
    String FAMILY_MESSAGE_FROM_USERID = "from_user_id";
    String FAMILY_MESSAGE_TYPE = "type";
    String FAMILY_MESSAGE_READ = "read";
    String FAMILY_ROOM_ID = "room_id";
    String FAMILY_TARGET_ID = "target_id";
    String FAMILY_FILE_TARGET_ID = "target_id";
    String FAMILY_FILE_VOICE_SIZE = "voice_size";
    String FAMILY_VERIFY_TIME = "verify_time";
    String FAMILY_FIRST_VERIFY_TIME = "first_verify_time";
    String FAMILY_NO_PASS_REASON = "no_pass_reason";
    String FAMILY_VERIFY_STATUS = "verify_status";
    String FAMILY_ADMIN_VERIFY_STATUS = "admin_verify_status";
    String FAMILY_ADMIN_NO_PASS_REASON = "admin_no_pass_reason";
    String FAMILY_ADMIN_FIRST_VERIFY_TIME = "first_verify_time";
    String FAMILY_ADMIN_ID = "admin_id";
    String FAMILY_ADMIN_VERIFY_TIME = "admin_verify_time";
    String FAMILY_APPEAL_EXPIRE_TIME = "appeal_expire_time";
    String FAMILY_APPEAL_STATUS = "appeal_status";
    String FAMILY_CONFIG_KEY = "config_key";
    String FAMILY_CONFIG_VALUE = "config_value";
    String FAMILY_CREATEDON = "created_on";
    String FAMILY_UPDATEDON = "updated_on";
    String FAMILY_SHANDW_GAMES_APP_SORT = "app_sort";
    String FAMILY_MOMENTS_ID = "moment_id";
    String FAMILY_IDENTIFY = "identify";
    String FAMILY_NOTIFY_MOMENT_LIKE_TYPE = "type";
    String FAMILY_NOTIFY_COMMENT_TYPE = "type";
    String FAMILY_NOTIFY_COMMENT_COMMENT_USER_ID = "comment_user_id";
    String FAMILY_NOTIFY_COMMENT_REPLY_COMMENT_USER_ID = "reply_comment_user_id";
    String FAMILY_NOTIFY_COMMENT_COMMENT_CONTENT = "comment_content";
    String FAMILY_TOPIC_KIND_ID = "kind_id";
    String FAMILY_TOPIC_ID = "topic_id";
    String FAMILY_TOPIC_STATUS = "status";

    /**
     * 中国手机号区号86
     */
    public static final String CHINA_PHONE_CODE="86";
    public static final String CHINA_PHONE_CODE_NAME="中国";
    public static final String CHINA_PHONE_CODE_EN_NAME="China";
    public static final String CHINA_PHONE_CODE_SBBR="CN";

    /** 关注状态 */
    int FAMILY_FOLLOW_MYSELF = 0; // 【我】
    int FAMILY_FOLLOW_ON = 1;//【已关注】
    int FAMILY_FOLLOW_OFF = 2;//【已取关】
    int FAMILY_FOLLOW_EACH_OTHER = 3;//【互相关注】

    /** 点赞状态 */
    int FAMILY_LIKE_MYSELF = 0; // 【我】
    int FAMILY_LIKE_ON = 1; // 【喜欢】
    int FAMILY_LIKE_OFF = 2;//【不喜欢】
    int FAMILY_LIKE_EACH_OTHER = 3;//【相互点赞】

    /** 推送通知 */
    int FAMILY_NOTICE_TYPE_FOLLOW = 1;//【关注通知】
    String FAMILY_NOTICE_MSG_FOLLOW = "关注了你， 快回关TA吧";//【关注通知消息】
    int FAMILY_NOTICE_TYPE_LIKE = 2;//【点赞通知】
    String FAMILY_NOTICE_MSG_LIKE_EACHOTHER = "和你互相点赞， 快关注TA吧";//【点赞通知消息，互相点赞】
    String FAMILY_NOTICE_MSG_LIKE = "点赞了你， 快关注TA吧";//【点赞通知消息】
    int FAMILY_NOTICE_MSG_READ_ON = 1;//【消息已阅读】
    int FAMILY_NOTICE_MSG_READ_OFF = 0;//【消息未阅读】
    String FAMILY_NOTICE_MSG_VERIFY = "您所上传的图片经检测含有违规内容, 图片已被删除, 图片类型: ";
    String FAMILY_NOTICE_VOICE_VERIFY = "您所上传的语音经检测含有违规内容, 语音已被删除, 语音类型: ";
    String FAMILY_NOTICE_MOMENT_VERIFY = "您发布的动态经审核含有违规内容已被删除";
    String FAMILY_NOTICE_MOMENT_VERIFY_CONTENT = "您发布的动态【$】经审核含有违规内容已被删除";
    String FAMILY_NOTICE_COMMENT_VERIFY = "您发布的评论经审核含有违规内容已被删除";
    String FAMILY_NOTICE_COMMENT_VERIFY_CONTENT = "您发布的评论【$】经审核含有违规内容已被删除";

    String FAMILY_NOTICE_APPEAL_NO_PASS = "您于$ 提交的处罚申诉申请未通过审核，请保持良好的社交礼仪。";
    String FAMILY_NOTICE_APPEAL_PASS = "您于$ 提交的处罚申诉申请已通过审核，内容已恢复。";


    int FAMILY_NOTICE_TYPE_MOMENT_LIKE = 21;//【动态点赞通知】
    String FAMILY_NOTICE_TYPE_MSG_MOMENT_LIKE = "点赞了你的动态";//【动态点赞通知消息】
    String FAMILY_NOTICE_TYPE_MSG_COMMENT_LIKE = "点赞了你的评论";//【动态点赞通知消息】
    int FAMILY_NOTICE_TYPE_MOMENT_COMMENT = 22;//【动态评论通知】
    String FAMILY_NOTICE_TYPE_MSG_MOMENT_COMMENT = "评论了你的动态";//【动态评论通知消息】
    String FAMILY_NOTICE_TYPE_MSG_COMMENT_COMMENT = "回复了你的评论";//【动态评论通知消息】
    int FAMILY_NOTICE_TYPE_MOMENT_AT = 23;//【动态@通知】
    String FAMILY_NOTICE_TYPE_MSG_MOMENT_AT = "@了你";//【动态@通知消息】

    /** 文件类型 */
    int FAMILY_FILE_TYPE_IMG_HOME = 1;//用户主页图片
    int FAMILY_FILE_TYPE_IMG_REPORT = 2;//用户举报截图
    int FAMILY_FILE_TYPE_IMG_HOMELAND = 3;//用户家园图片
    int FAMILY_FILE_TYPE_IMG_AVATAR = 4;//用户头像图片
    int FAMILY_FILE_TYPE_IMG_MOMENT = 21;//动态图片
    int FAMILY_FILE_TYPE_VOICE_MOMENT = 22;//动态语音
    int FAMILY_FILE_TYPE_IMG_COMMENT = 23;//评论图片
    int FAMILY_FILE_TYPE_VOICE_COMMENT = 24;//评论语音
    int FAMILY_FILE_TYPE_WORD_MOMENT = 25;//动态文字
    int FAMILY_FILE_TYPE_WORD_COMMENT = 26;//评论文字

    int FAMILY_FILE_STATUS_ON = 1;//正常状态
    int FAMILY_FILE_STATUS_OFF = 2;//删除状态

    /** valid 校验 */
    int SUCCESS_CODE = 200;
    String SUCCESS_MESSAGE = "校验通过！";
    int FAIL_CODE = 500;
    String FAIL_MESSAGE = "校验失败！";


    /**
     * 配置表key
     */
    public static final String IMCORE_CLIENTID="imcore.clientid";//蜂核端提供的clientID
    public static final String IMCORE_MASTERSECRET="imcore.masterSecret";//蜂核端提供的masterSecret
    public static final String IMCORE_FRIEND_DELETE_API="imcore.friend.delete.api";//蜂核端删除好友api
    public static final String IMCORE_SEND_NOTIFY_API="imcore.send.notify.api";//蜂核端发送通知api
    public static final String IMCORE_GET_TOKEN_BY_USERID_API="imcore.get.token.by.userid.api";//蜂核端通过用户id获取token及信息api（入参：key-value）
    public static final String IMCORE_GET_CLIENT_TOKEN="imcore.get.client.token";//蜂核端获取调用第三方api需要的token
    public static final String IMCORE_REGISTRY_API="imcore.registry.api";//蜂核端注册接口api
    public static final String IMCORE_PHONE_LOGIN_API="imcore.phone.login.api";//蜂核端手机号验证码登录接口api
    public static final String IMCORE_SEND_VERSITIONCODE_API="imcore.send.versitioncode.api";//蜂核端发送手机验证码api
    public static final String IMCORE_CHECK_VERSITIONCODE_API="imcore.check.versitioncode.api";//蜂核端校验手机验证码api
    public static final String IMCORE_CHANGE_PHONE_API="imcore.change.phone.api";//蜂核端修改手机号api
    public static final String IMCORE_CHANGE_PASSWORD_API="imcore.change.password.api";//蜂核端修改密码api
    public static final String IMCORE_PASSWORD_LOGIN_API="imcore.password.login.api";//蜂核端用户名密码登录api
    public static final String IMCORE_USER_INFO_API="imcore_user_info_api";//蜂核端获取用户信息api
    public static final String IMCORE_FRIEND_LIST_API="imcore_friend_list_api";//蜂核端获取好友列表api
    public static final String IMCORE_FRIEND_ADD_API="imcore.friend.add.api";//蜂核端添加好友api
    public static final String FAMILY_ACCOUNT_MAX8="family.account.max8";//家园8位数账号生辰阈值
    public static final String FAMILY_ACCOUNT_POP_MAXTIME="family.account.pop.maxTime";//家园账号取号最大等待时间（毫秒 | ms ）
    public static final String FAMILY_REGION_VERSION="family.region.version";//家园地区表版本号
    public static final String RONGCLOUD_GET_TOKEN_HEADER_APPKEY="rongcloud.get.token.headers.appkey";//融云获取token请求头信息：appKey
    public static final String RONGCLOUD_GET_TOKEN_HEADERS_APPSECRET="rongcloud.get.token.headers.appSecret";//融云获取token请求头信息：appSecret
    public static final String RONGCLOUD_GET_TOKEN_API_CHINA_1="rongcloud.get.token.api.china.1";//融云获取token请求头信息：域名1-国内1
    public static final String RONGCLOUD_GET_TOKEN_API_CHINA_2="rongcloud.get.token.api.china.2";//融云获取token请求头信息：域名2-国内2
    public static final String RONGCLOUD_GET_TOKEN_API_SINGAPORE_3="rongcloud.get.token.api.singapore.3";//融云获取token请求头信息：域名3-新加坡
    public static final String RONGCLOUD_ADD_BLACKLIST_API="rongcloud.blacklist.add.api";//融云添加黑名单api
    public static final String RONGCLOUD_REMOVE_BLACKLIST_API="rongcloud.blacklist.remove.api";//融云删除黑名单api
    public static final String RONGCLOUD_STATUSMESSAGE_PRIVATE_PUBLISH_API="rongcloud.statusmessage.private.publish.api";//融云状态消息发送 api
    public static final String RONGCLOUD_USERID_FOLLOW="rongcloud.userid.follow";//融云关注系统用户 id
    public static final String RONGCLOUD_USERID_LIKE="rongcloud.userid.like";//融云点赞系统用户 id
    public static final String RONGCLOUD_USERID_VERIFY="rongcloud.userid.verify";//融云审核图片系统用户id
    public static final String RONGCLOUD_USERID_FOLLOW_USERINFO="rongcloud.userid.follow.userinfo";//融云关注系统用户数据
    public static final String RONGCLOUD_USERID_LIKE_USERINFO="rongcloud.userid.like.userinfo";//融云点赞系统用户数据
    public static final String RONGCLOUD_USERID_VERIFY_USERINFO="rongcloud.userid.verify.userinfo";//融云审核图片系统用户数据
    public static final String RONGCLOUD_USERID_MOMENT_LIKE="rongcloud.userid.moment.like";//融云动态点赞系统用户 id
    public static final String RONGCLOUD_USERID_MOMENT_COMMENT="rongcloud.userid.moment.comment";//融云动态评论系统用户 id
    public static final String RONGCLOUD_USERID_MOMENT_AT="rongcloud.userid.moment.at";//融云@我的系统用户id
    public static final String RONGCLOUD_USERID_MOMENT_LIKE_USERINFO="rongcloud.userid.moment.like.userinfo";//融云动态点赞系统用户数据
    public static final String RONGCLOUD_USERID_MOMENT_COMMENT_USERINFO="rongcloud.userid.moment.comment.userinfo";//融云动态评论系统用户数据
    public static final String RONGCLOUD_USERID_MOMENT_AT_USERINFO="rongcloud.userid.moment.at.userinfo";//融云@我的系统用户数据
    public static final String RONGCLOUD_USER_EXPIRE_TOKEN="rongcloud.expire.token";//融云接口使用户现有的token失效

    public static final String THIRD_LOGIN_FIRST_API="third.login.first.api";//蜂核端第三方登录第一步
    public static final String THIRD_LOGIN_SECOND_API="third.login.second.api";//蜂核端第三方登录第二步
    public static final String THIRD_LOGIN_LAST_API="third.login.last.api";//蜂核端第三方登录第三步

    public static final String BAIDU_AI_CENTOR_TEXT_API="baidu.ai.centor.text.api";//百度AI审核 [文本] api
    public static final String BAIDU_AI_CENTOR_IMG_API="baidu.ai.centor.img.api";//百度AI审核 [图片] api
    public static final String BAIDU_AI_CENTOR_VOICE_API="baidu.ai.centor.voice.api";//百度AI审核 [语音] api
    public static final String BAIDU_AI_CENTOR_APP_ID="baidu.ai.centor.app.id";//百度AI审核 APPID
    public static final String BAIDU_AI_CENTOR_APP_APIKEY="baidu.ai.centor.app.apikey";//百度AI审核 API Key
    public static final String BAIDU_AI_CENTOR_APP_SECRETKEY="baidu.ai.centor.app.secretkey";//百度AI审核 Secret Key

    public static final String FAMILY_SHANDW_GAME_COUNT="family.shandw.game.count";//闪电玩游戏显示数量
    public static final String FAMILY_SHANDW_CONFIG_ACCOUNT = "family.shandw.config.account";
    public static final String FAMILY_SHANDW_CONFIG_CHANNEL = "family.shandw.config.channel";
    public static final String FAMILY_SHANDW_CONFIG_KEY = "family.shandw.config.key";
    public static final String FAMILY_SHANDW_CONFIG_APPKEY = "family.shandw.config.appKey";

    public static final String IMCORE_LOGIN_REGISTRY_API = "login.registry.api";//蜂核端登录和注册接口合一api（json入参）
    public static final String IMCORE_GETBYUSERID_API = "login.getByUserId.api";//蜂核端根据用户id获取用户信息及token api

    public static final String ALIBABA_CLOUD_OSS_ACCESSKEY="alibaba.cloud.oss.accessKey";//阿里云OSS AccessKey
    public static final String ALIBABA_CLOUD_OSS_ACCESSKEYSECRET="alibaba.cloud.oss.accessKeySecret";//阿里云OSS AccessKeySecret
    public static final String ALIBABA_CLOUD_OSS_ENDPOINT="alibaba.cloud.oss.endpoint";//阿里云OSS Endpoint(访问域名)
    public static final String ALIBABA_CLOUD_OSS_BUCKETNAME="alibaba.cloud.oss.bucketName";//阿里云OSS bucketName(文件命名空间)
    public static final String ALIBABA_CLOUD_OSS_DOWNLOAD_URL="alibaba.cloud.oss.download.url";//阿里云OSS 文件访问地址

    public static final String FAMILY_MOMENT_SHARE_API="family.moment.share.api";//家园动态分享地址api

    /**
     * 二伟接口参数
     */
    public static final String HTTP_IMCORE_USERID="Userid";//调用二伟接口参数
    /**
     * 查询时是否分页：0表示不分页
     */
    public static final int NO_PAGE = 0;
    /**
     * 查询时是否分页：1表示分页
     */
    public static final int IS_PAGE = 1;

    /**
     * 分页数量显示
     */
    public static final int PAGE_SIZE = 10;

    /** 前端区分 好友|关注|粉丝 */
    public static final int FAMILY_FRIENDS_TYPE_FRIEND = 1;
    public static final int FAMILY_FRIENDS_TYPE_FOLLOW = 2;
    public static final int FAMILY_FRIENDS_TYPE_LIKE = 3;

    /** 前端区分 免打扰状态 点赞|关注|私聊|群聊|系统通知 */
    public static final int FAMILY_DISTURB_TYPE_LIKE = 1;
    public static final int FAMILY_DISTURB_TYPE_FOLLOW = 2;
    public static final int FAMILY_DISTURB_TYPE_PM = 3;
    public static final int FAMILY_DISTURB_TYPE_GROUP = 4;
    public static final int FAMILY_DISTURB_TYPE_SYSTEM = 5;
    public static final int FAMILY_DISTURB_TYPE_MOMENT_LIKE = 6;
    public static final int FAMILY_DISTURB_TYPE_MOMENT_COMMENT = 7;
    public static final int FAMILY_DISTURB_TYPE_MOMENT_AT = 8;

    /** 免打扰状态 [ 1：开启 | 2：关闭 ] */
    public static final int FAMILY_DISTURB_OPEN = 1;
    public static final int FAMILY_DISTURB_CLOSE = 2;

    /** 权限设置 */
    public static final int FAMILY_POWER_PM = 1; //私聊
    public static final int FAMILY_POWER_PV = 2; //家园拜访
    public static final int FAMILY_POWER_MOMENT_COMMENT = 3;    //动态评论
    public static final int FAMILY_POWER_MOMENT_AT = 4;         //动态@通知

    public static final int FAMILY_POWER_PM_STARS_EVERYONE = 0; //无论是否关注我的
    public static final int FAMILY_POWER_PM_STARS_FOLLOW_ME = 1; //关注我的
    public static final int FAMILY_POWER_PM_STARS_I_FOLLOW = 2; //我关注的

    public static final int FAMILY_POWER_PM_HOMELAND_LEVEL_EVERYONE = 0; //任何圈层
    public static final int FAMILY_POWER_PM_HOMELAND_LEVEL_SAME = 1; //相同圈层
    public static final int FAMILY_POWER_PM_HOMELAND_LEVEL_GREATER_OR_EQUAL_TO = 2; //大于等于我的圈层
    public static final int FAMILY_POWER_PM_HOMELAND_LEVEL_CUSTOMIZE = 3; //自定义

    public static final int FAMILY_POWER_PV_STARS_EVERYONE = 0; //无论是否关注我的
    public static final int FAMILY_POWER_PV_STARS_FOLLOW_ME = 1; //关注我的
    public static final int FAMILY_POWER_PV_STARS_I_FOLLOW = 2; //我关注的

    public static final int FAMILY_POWER_PV_HOMELAND_LEVEL_EVERYONE = 0; //任何圈层
    public static final int FAMILY_POWER_PV_HOMELAND_LEVEL_SAME = 1; //相同圈层
    public static final int FAMILY_POWER_PV_HOMELAND_LEVEL_GREATEROREQUALTO = 2; //大于等于我的圈层
    public static final int FAMILY_POWER_PV_HOMELAND_LEVEL_CUSTOMIZE = 3; //自定义

    /** 用户状态 [ 0：正常 | 1：禁用 ] */
    public static final int FAMILY_USER_STATUS_ON = 0;
    public static final int FAMILY_USER_STATUS_OFF = 1;


    /** 二伟接口参数 */
    public static final String ERWEI_IMCORE_GET_TOKEN_CLIENT = "clientid";
    public static final String ERWEI_IMCORE_GET_TOKEN_MD5IN = "MD5In";
    public static final String ERWEI_IMCORE_GET_TOKEN_CREATEDTIME = "createdTime";
    public static final String ERWEI_IMCORE_USERID="userid";
    public static final String ERWEI_IMCORE_CODE="code";
    public static final String ERWEI_IMCORE_PHONE="phone";
    public static final String ERWEI_IMCORE_PHONEAREACODE="phoneAreaCode";
    public static final String ERWEI_IMCORE_INVITATIONCODE="invitationCode";
    public static final String ERWEI_IMCORE_BEARER="Bearer ";
    public static final String ERWEI_IMCORE_RESPONSE_RESULT_CODE="success";
    public static final String ERWEI_IMCORE_RESPONSE_RESULT_MESSAGE="msg";
    /**
     * 用户来源：0家园；1蜂核
     */
    public static final int SOURCE_FAMILY=0;
    /**
     * 用户来源：0家园；1蜂核
     */

    public static final int SOURCE_IMCORE=1;


    /**
     * 融云
     */
    public static final String RONGCLOUD_GET_TOKEN_HEADERS_APP_KEY="App-Key";
    public static final String RONGCLOUD_GET_TOKEN_HEADERS_NONCE="Nonce";
    public static final String RONGCLOUD_GET_TOKEN_HEADERS_TIMESTAMP="Timestamp";
    public static final String RONGCLOUD_GET_TOKEN_HEADERS_SIGNATURE="Signature";
    public static final String RONGCLOUD_GET_TOKEN_PARAM_USERID="userId";
    public static final String RONGCLOUD_GET_TOKEN_PARAM_NAME="name";
    public static final String RONGCLOUD_GET_TOKEN_PARAM_PORTRAITURI="portraitUri";
    public static final String RONGCLOUD_BLACKLIST_PARARM_BLACKUSERID="blackUserId";

    public static final String RONGCLOUD_PUSH_MASSAGE_CONTENT_PARARM_FOLLOW_MSG="关注了你";
    public static final String RONGCLOUD_PUSH_MASSAGE_CONTENT_PARARM_LIKE_MSG="点赞了你";
    public static final String RONGCLOUD_PUSH_MASSAGE_CONTENT_PARARM_OPERATION="operation";
    public static final String RONGCLOUD_PUSH_MASSAGE_CONTENT_PARARM_SOURCEUSERID="sourceUserId";
    public static final String RONGCLOUD_PUSH_MASSAGE_CONTENT_PARARM_TARGETUSERID="targetUserId";
    public static final String RONGCLOUD_PUSH_MASSAGE_CONTENT_PARARM_FILEIDENTIFIER="fileIdentifier";
    public static final String RONGCLOUD_PUSH_MASSAGE_CONTENT_PARARM_FILETYPE="fileType";
    public static final String RONGCLOUD_PUSH_MASSAGE_CONTENT_PARARM_MESSAGE="message";
    public static final String RONGCLOUD_PUSH_MASSAGE_CONTENT_PARARM_NOTIFICATIONCONTENT="notificationContent";
    public static final String RONGCLOUD_PUSH_MASSAGE_CONTENT_PARARM_TYPE="type";
    public static final String RONGCLOUD_PUSH_MASSAGE_CONTENT_PARARM_EXTRA="extra";
    public static final String RONGCLOUD_PUSH_MASSAGE_CONTENT_PARARM_EXTRAS="extras";
    public static final String RONGCLOUD_PUSH_MASSAGE_CONTENT_PARARM_NICKNAME="nickName";
    public static final String RONGCLOUD_PUSH_MASSAGE_CONTENT_PARARM_READ_COUNT="read";
    public static final String RONGCLOUD_PUSH_MASSAGE_PARARM_FROMUSERID="fromUserId";
    public static final String RONGCLOUD_PUSH_MASSAGE_PARARM_TOUSERID="toUserId";
    public static final String RONGCLOUD_PUSH_MASSAGE_PARARM_CONTENT="content";
    public static final String RONGCLOUD_PUSH_MASSAGE_PARARM_PUSHDATA="pushData";
    public static final String RONGCLOUD_PUSH_MASSAGE_PARARM_PUSHEXT="pushExt";
    public static final String RONGCLOUD_PUSH_MASSAGE_PARARM_USERINFO="user";
    public static final String RONGCLOUD_PUSH_MASSAGE_PARARM_OBJECTNAME="objectName";
    public static final String RONGCLOUD_PUSH_MASSAGE_PARARM_OBJECTNAME_FAMILY_FOLLOW="FAMILY_FOLLOW";
    public static final String RONGCLOUD_PUSH_MASSAGE_PARARM_OBJECTNAME_FAMILY_LIKE="FAMILY_LIKE";
    public static final String RONGCLOUD_PUSH_MASSAGE_PARARM_OBJECTNAME_FAMILY_COMMON="FAMILY_NOTICE";
    public static final String RONGCLOUD_PUSH_MASSAGE_PARARM_PUSHCONTENT="pushContent";

    public static final int RONGCLOUD_PUSH_MASSAGE_TYPE_FAMILY_FOLLOW=1;
    public static final int RONGCLOUD_PUSH_MASSAGE_TYPE_FAMILY_LIKE=2;
    public static final int RONGCLOUD_PUSH_MASSAGE_TYPE_FAMILY_NOTICE=3;
    public static final int RONGCLOUD_PUSH_MASSAGE_TYPE_FAMILY_MOMENT_LIKE=21;
    public static final int RONGCLOUD_PUSH_MASSAGE_TYPE_FAMILY_MOMENT_COMMENT=22;
    public static final int RONGCLOUD_PUSH_MASSAGE_TYPE_FAMILY_MOMENT_AT=23;
    /**
     * 审核失败响应
     */
    public static final String VERIFY_FAIL_NICKNAME_TOO_SHORT="昵称至少输入";
    public static final String VERIFY_FAIL_NICKNAME_FAIL="Nonce";


    /**
     * 审核状态
     */
    public static final int VERIFY_STATUS_SUCCESS=1;
    public static final int VERIFY_STATUS_BLOCK=2;
    public static final int VERIFY_STATUS_FAIL=3;

    /**
     * 拉黑状态
     */

    public static final int FAMILY_BLACKLIST_STATUS_NOT_UP=1;       //当前用户未被目标用户拉黑
    public static final int FAMILY_BLACKLIST_STATUS_CURRENT_UP=2;   //当前用户拉黑了目标用户
    public static final int FAMILY_BLACKLIST_STATUS_OTHER_UP=3;     //当前用户被目标用户拉黑
    public static final int FAMILY_BLACKLIST_STATUS_EACHOTHER_UP=4; //当前用户与目标用户相互拉黑

    /**
     * 聊天室扩容阈值
     */
    public static final int FAMILY_ROOM_EXPANSION_SILL=10000;       //聊天室扩容阈值
    public static final String[] FAMILY_ROOM_PREFER_NAME_POOL= {"888","666","886","868","866","688","686","668","188","166","168","186","118","116"};       //聊天室名称池（产品定的）

    /**
     * 申诉相关
     */
    public static final int FAMILY_APPEAL_STATUS_ON=1;                  //允许申诉
    public static final int FAMILY_APPEAL_STATUS_OFF=2;                 //不允许申诉
    public static final int FAMILY_APPEAL_VERIFY_STATUS_ISNULL=0;       //未提交申诉
    public static final int FAMILY_APPEAL_VERIFY_STATUS_BLOCK=1;        //申诉待审核
    public static final int FAMILY_APPEAL_VERIFY_STATUS_SUCCESS=2;      //申诉审核通过
    public static final int FAMILY_APPEAL_VERIFY_STATUS_FAIL=3;         //申诉审核不通过


    public static final int FAMILY_APPEAL_TYPE_MOMENT=1;                //申诉类型 【动态】
    public static final int FAMILY_APPEAL_TYPE_COMMENT=2;               //申诉类型 【评论】
    public static final int FAMILY_APPEAL_TYPE_FILE=3;                  //申诉类型 【文件】



    /**
     * 调用第三方请求方式0:postKeyValue;1:postJson;2getKeyValue
     */
    public static final Integer POST_KEY_VALUE=0;
    public static final Integer POST_JSON=1;
    public static final Integer GET_KEY_VALUE=2;

    /**
     * 系统类型 【 1：安卓 | 2：IOS 】
     */
    int REQUEST_HEADER_OSTYPE_ANDROID = 1;
    int REQUEST_HEADER_OSTYPE_IOS = 2;

    String REQUEST_HEADER_OSTYPE = "osType";

    /**
     * Redis 存储前缀
     */
    String REDIS_VERIFYNOTICE_PREFIX = "verifyNotice:";

    /**
     * 封号状态
     */
    int FAMILY_USER_BLOCKADE_ON = 0;
    int FAMILY_USER_BLOCKADE_OFF = 1;

    /**
     * 置顶状态
     */
    int FAMILY_MOMENT_TOP_STATUS_ON = 1;
    int FAMILY_MOMENT_TOP_STATUS_OFF = 0;

    /**
     * 动态|评论
     */
    int FAMILY_MOMENT = 1;
    int FAMILY_COMMENT = 2;

    /**
     * Elastic Search 索引
     */
    String FAMILY_ES_INDEX_MOMENT = "family-moment";

    /**
     * 第三方登录方式：0:qq 1:微信  2:微博,4苹果登录'
     */
    public static final int THIRD_LOGIN_TYPE_QQ=0;
    public static final int THIRD_LOGIN_TYPE_WEIXIN=1;
    public static final int THIRD_LOGIN_TYPE_WEIBO=2;
    public static final int THIRD_LOGIN_TYPE_IOS=4;


    /**
     * 家园用户注册方式：注册方式：0手机号，1微信，2qq，3苹果,4微博
     */
    public static final int REGISTRY_MODE_PHONE=0;
    public static final int REGISTRY_MODE_WEIXIN=1;
    public static final int REGISTRY_MODE_QQ=2;
    public static final int REGISTRY_MODE_IOS=3;
    public static final int REGISTRY_MODE_WEIBO=4;



    /**
     * Redis 动态|评论 缓存key
     */
    String ZSET_KEY_MOMENT = "family_zset_moment";//动态得分key
    String SIMPLE_KEY_MOMENT_PREFIX = "family_simple_moment:";//动态数据key
    String ZSET_KEY_COMMENT = "family_zset_comment:";//评论得分key （一组评论得分，对应一个动态）
    String SIMPLE_KEY_COMMENT_PREFIX = "family_simple_comment:";//评论数据key
    String ZSET_KEY_TOPIC = "family_zset_topic:";//话题得分key （一组动态得分，对应一个话题）


    /**
     * 动态内容类型
     */
    String FAMILY_MOMENT_CONTENT_TYPE_STRING = "1,";
    String FAMILY_MOMENT_CONTENT_TYPE_IMG = "2,";
    String FAMILY_MOMENT_CONTENT_TYPE_VOICE = "3,";

    /**
     * 推荐动态 下拉|上滑
     */
    int FAMILY_MOMENT_RECOMMEND_GESTURE_DROPDOWN = 1;
    int FAMILY_MOMENT_RECOMMEND_GESTURE_SLIDEUP  = 2;

    /**
     * 举报配置：1用户、2动态
     */
    public static int REPORT_CONFIG_USER=1;
    public static int REPORT_CONFIG_MOMENT=2;


}
