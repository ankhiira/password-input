package com.example.signinsample.common.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.signinsample.ui.theme.AppTheme

@Composable
fun InputView(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isOptional: Boolean = false,
    modifier: Modifier = Modifier,
    placeholder: String? = null,
    textStyle: TextStyle = AppTheme.typography.bodyM,
    borderColor: Color = AppTheme.colors.surfaceXHigh,
    focusedBorderColor: Color = AppTheme.colors.defaultFocus,
    labelColor: Color = AppTheme.colors.onNeutralXxHigh,
    focusedLabelColor: Color = AppTheme.colors.defaultFocus,
    isError: Boolean = false,
    errorMessage: String? = null,
    cornerRadius: Dp = AppTheme.radius.radiusInput,
    actions: (@Composable RowScope.() -> Unit)? = null,
    visualTransformation: VisualTransformation,
    trailingIcon: (@Composable () -> Unit)? = null
) {
    val focusRequester = remember { FocusRequester() }
    val focusState = remember { mutableStateOf(false) }

    val effectiveBorderColor = when {
        isError -> AppTheme.colors.surfaceDanger
        focusState.value -> focusedBorderColor
        else -> borderColor
    }

    val effectiveLabelColor = when {
        isError -> AppTheme.colors.onNeutralDanger
        focusState.value -> focusedLabelColor
        else -> labelColor
    }

    Column {
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = label,
                modifier = Modifier.alignBy(LastBaseline),
                color = effectiveLabelColor,
                style = AppTheme.typography.labelM
            )
            if (isOptional) {
                Spacer(modifier = Modifier.width(AppTheme.spacing.spacingXs))
                Text(
                    text = "Optional",
                    modifier = Modifier.alignBy(LastBaseline),
                    color = AppTheme.colors.onNeutralLow,
                    style = AppTheme.typography.labelS
                )
            }
        }
        Spacer(modifier = Modifier.height(AppTheme.spacing.spacingXs))
        Box(
            modifier = modifier
                .focusRequester(focusRequester)
                .onFocusChanged { focusState.value = it.isFocused }
                .border(
                    width = 1.dp,
                    color = effectiveBorderColor,
                    shape = RoundedCornerShape(cornerRadius)
                )
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                textStyle = textStyle.merge(TextStyle(color = Color.Black)),
                cursorBrush = SolidColor(Color.Black),
                modifier = Modifier
                    .padding(vertical = AppTheme.spacing.spacingS)
                    .padding(start = AppTheme.spacing.spacingM, end = AppTheme.spacing.spacingXs)
                    .fillMaxWidth(),
                decorationBox = { innerTextField ->
                    if (value.isEmpty() && !placeholder.isNullOrEmpty()) {
                        Text(
                            text = placeholder,
                            color = AppTheme.colors.onNeutralLow,
                            style = AppTheme.typography.bodyM
                        )
                    }
                    innerTextField()
                },
                visualTransformation = visualTransformation
            )

            if (trailingIcon != null) {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(start = AppTheme.spacing.spacingXs)
                ) {
                    trailingIcon()
                }
            }
        }
        if (isError && !errorMessage.isNullOrEmpty()) {
            Text(
                text = errorMessage,
                color = AppTheme.colors.onNeutralDanger,
                style = AppTheme.typography.bodyM,
                modifier = Modifier.padding(start = 4.dp, top = 4.dp)
            )
        }
    }
}