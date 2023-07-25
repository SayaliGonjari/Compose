package com.plcoding.navigationdrawercompose.test


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.plcoding.navigationdrawercompose.viewmodel.UserViewModel

@Composable
fun HomeScreen(userViewModel: UserViewModel) {

    LaunchedEffect(Unit, block = {
        userViewModel.userDetailsList()
    })

    Scaffold(
        topBar = {
        },
        content = {
            if (userViewModel.errorMessage.isEmpty()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    LazyColumn(modifier = Modifier.fillMaxHeight()) {
                        items(userViewModel.userList){
                            userlist->
                            Column {
                                Row(modifier = Modifier.fillMaxWidth().padding(16.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(0.dp, 0.dp, 16.dp, 0.dp)
                                    ) {
                                        Text(
                                            userlist.title,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


    )


    /*
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.white))
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "Home View",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontSize = 25.sp
            )
        }*/
}