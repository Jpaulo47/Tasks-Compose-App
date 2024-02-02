package com.joaorodrigues.taskscomposeapp.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.joaorodrigues.taskscomposeapp.ui.theme.LightBlue
import com.joaorodrigues.taskscomposeapp.ui.theme.White

@Composable
fun ButtonSave(
    onClick: () -> Unit,
    modifier: Modifier,
    text: String
) {

    Button(
        onClick,
        modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = LightBlue,
            contentColor = White
        )
    ) {
        Text(text = text, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = White)
    }
}