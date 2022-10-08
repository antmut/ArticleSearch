package com.codepath.articlesearch

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//   "response"   // nested JSON
@Keep
@Serializable
data class SearchNewsResponse(
    @SerialName("response")
    val response: BaseResponse?
)

//  "response"   // nested JSON
// ├─ "docs"  // list of JSON objects

@Keep
@Serializable
data class BaseResponse(
    @SerialName("docs")
    val docs: List<Article>?
)

//"response"            // nested JSON
//├─ "docs"           // list of JSON objects
//├─ Article[0]
//├─ "abstract"   // String
//├─ "byline"     // nested JSON
//├─ "headline"   // nested JSON
//├─ "multimedia" // list of JSON objects

@Keep
@Serializable
data class Article(
    @SerialName("abstract")
    val abstract: String?,
    @SerialName("byline")
    val byline: Byline?,
    @SerialName("headline")
    val headline: HeadLine?,
    @SerialName("multimedia")
    val multimedia: List<MultiMedia>?,
)
    : java.io.Serializable {
    val mediaImageUrl = "https://www.nytimes.com/${multimedia?.firstOrNull { it.url != null }?.url ?: ""}"
}

//"headline": {
//    "main": "The Strident Writings of a Young Blake Masters Dog His Senate Run",
//    "kicker": null,
//    "content_kicker": null,
//    "print_headline": "Belligerent Early Writings of an Arizona Republican Dog His Senate Campaign",
//    "name": null,
//    "seo": null,
//    "sub": null
//}

@Keep
@Serializable
data class Byline(
    @SerialName("original")
    val original: String? = null
) : java.io.Serializable

@Keep
@Serializable
data class HeadLine(
    @SerialName("main")
    val main: String
) : java.io.Serializable

//"response"
//├─ "docs"
//├─ Article[0]
//├─ "abstract"   // String
//├─ "byline"
//├─ "original" // String
//├─ "headline"
//├─ "main"     // String
//├─ "multimedia" // list of JSON objects

@Keep
@Serializable
data class MultiMedia(
    @SerialName("url")
    val url: String?
) : java.io.Serializable