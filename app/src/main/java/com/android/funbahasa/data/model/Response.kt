package com.android.funbahasa.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Response(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("template")
	val template: String? = null,

	@field:SerializedName("qubely_author")
	val qubelyAuthor: QubelyAuthor? = null,

	@field:SerializedName("_links")
	val links: Links? = null,

	@field:SerializedName("jetpack_featured_media_url")
	val jetpackFeaturedMediaUrl: String? = null,

	@field:SerializedName("link")
	val link: String? = null,

//	@field:SerializedName("qubely_featured_image_url")
//	val qubelyFeaturedImageUrl: Any? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("title")
	val title: Title? = null,

	@field:SerializedName("uagb_excerpt")
	val uagbExcerpt: String? = null,

	@field:SerializedName("content")
	val content: Content? = null,

	@field:SerializedName("featured_media")
	val featuredMedia: Int? = null,

	@field:SerializedName("uagb_author_info")
	val uagbAuthorInfo: UagbAuthorInfo? = null,

	@field:SerializedName("qubely_excerpt")
	val qubelyExcerpt: String? = null,

	@field:SerializedName("modified")
	val modified: String? = null,

	@field:SerializedName("qubely_comment")
	val qubelyComment: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("categories")
	val categories: List<Int?>? = null,

	@field:SerializedName("date_gmt")
	val dateGmt: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("modified_gmt")
	val modifiedGmt: String? = null,

	@field:SerializedName("author")
	val author: Int? = null,

	@field:SerializedName("qubely_category")
	val qubelyCategory: String? = null,

	@field:SerializedName("format")
	val format: String? = null,

	@field:SerializedName("comment_status")
	val commentStatus: String? = null,

	@field:SerializedName("yoast_head")
	val yoastHead: String? = null,

//	@field:SerializedName("tags")
//	val tags: List<Any?>? = null,

	@field:SerializedName("blocksy_meta")
	val blocksyMeta: String? = null,

	@field:SerializedName("uagb_featured_image_src")
	val uagbFeaturedImageSrc: UagbFeaturedImageSrc? = null,

//	@field:SerializedName("amp_validity")
//	val ampValidity: Any? = null,

	@field:SerializedName("ping_status")
	val pingStatus: String? = null,

	@field:SerializedName("meta")
	val meta: Meta? = null,

	@field:SerializedName("sticky")
	val sticky: Boolean? = null,

	@field:SerializedName("guid")
	val guid: Guid? = null,

	@field:SerializedName("amp_enabled")
	val ampEnabled: Boolean? = null,

	@field:SerializedName("uagb_comment_info")
	val uagbCommentInfo: Int? = null,

	@field:SerializedName("excerpt")
	val excerpt: Excerpt? = null,

	@field:SerializedName("status")
	val status: String? = null
) : Parcelable

@Parcelize
data class AboutItem(

	@field:SerializedName("href")
	val href: String? = null
) : Parcelable

@Parcelize
data class UagbAuthorInfo(

	@field:SerializedName("author_link")
	val authorLink: String? = null,

	@field:SerializedName("display_name")
	val displayName: String? = null
) : Parcelable

@Parcelize
data class AuthorItem(

	@field:SerializedName("href")
	val href: String? = null,

	@field:SerializedName("embeddable")
	val embeddable: Boolean? = null
) : Parcelable

@Parcelize
data class SelfItem(

	@field:SerializedName("href")
	val href: String? = null
) : Parcelable

@Parcelize
data class Title(

	@field:SerializedName("rendered")
	val rendered: String? = null
) : Parcelable

@Parcelize
data class Meta(

	@field:SerializedName("spay_email")
	val spayEmail: String? = null,

	@field:SerializedName("qubely_interactions")
	val qubelyInteractions: String? = null,

	@field:SerializedName("_coblocks_responsive_height")
	val coblocksResponsiveHeight: String? = null,

	@field:SerializedName("_coblocks_attr")
	val coblocksAttr: String? = null,

	@field:SerializedName("_coblocks_dimensions")
	val coblocksDimensions: String? = null,

	@field:SerializedName("kt_blocks_editor_width")
	val ktBlocksEditorWidth: String? = null,

	@field:SerializedName("qubely_global_settings")
	val qubelyGlobalSettings: String? = null,

	@field:SerializedName("_coblocks_accordion_ie_support")
	val coblocksAccordionIeSupport: String? = null
) : Parcelable

@Parcelize
data class WpAttachmentItem(

	@field:SerializedName("href")
	val href: String? = null
) : Parcelable

@Parcelize
data class RepliesItem(

	@field:SerializedName("href")
	val href: String? = null,

	@field:SerializedName("embeddable")
	val embeddable: Boolean? = null
) : Parcelable

@Parcelize
data class WpTermItem(

	@field:SerializedName("taxonomy")
	val taxonomy: String? = null,

	@field:SerializedName("href")
	val href: String? = null,

	@field:SerializedName("embeddable")
	val embeddable: Boolean? = null
) : Parcelable

@Parcelize
data class Content(

	@field:SerializedName("rendered")
	val rendered: String? = null,

	@field:SerializedName("protected")
	val jsonMemberProtected: Boolean? = null
) : Parcelable

@Parcelize
data class Links(

	@field:SerializedName("curies")
	val curies: List<CuriesItem?>? = null,

	@field:SerializedName("replies")
	val replies: List<RepliesItem?>? = null,

	@field:SerializedName("version-history")
	val versionHistory: List<VersionHistoryItem?>? = null,

	@field:SerializedName("author")
	val author: List<AuthorItem?>? = null,

	@field:SerializedName("wp:term")
	val wpTerm: List<WpTermItem?>? = null,

	@field:SerializedName("about")
	val about: List<AboutItem?>? = null,

	@field:SerializedName("self")
	val self: List<SelfItem?>? = null,

	@field:SerializedName("predecessor-version")
	val predecessorVersion: List<PredecessorVersionItem?>? = null,

	@field:SerializedName("collection")
	val collection: List<CollectionItem?>? = null,

	@field:SerializedName("wp:attachment")
	val wpAttachment: List<WpAttachmentItem?>? = null
) : Parcelable

@Parcelize
data class VersionHistoryItem(

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("href")
	val href: String? = null
) : Parcelable

@Parcelize
data class UagbFeaturedImageSrc(

	@field:SerializedName("thumbnail")
	val thumbnail: Boolean? = null,

	@field:SerializedName("qubely_portrait")
	val qubelyPortrait: Boolean? = null,

	@field:SerializedName("2048x2048")
	val jsonMember2048x2048: Boolean? = null,

	@field:SerializedName("shop_thumbnail")
	val shopThumbnail: Boolean? = null,

	@field:SerializedName("large")
	val large: Boolean? = null,

	@field:SerializedName("qubely_landscape")
	val qubelyLandscape: Boolean? = null,

	@field:SerializedName("woocommerce_gallery_thumbnail")
	val woocommerceGalleryThumbnail: Boolean? = null,

	@field:SerializedName("woocommerce_thumbnail")
	val woocommerceThumbnail: Boolean? = null,

	@field:SerializedName("medium")
	val medium: Boolean? = null,

	@field:SerializedName("1536x1536")
	val jsonMember1536x1536: Boolean? = null,

	@field:SerializedName("woocommerce_single")
	val woocommerceSingle: Boolean? = null,

	@field:SerializedName("shop_single")
	val shopSingle: Boolean? = null,

	@field:SerializedName("medium_large")
	val mediumLarge: Boolean? = null,

	@field:SerializedName("qubely_thumbnail")
	val qubelyThumbnail: Boolean? = null,

	@field:SerializedName("shop_catalog")
	val shopCatalog: Boolean? = null,

	@field:SerializedName("full")
	val full: Boolean? = null
) : Parcelable

@Parcelize
data class QubelyAuthor(

	@field:SerializedName("author_link")
	val authorLink: String? = null,

	@field:SerializedName("display_name")
	val displayName: String? = null
) : Parcelable

@Parcelize
data class PredecessorVersionItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("href")
	val href: String? = null
) : Parcelable

@Parcelize
data class Excerpt(

	@field:SerializedName("rendered")
	val rendered: String? = null,

	@field:SerializedName("protected")
	val jsonMemberProtected: Boolean? = null
) : Parcelable

@Parcelize
data class CuriesItem(

	@field:SerializedName("templated")
	val templated: Boolean? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("href")
	val href: String? = null
) : Parcelable

@Parcelize
data class CollectionItem(

	@field:SerializedName("href")
	val href: String? = null
) : Parcelable

@Parcelize
data class Guid(

	@field:SerializedName("rendered")
	val rendered: String? = null
) : Parcelable
