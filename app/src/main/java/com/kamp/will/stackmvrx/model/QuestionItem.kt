package com.kamp.will.stackmvrx.model

import com.squareup.moshi.Json

@Suppress("unused")
class QuestionItem(
    @Json(name = "tags") val tags: List<String>? = null,
    @Json(name = "owner") val owner: Owner? = null,
    @Json(name = "is_answered") val isAnswered: Boolean? = null,
    @Json(name = "view_count") val viewCount: Int? = null,
    @Json(name = "answer_count") val answerCount: Int? = null,
    @Json(name = "score") val score: Int? = null,
    @Json(name = "lastActivity_date") val lastActivityDate: Int? = null,
    @Json(name = "creation_date") val creationDate: Int? = null,
    @Json(name = "question_id") val questionId: Int? = null,
    @Json(name = "link") val link: String? = null,
    @Json(name = "title") val title: String? = null,
    @Json(name = "accepted_answer_id") val acceptedAnswerId: Int? = null,
    @Json(name = "bounty_amount") val bountyAmount: Int? = null,
    @Json(name = "bounty_closes_date") val bountyClosesDate: Int? = null,
    @Json(name = "closed_date") val closedDate: Int? = null,
    @Json(name = "closed_reason") val closedReason: String? = null,
    @Json(name = "protected_date") val protectedDate: Int? = null,
    @Json(name = "community_owned_date") val communityOwnedDate: Int? = null
)
