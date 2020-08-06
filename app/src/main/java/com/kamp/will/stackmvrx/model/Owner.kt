package com.kamp.will.stackmvrx.model

import com.squareup.moshi.Json

@Suppress("unused")
data class Owner(
    @Json(name = "reputation") val reputation: Int? = null,
    @Json(name = "user_id") val userId: Int? = null,
    @Json(name = "user_type") val userType: String? = null,
    @Json(name = "profile_image") val profileImage: String? = null,
    @Json(name = "display_name") val displayName: String? = null,
    @Json(name = "link") val link: String? = null
)
