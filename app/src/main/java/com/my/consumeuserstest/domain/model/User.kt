package com.my.testproject2.domain.model


import com.fasterxml.jackson.annotation.JsonProperty

data class User(@JsonProperty("id")
                val id: Int,
                @JsonProperty("avatar_url")
                val avatarUrl: String,
                @JsonProperty("email")
                var email: String,
                @JsonProperty("first_name")
                var firstName: String,
                @JsonProperty("last_name")
                var lastName: String
)