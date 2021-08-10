package com.steve.jetpackcomposebasics

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignInTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LoginScreen(mContext = this@MainActivity)
                }
            }
        }
    }
}

@Composable
fun LoginScreen(mContext:Context){
    Column(modifier = Modifier.padding(16.dp)) {

        HeaderText()
        Spacer(modifier = Modifier.height(120.dp))
        EmailTextField()
        Spacer(modifier = Modifier.height(4.dp))
        PasswordTextField()
        Spacer(modifier = Modifier.height(64.dp))
        ButtonLogin()
        Spacer(modifier = Modifier.height(16.dp))
        ButtonFBLogin()
        Spacer(modifier = Modifier.height(120.dp))
        ButtonRegister(onClick = {
            mContext.startActivity(Intent(mContext, RegisterActivity::class.java))
        })

    }
}

@Composable
fun HeaderText() {
    Text(text = "Welcome", fontWeight = FontWeight.Bold, fontSize = 12.sp)
    Spacer(modifier = Modifier.height(2.dp))
    Text(text = "Sign in to continue", fontWeight = FontWeight.Bold,fontSize=26.sp, color = Color.Gray)
}
@Composable
private fun EmailTextField() {
    var email by remember { mutableStateOf("")}
    
    OutlinedTextField(value = email,
        onValueChange = {email=it},
        label = {Text(text = "Email")},
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )

}
@Composable
private fun PasswordTextField() {
    var password by remember { mutableStateOf("")}

    OutlinedTextField(value = password,
        onValueChange = {password=it},
        label = {Text(text = "Password")},
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)

    )

}
@Composable
private fun ButtonLogin(){
    Button(onClick = { /*TODO*/ },
    modifier = Modifier.fillMaxWidth(),
    contentPadding = PaddingValues(vertical = 16.dp,horizontal = 16.dp)) {

        Text(text = "Login")
    }
}

@Composable
private fun ButtonFBLogin(){
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
            Text(text = "Connect to facebook",color=Color.Blue)

        }
    }
}
@Composable
private fun ButtonRegister(onClick: () -> Unit){
    Row(horizontalArrangement = Arrangement.Center,modifier = Modifier.fillMaxWidth()) {

        Text(text = "Don't have an account")
        Text(text = "Sign Up",
        color=MaterialTheme.colors.primary,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.clickable (onClick = onClick))

    }

}




