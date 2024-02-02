package com.joaorodrigues.taskscomposeapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.joaorodrigues.taskscomposeapp.ui.theme.Black
import com.joaorodrigues.taskscomposeapp.ui.theme.LightBlue
import com.joaorodrigues.taskscomposeapp.ui.theme.ShapeEditText
import com.joaorodrigues.taskscomposeapp.ui.theme.White

@Composable
fun TextBox(
    value : String,
    onValueChange : (String) -> Unit,
    modifier: Modifier,
    label: String,
    maxLines: Int,
    keyboardType: KeyboardType
) {

    OutlinedTextField(value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = { Text(text = label) },
        maxLines = maxLines,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Black,
            focusedLabelColor = LightBlue,
            cursorColor = LightBlue,
            focusedContainerColor = White,
            focusedIndicatorColor = LightBlue,
        ),
        shape = ShapeEditText.small,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )

}

@Composable
@Preview
fun TextBoxPreview() {
    TextBox(
        value = "",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        label = "Label",
        maxLines = 1,
        keyboardType = KeyboardType.Text
    )
}