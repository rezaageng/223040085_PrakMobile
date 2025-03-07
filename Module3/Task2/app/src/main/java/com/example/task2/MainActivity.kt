package com.example.task2

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task2.ui.theme.Pink40
import com.example.task2.ui.theme.Purple80
import com.example.task2.ui.theme.Task2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Task2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegisterForm(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun RegisterForm(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val name = remember { mutableStateOf(TextFieldValue("")) }
    val username = remember { mutableStateOf(TextFieldValue("")) }
    val email = remember { mutableStateOf(TextFieldValue("")) }
    val phone = remember { mutableStateOf(TextFieldValue("")) }
    val address = remember { mutableStateOf(TextFieldValue("")) }
    val password = remember { mutableStateOf(TextFieldValue("")) }

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "Name", modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )
        TextField(
            value = name.value,
            onValueChange = { name.value = it },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )

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
            text = "Email", modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )
        TextField(
            value = email.value,
            onValueChange = { email.value = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )

        Text(
            text = "Phone", modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )
        TextField(
            value = phone.value,
            onValueChange = { phone.value = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )

        Text(
            text = "Address", modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth()
        )
        TextField(
            value = address.value,
            onValueChange = { address.value = it },
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
                    if (name.value.text.isEmpty() || username.value.text.isEmpty() || email.value.text.isEmpty() || phone.value.text.isEmpty() || address.value.text.isEmpty() || password.value.text.isEmpty()) {
                        Toast.makeText(context, "Please fill empty fields", Toast.LENGTH_SHORT).show()
                        return@Button
                    }

                    Toast.makeText(context, "Hello ${name.value.text}", Toast.LENGTH_SHORT).show()
                },
                modifier = modifier
                    .weight(5f)
                    .padding(4.dp), colors = ButtonDefaults.buttonColors(
                    contentColor = Pink40,
                    containerColor = Purple80
                )
            ) {
                Text(
                    text = "Save",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ),
                )
            }

            Button(
                onClick = {
                    name.value = TextFieldValue("")
                    username.value = TextFieldValue("")
                    email.value = TextFieldValue("")
                    phone.value = TextFieldValue("")
                    address.value = TextFieldValue("")
                    password.value = TextFieldValue("")
                },
                modifier = modifier
                    .weight(5f)
                    .padding(4.dp), colors = ButtonDefaults.buttonColors(
                    contentColor = Pink40,
                    containerColor = Color.LightGray
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

