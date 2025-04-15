package com.example.signinsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.signinsample.common.ui.components.PasswordInput
import com.example.signinsample.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InputView()
        }
    }

    @Composable
    private fun InputView() {
        var password by remember { mutableStateOf("") }

        AppTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(AppTheme.spacing.spacingL),
                ) {
                    PasswordInput(
                        value = password,
                        label = stringResource(R.string.input_label_password),
                        placeholder = stringResource(R.string.input_label_password),
                        isOptional = true
                    ) {
                        password = it
                    }
                }
            }
        }
    }
}