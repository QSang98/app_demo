package com.example.demoapp.model

import com.google.gson.annotations.SerializedName

data class UserModel(

	@SerializedName("code")
	val code: Int,

	@SerializedName("data")
	val data1: Data1,

	@SerializedName("message")
	val message: String
)

data class TargetUser2(

	@SerializedName("gender")
	val gender: Int
)

data class Rank(

	@SerializedName("previous_week_rank")
	val previousWeekRank: Any,

	@SerializedName("current_day_rank")
	val currentDayRank: Any,

	@SerializedName("previous_month_rank")
	val previousMonthRank: Any,

	@SerializedName("previous_new_rank")
	val previousNewRank: Any,

	@SerializedName("current_new_rank")
	val currentNewRank: Any,

	@SerializedName("previous_day_rank")
	val previousDayRank: Any,

	@SerializedName("current_week_rank")
	val currentWeekRank: Any,

	@SerializedName("current_month_rank")
	val currentMonthRank: Any
)

data class CallingSetting1(

	@SerializedName("received")
	val received: Boolean
)

data class Data1(
	@SerializedName("about")
	val about: String,

	@SerializedName("bir")
	val bir: String,

	@SerializedName("user_name")
	val userName: String,

	@SerializedName("ava_id")
	val avaId: String,

	@SerializedName("email")
	val email: String,
)
