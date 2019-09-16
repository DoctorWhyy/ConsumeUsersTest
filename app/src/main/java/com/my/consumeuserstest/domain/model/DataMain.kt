package com.my.testproject2.domain.model


import com.fasterxml.jackson.annotation.JsonProperty

data class DataMain(
    @JsonProperty("user")
    val user: User
)