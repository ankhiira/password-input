package com.example.signinsample.common.validation

import android.content.Context
import com.example.signinsample.R

object PasswordValidator {
    fun validatePassword(context: Context, password: String): Pair<Boolean, String?> {
        val errors = mutableListOf<String>()

        if (password.length < 8) {
            errors += context.getString(R.string.invalid_password_min_8_digits)
        }
        if (!password.any { it.isUpperCase() }) {
            errors += context.getString(R.string.invalid_password_upper_case)
        }
        if (!password.any { it.isDigit() }) {
            errors += context.getString(R.string.invalid_password_number)
        }
        val specialChars = setOf('?', '=', '#', '/', '%')
        if (!password.any { it in specialChars }) {
            errors += context.getString(R.string.invalid_password_special_character)
        }

        return if (errors.isEmpty()) {
            true to null
        } else {
            false to errors.joinToString(separator = "\n") { "• $it" }
        }
    }
}