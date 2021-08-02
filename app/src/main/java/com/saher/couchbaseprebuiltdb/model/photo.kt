package com.saher.couchbaseprebuiltdb.model

data class photo(
    val owner: String,
    val server: String,
    val height_s: String,
    val width_s: String,
    val url_s: String,
    val ispublic: String,
    val isfriend: String,
    val farm: String,
    var id: String,
    val secret: String,
    val title: String,
    val isfamily: String
)

