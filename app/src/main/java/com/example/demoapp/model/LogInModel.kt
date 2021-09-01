package com.example.demoapp.model

import com.google.gson.annotations.SerializedName

data class LogInModel(

    @field:SerializedName("code")
    val code: Int,

    @field:SerializedName("data")
    val data: Data,

    @field:SerializedName("message")
    val message: String
)

data class CallingSetting(

    @field:SerializedName("received")
    val received: Boolean
)

data class TargetUser2(
    val any: Any? = null
)

data class Data(

    @field:SerializedName("faq_setting_ios")
    val faqSettingIos: Boolean,

    @field:SerializedName("account_type")
    val accountType: Int,

    @field:SerializedName("about")
    val about: String,

    @field:SerializedName("welcome_back")
    val welcomeBack: Boolean,

    @field:SerializedName("turn_off_show_news")
    val turnOffShowNews: Boolean,

    @field:SerializedName("finish_register_flag")
    val finishRegisterFlag: Int,

    @field:SerializedName("fav_num")
    val favNum: Int,

    @field:SerializedName("ip_account_type")
    val ipAccountType: Int,

    @field:SerializedName("day_bns_pnt")
    val dayBnsPnt: Double,

    @field:SerializedName("accessed_pages")
    val accessedPages: List<Any>,

    @field:SerializedName("user_type")
    val userType: Int,

    @field:SerializedName("special_fortune")
    val specialFortune: List<Any>,

    @field:SerializedName("is_show_popup_mission")
    val isShowPopupMission: Boolean,

    @field:SerializedName("top_page_point_android")
    val topPagePointAndroid: Boolean,

    @field:SerializedName("advice_styles")
    val adviceStyles: List<Any>,

    @field:SerializedName("get_free_point")
    val getFreePoint: Boolean,

    @field:SerializedName("turn_off_user_info_android")
    val turnOffUserInfoAndroid: Boolean,

    @field:SerializedName("bckstg_time")
    val bckstgTime: Int,

    @field:SerializedName("ios_upgrade_link")
    val iosUpgradeLink: String,

    @field:SerializedName("last_online")
    val lastOnline: Long,

    @field:SerializedName("application_id")
    val applicationId: String,

    @field:SerializedName("chat_num")
    val chatNum: Int,

    @field:SerializedName("reg_date")
    val regDate: String,

    @field:SerializedName("refresh_token")
    val refreshToken: String,

    @field:SerializedName("is_verified_age")
    val isVerifiedAge: Boolean,

    @field:SerializedName("reg_pnt")
    val regPnt: Double,

    @field:SerializedName("user_id")
    val userId: String,

    @field:SerializedName("calling_setting")
    val callingSetting: CallingSetting,

    @field:SerializedName("original_pwd")
    val originalPwd: String,

    @field:SerializedName("top_page_point_ios")
    val topPagePointIos: Boolean,

    @field:SerializedName("gender")
    val gender: Int,

    @field:SerializedName("switch_browser_android_version")
    val switchBrowserAndroidVersion: String,

    @field:SerializedName("user_name")
    val userName: String,

    @field:SerializedName("noti_num")
    val notiNum: Int,

    @field:SerializedName("backlst")
    val backlst: List<String>,

    @field:SerializedName("top_banner_ios")
    val topBannerIos: Boolean,

    @field:SerializedName("target_user2")
    val targetUser2: TargetUser2,

    @field:SerializedName("switch_safari_version")
    val switchSafariVersion: String,

    @field:SerializedName("price_setting_ios")
    val priceSettingIos: Boolean,

    @field:SerializedName("fvt_num")
    val fvtNum: Int,

    @field:SerializedName("point")
    val point: Double,

    @field:SerializedName("top_banner_android")
    val topBannerAndroid: Boolean,

    @field:SerializedName("certified")
    val certified: Int,

    @field:SerializedName("good_image_number")
    val goodImageNumber: Int,

    @field:SerializedName("ava_id")
    val avaId: String,

    @field:SerializedName("save_img_pnt")
    val saveImgPnt: Double,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("show_tutorial")
    val showTutorial: Boolean,

    @field:SerializedName("get_free_point_android")
    val getFreePointAndroid: Boolean,

    @field:SerializedName("user_status")
    val userStatus: Int,

    @field:SerializedName("comment_buzz_pnt")
    val commentBuzzPnt: Double,

    @field:SerializedName("term_of_use_setting_ios")
    val termOfUseSettingIos: Boolean,

    @field:SerializedName("review_mode_ip_ios")
    val reviewModeIpIos: Boolean,

    @field:SerializedName("turn_off_show_news_android")
    val turnOffShowNewsAndroid: Boolean,

    @field:SerializedName("turn_off_user_info")
    val turnOffUserInfo: Boolean,

    @field:SerializedName("is_verify")
    val isVerify: Boolean,

    @field:SerializedName("bckstg_pri")
    val bckstgPri: Double,

    @field:SerializedName("token")
    val token: String,

    @field:SerializedName("trouble_tags")
    val troubleTags: List<Any>,

    @field:SerializedName("onl_alt_pnt")
    val onlAltPnt: Double,

    @field:SerializedName("performer_buy_point_ios")
    val performerBuyPointIos: Boolean,

    @field:SerializedName("user_level")
    val userLevel: Int,

    @field:SerializedName("android_upgrade_link")
    val androidUpgradeLink: String
)
