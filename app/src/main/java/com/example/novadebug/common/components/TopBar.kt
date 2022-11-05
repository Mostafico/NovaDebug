package com.example.novadebug.common.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.novadebug.R

@Composable
fun TopBar() {
    TopAppBar(
        title =
        {
            Text(
                text = stringResource(id = R.string.app_name)
            )
        }
    )
}