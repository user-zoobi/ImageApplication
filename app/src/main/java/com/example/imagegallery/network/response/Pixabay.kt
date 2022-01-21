package com.example.imagegallery.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
class Pixabay{
@SerializedName("total")
@Expose
val total: Int? = null

@SerializedName("totalHits")
@Expose
val totalHits: Int? = null

@SerializedName("hits")
@Expose
val hits: List<Hit>? = null

inner class Hit{

  @SerializedName("id")
  @Expose
  val id: Int? = null

  @SerializedName("pageURL")
  @Expose
  val pageURL: String? = null

  @SerializedName("type")
  @Expose
  val type: String? = null

  @SerializedName("tags")
  @Expose
  val tags: String? = null

  @SerializedName("previewURL")
  @Expose
  val previewURL: String? = null

  @SerializedName("previewWidth")
  @Expose
  val previewWidth: Int? = null

  @SerializedName("previewHeight")
  @Expose
  val previewHeight: Int? = null

  @SerializedName("webformatURL")
  @Expose
  val webformatURL: String? = null

  @SerializedName("webformatWidth")
  @Expose
  val webformatWidth: Int? = null

  @SerializedName("webformatHeight")
  @Expose
  val webformatHeight: Int? = null

  @SerializedName("largeImageURL")
  @Expose
  val largeImageURL: String? = null

  @SerializedName("imageWidth")
  @Expose
  val imageWidth: Int? = null

  @SerializedName("imageHeight")
  @Expose
  val imageHeight: Int? = null

  @SerializedName("imageSize")
  @Expose
  val imageSize: Int? = null

  @SerializedName("views")
  @Expose
  val views: Int? = null

  @SerializedName("downloads")
  @Expose
  val downloads: Int? = null

  @SerializedName("collections")
  @Expose
  val collections: Int? = null

  @SerializedName("likes")
  @Expose
  val likes: Int? = null

  @SerializedName("comments")
  @Expose
  val comments: Int? = null

  @SerializedName("user_id")
  @Expose
  val userId: Int? = null

  @SerializedName("user")
  @Expose
  val user: String? = null

  @SerializedName("userImageURL")
  @Expose
  val userImageURL: String? = null

  }
}