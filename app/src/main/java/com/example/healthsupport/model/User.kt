package com.example.healthsupport.model

data class User(
    val id: String?,
    val userId: String,
    val displayName: String,
    val avatarUrl: String,
    val size: String,
    val weight: String
){
    fun toMap(): MutableMap<String, Any>{
        return mutableMapOf(
            "user_id" to this.userId,
            "display_name" to this.displayName,
            "size" to this.size,
            "weight" to this.weight,
            "avatar_url" to this.avatarUrl
        )
    }
}