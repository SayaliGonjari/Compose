package com.plcoding.navigationdrawercompose.presentation.login

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.plcoding.navigationdrawercompose.model.StoreUserData
import com.plcoding.navigationdrawercompose.ui.theme.Purple200
import com.plcoding.navigationdrawercompose.ui.theme.Purple700

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
val context = LocalContext.current
    val username = remember {
        mutableStateOf(TextFieldValue(""))
    }
    val password = remember {
        mutableStateOf(TextFieldValue(""))
    }
    val dataStorePref = StoreUserData(context = context)
    Box(modifier = Modifier.fillMaxSize()) {
        ClickableText(
            text = AnnotatedString("Sign up here"),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            onClick = { },
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily.Default,
                textDecoration = TextDecoration.Underline,
                color = Purple700
            )
        )
    }

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Login", style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive))
        Spacer(modifier = Modifier.height(20.dp))

        TextField(label = { Text(text = "Username") }, value = username.value, onValueChange = {})
        Spacer(modifier = Modifier.height(20.dp))
        TextField(label = { Text(text = "Password") }, value = password.value, onValueChange = {})
        Box(modifier = Modifier.padding(40.dp, 20.dp, 40.dp, 0.dp)) {
            Button(
                onClick = {}, shape = RoundedCornerShape(30.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp), colors = ButtonDefaults.buttonColors(Color(0xFFB881C2))
            ) {
                Text(text = "Login")
            }
            Spacer(modifier = Modifier.height(50.dp))
        }

        ClickableText(
            text = AnnotatedString("Forgot Password?"), onClick = {},
            style = TextStyle(fontSize = 14.sp, fontFamily = FontFamily.Default, textAlign = TextAlign.End),
        )

    }


    /*
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)) {


            Text(
                modifier = Modifier
                    .padding(16.dp, 0.dp)
                    .alpha(0.6f),
                text = "EMAIL",
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray,
                fontSize = 16.sp
            )
            //OutlinedTextField(value = ema, onValueChange = )

        }*/
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    val navController = rememberNavController()
    LoginScreen(navController)
}