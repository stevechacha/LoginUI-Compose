package com.steve.jetpackcomposebasics

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.steve.jetpackcomposebasics.ui.theme.SignInTheme
import com.steve.jetpackcomposebasics.ui.theme.Shapes

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignInTheme {
                Surface(color = MaterialTheme.colors.background) {
                    RegisterScreen(mContext = this@RegisterActivity)
                }
            }
        }
    }
}

@Composable
fun RegisterScreen(mContext:Context) {
    Column(modifier = Modifier.padding(16.dp)) {
        HeadRegisterText()
        Spacer(modifier = Modifier.height(64.dp))
        UsernameTextField()
        Spacer(modifier = Modifier.height(4.dp))
        EmailTextField()
        Spacer(modifier = Modifier.height(4.dp))
        PasswordTextField()
        Spacer(modifier = Modifier.height(64.dp))
        ButtonToRegister()
        Spacer(modifier = Modifier.height(16.dp))
        ButtonFBRegister()
        Spacer(modifier = Modifier.height(48.dp))
        ButtonToLogin(onClick = {
            mContext.startActivity(Intent(mContext, MainActivity::class.java))
        })
    }
}
@Composable
private fun HeadRegisterText() {
    Text(text = "Create Account", fontWeight = FontWeight.Bold, fontSize = 32.sp)
    Spacer(modifier = Modifier.height(2.dp))
    Text(text = "Sign in to get started", fontWeight = FontWeight.Bold,fontSize=26.sp, color = Color.Gray)
}
@Composable
private fun UsernameTextField() {
    var username by remember { mutableStateOf("") }

    OutlinedTextField(value = username,
        onValueChange = {username=it},
        label = { Text(text = "Username") },
        modifier = Modifier.fillMaxWidth()
    )

}
@Composable
private fun EmailTextField() {
    var email by remember { mutableStateOf("") }

    OutlinedTextField(value = email,
        onValueChange = {email=it},
        label = { Text(text = "Email") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )

}
@Composable
private fun PasswordTextField() {
    var password by remember { mutableStateOf("") }

    OutlinedTextField(value = password,
        onValueChange = {password=it},
        label = { Text(text = "Password") },
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )

}
@Composable
private fun ButtonToRegister(){
    Button(onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 16.dp,horizontal = 16.dp)
    ) {

        Text(text = "Register")
    }
}

@Composable
private fun ButtonFBRegister(){
    Button(onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 16.dp,horizontal = 16.dp),
        elevation = ButtonDefaults.elevation(0.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
        shape = Shapes.large
    ) {

        Row(verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(id = R.drawable.facebok),
                contentDescription = "")
            Text(text = "Connect to facebook",color= Color.Blue)

        }
    }
}
@Composable
private fun ButtonToLogin(onClick: () -> Unit){
    Row(horizontalArrangement = Arrangement.Center,modifier = Modifier.fillMaxWidth()) {

        Text(text = "Don't have an account")
        Text(text = "SignIn",
            color=MaterialTheme.colors.primary,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.clickable (onClick = onClick))

    }

}



