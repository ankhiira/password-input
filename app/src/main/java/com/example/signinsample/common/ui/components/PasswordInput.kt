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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import com.example.signinsample.common.validation.PasswordValidator.validatePassword
import com.example.signinsample.ui.theme.AppTheme

@Composable
fun PasswordInput(
    value: String,
    modifier: Modifier = Modifier,
    label: String,
    placeholder: String? = null,
    isOptional: Boolean = false,
    validator: (Context, String) -> Pair<Boolean, String?> = ::validatePassword,
    cornerRadius: Dp = AppTheme.radius.radiusInput,
    inputTextStyle: TextStyle = AppTheme.typography.bodyM,
    colors: InputViewColors = defaultInputViewColors(),
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
        modifier = modifier,
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        label = label,
        placeholder = placeholder,
        isOptional = isOptional,
        isError = isError,
        errorMessage = errorMessage,
        inputTextStyle = inputTextStyle,
        cornerRadius = cornerRadius,
        colors = colors,
        visualTransformation = visualTransformation,
        actions = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = "Toggle Password Visibility"
                )
            }
        }
    )
}