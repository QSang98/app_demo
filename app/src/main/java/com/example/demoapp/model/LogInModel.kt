package com.example.demoapp.model

import com.google.gson.annotations.SerializedName

data class LogInModel(

    @SerializedName("code")
    val code: Int,

    @SerializedName("data")
    val data: Data,

    @SerializedName("message")
    val message: String
)

data class CallingSetting(

    @SerializedName("received")
    val received: Boolean
)

data class TargetUser2(
    val any: Any? = null
)

data class Data(

    @SerializedName("faq_setting_ios")
    val faqSettingIos: Boolean,

    @SerializedName("account_type")
    val accountType: Int,

    @SerializedName("about")
    val about: String,

    @SerializedName("welcome_back")
    val welcomeBack: Boolean,

    @SerializedName("turn_off_show_news")
    val turnOffShowNews: Boolean,

    @SerializedName("finish_register_flag")
    val finishRegisterFlag: Int,

    @SerializedName("fav_num")
    val favNum: Int,

    @SerializedName("ip_account_type")
    val ipAccountType: Int,

    @SerializedName("day_bns_pnt")
    val dayBnsPnt: Double,

    @SerializedName("accessed_pages")
    val accessedPages: List<Any>,

    @SerializedName("user_type")
    val userType: Int,

    @SerializedName("special_fortune")
    val specialFortune: List<Any>,

    @SerializedName("is_show_popup_mission")
    val isShowPopupMission: Boolean,

    @SerializedName("top_page_point_android")
    val topPagePointAndroid: Boolean,

    @SerializedName("advice_styles")
    val adviceStyles: List<Any>,

    @SerializedName("get_free_point")
    val getFreePoint: Boolean,

    @SerializedName("turn_off_user_info_android")
    val turnOffUserInfoAndroid: Boolean,

    @SerializedName("bckstg_time")
    val bckstgTime: Int,

    @SerializedName("ios_upgrade_link")
    val iosUpgradeLink: String,

    @SerializedName("last_online")
    val lastOnline: Long,

    @SerializedName("application_id")
    val applicationId: String,

    @SerializedName("chat_num")
    val chatNum: Int,

    @SerializedName("reg_date")
    val regDate: String,

    @SerializedName("refresh_token")
    val refreshToken: String,

    @SerializedName("is_verified_age")
    val isVerifiedAge: Boolean,

    @SerializedName("reg_pnt")
    val regPnt: Double,

    @SerializedName("user_id")
    val userId: String,

    @SerializedName("calling_setting")
    val callingSetting: CallingSetting,

    @SerializedName("original_pwd")
    val originalPwd: String,

    @SerializedName("top_page_point_ios")
    val topPagePointIos: Boolean,

    @SerializedName("gender")
    val gender: Int,

    @SerializedName("switch_browser_android_version")
    val switchBrowserAndroidVersion: String,

    @SerializedName("user_name")
    val userName: String,

    @SerializedName("noti_num")
    val notiNum: Int,

    @SerializedName("backlst")
    val backlst: List<String>,

    @SerializedName("top_banner_ios")
    val topBannerIos: Boolean,

    @SerializedName("target_user2")
    val targetUser2: TargetUser2,

    @SerializedName("switch_safari_version")
    val switchSafariVersion: String,

    @SerializedName("price_setting_ios")
    val priceSettingIos: Boolean,

    @SerializedName("fvt_num")
    val fvtNum: Int,

    @SerializedName("point")
    val point: Double,

    @SerializedName("top_banner_android")
    val topBannerAndroid: Boolean,

    @SerializedName("certified")
    val certified: Int,

    @SerializedName("good_image_number")
    val goodImageNumber: Int,

    @SerializedName("ava_id")
    val avaId: String,

    @SerializedName("save_img_pnt")
    val saveImgPnt: Double,

    @SerializedName("email")
    val email: String,

    @SerializedName("show_tutorial")
    val showTutorial: Boolean,

    @SerializedName("get_free_point_android")
    val getFreePointAndroid: Boolean,

    @SerializedName("user_status")
    val userStatus: Int,

    @SerializedName("comment_buzz_pnt")
    val commentBuzzPnt: Double,

    @SerializedName("term_of_use_setting_ios")
    val termOfUseSettingIos: Boolean,

    @SerializedName("review_mode_ip_ios")
    val reviewModeIpIos: Boolean,

    @SerializedName("turn_off_show_news_android")
    val turnOffShowNewsAndroid: Boolean,

    @SerializedName("turn_off_user_info")
    val turnOffUserInfo: Boolean,

    @SerializedName("is_verify")
    val isVerify: Boolean,

    @SerializedName("bckstg_pri")
    val bckstgPri: Double,

    @SerializedName("token")
    val token: String,

    @SerializedName("trouble_tags")
    val troubleTags: List<Any>,

    @SerializedName("onl_alt_pnt")
    val onlAltPnt: Double,

    @SerializedName("performer_buy_point_ios")
    val performerBuyPointIos: Boolean,

    @SerializedName("user_level")
    val userLevel: Int,

    @SerializedName("android_upgrade_link")
    val androidUpgradeLink: String
)
