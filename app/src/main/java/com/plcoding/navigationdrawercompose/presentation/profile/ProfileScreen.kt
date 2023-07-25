package com.plcoding.navigationdrawercompose.presentation.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.navigationdrawercompose.R

@Composable
fun ProfileScreen() {
    CreateCard()
}

@Preview
@Composable
fun CreateCard() {
    val buttonClickState = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            elevation = 2.dp,
            backgroundColor = Color.White,
            shape = RoundedCornerShape(15.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreateProfile()
                Divider(modifier = Modifier.padding(top = 7.dp))
                Button(modifier = Modifier.padding(top = 10.dp),
                    onClick = { buttonClickState.value = !buttonClickState.value },
                    colors = ButtonDefaults.buttonColors(
                        Color(0xFFB881C2),
                        contentColor = Color.White
                    ), shape = RoundedCornerShape(10.dp),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 5.dp,
                        pressedElevation = 12.dp,
                        disabledElevation = 0.dp
                    )

                ) {
                    Text("Portfolio", fontSize = 15.sp, fontStyle = FontStyle.Normal)
                }
                if (buttonClickState.value)
                    PortfolioContent()
                else
                    Box() {

                    }
            }
        }
    }
}

@Composable
fun PortfolioContent() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Surface(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color(0xFFCCC8C8)),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 3.dp, color = Color.White)
        ) {
            Portfolio(
                data = listOf(
                    "Project 1",
                    "Project 2",
                    "Project 3",
                    "Project 4",
                    "Project 5",
                    "Project 6"
                )
            )

        }

    }
}

@Composable
private fun CreateProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(80.dp)
            .padding(3.dp),
        shape = CircleShape, border = BorderStroke(0.2.dp, Color.White),
        elevation = 2.dp,
        //color = MaterialTheme.colorScheme.surfaceColorAtElevation(0.5.dp).copy(0.5f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.person),
            contentDescription = stringResource(id = R.string.profile_image),
            modifier = modifier.size(135.dp), contentScale = ContentScale.Crop
        )


    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Portfolio(data: List<String>) {
    //reccyelerView
    LazyColumn(
        modifier = Modifier
            .padding(2.dp)
            .background(Color.White)
    ) {
        items(data) { item: String ->
            Card(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                elevation = 3.dp,
                shape = RoundedCornerShape(15.dp),
                backgroundColor = Color.White, onClick = {

                }
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(Color.Transparent)
                        .padding(16.dp)
                ) {
                    CreateProfile(modifier = Modifier.size(60.dp))
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(text = item, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                        Text(
                            text = "Hello Project",
                            fontWeight = FontWeight.Medium,
                            fontSize = 15.sp
                        )
                    }
                }

            }
        }
    }

}