package com.example.task1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task1.ui.theme.Pink40
import com.example.task1.ui.theme.Purple80
import com.example.task1.ui.theme.Task1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Task1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FormLogin(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun FormLogin(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val username = remember { mutableStateOf(TextFieldValue("")) }
    val password = remember { mutableStateOf(TextFieldValue("")) }

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "Username", modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )
        TextField(
            value = username.value,
            onValueChange = { username.value = it },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )

        Text(
            text = "Password", modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )
        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )

        Spacer(
            modifier = modifier
                .weight(1f)
                .width(0.dp)
        )

        Row(
            modifier = modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Button(
                onClick = {
                    if (username.value.text == "admin" && password.value.text == "admin") {
                        Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
                        return@Button
                    }

                    Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
                },
                modifier = modifier.weight(5f).padding(4.dp), colors = ButtonDefaults.buttonColors(
                    contentColor = Pink40,
                    containerColor = Purple80
                )
            ) {
                Text(
                    text = "Login",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ),
                )
            }

            Button(
                onClick = {
                    username.value = TextFieldValue("")
                    password.value = TextFieldValue("")
                },
                modifier = modifier.weight(5f).padding(4.dp), colors = ButtonDefaults.buttonColors(
                    contentColor = Pink40,
                    containerColor = Purple80
                )
            ) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ),
                )
            }
        }
    }
}

