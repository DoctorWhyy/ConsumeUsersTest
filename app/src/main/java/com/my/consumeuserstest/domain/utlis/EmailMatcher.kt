package com.my.consumeuserstest.domain.utlis

import java.util.regex.Pattern

class EmailMatcher() {

    fun isValidEmail(email: String): Boolean {
        val pattern = Pattern.compile(Constants.EMAIL_PATTERN)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }
}