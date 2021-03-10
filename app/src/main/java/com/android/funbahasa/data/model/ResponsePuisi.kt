package com.android.funbahasa.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponsePuisi(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null
) : Parcelable

@Parcelize
data class DataItem(

	@field:SerializedName("schedule")
	val schedule: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("type")
	val type: Type? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("post_excerpt")
	val postExcerpt: String? = null,

	@field:SerializedName("content")
	val content: String? = null,

	@field:SerializedName("status")
	val status: Status? = null
) : Parcelable

@Parcelize
data class Status(

	@field:SerializedName("name")
	val name: String? = null
) : Parcelable

@Parcelize
data class User(

	@field:SerializedName("role")
	val role: String? = null,

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("avatar")
	val avatar: String? = null,

	@field:SerializedName("email")
	val email: String? = null
) : Parcelable

@Parcelize
data class Type(

	@field:SerializedName("name")
	val name: String? = null
) : Parcelable
