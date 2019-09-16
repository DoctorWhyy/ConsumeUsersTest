package com.my.consumeuserstest.domain.model

import com.fasterxml.jackson.annotation.JsonProperty

data class UserList(@JsonProperty("id")
                    val id:Int,
                    @JsonProperty("first_name")
                    val firstName:String,
                    @JsonProperty("last_name")
                    val lastName:String,
                    @JsonProperty("email")
                    val email:String,
                    @JsonProperty("avatar_url")
                    val avatarUrl:String?,
                    @JsonProperty("created_at")
                    val createdDate:String,
                    @JsonProperty("updated_at")
                    val updatedDate:String,
                    @JsonProperty("url")
                    val url:String?

)