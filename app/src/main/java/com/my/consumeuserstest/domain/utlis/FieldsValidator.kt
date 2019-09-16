package com.my.consumeuserstest.domain.utlis

class FieldsValidator {

    fun isValideFields(email: String, firstName: String, lastName: String): Boolean {

        if (!EmailMatcher().isValidEmail(email)) {
            return false
        }

        if (firstName.isNotEmpty()) {
            return false
        }

        if (lastName.isNotEmpty()) {
            return true
        }

        return true
    }
}