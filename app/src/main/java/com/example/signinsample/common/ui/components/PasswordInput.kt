package com.example.signinsample.common.ui.components

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.signinsample.common.validation.PasswordValidator.validatePassword

@Composable
fun PasswordInput(
    value: String,
    label: String,
    isOptional: Boolean = false,
    validator: (Context, String) -> Pair<Boolean, String?> = ::validatePassword,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    val context = LocalContext.current
    val (isValid, errorMessage) = validator(context, value)
    val isError = value.isNotEmpty() && !isValid
    var passwordVisible by remember { mutableStateOf(false) }
    val visualTransformation = if (passwordVisible) {
        VisualTransformation.None
    } else {
        PasswordVisualTransformation()
    }

    InputView(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        label = label,
        isOptional = isOptional,
        isError = isError,
        errorMessage = errorMessage,
        visualTransformation = visualTransformation,
        trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = "Toggle Password Visibility"
                )
            }
        }
    )
}

@Preview(
    showBackground = true
)
@Composable
private fun PasswordInputPreview() {
    PasswordInput(
        value = "testhTjk1/",
        label = "Password"
    ) {

    }
}