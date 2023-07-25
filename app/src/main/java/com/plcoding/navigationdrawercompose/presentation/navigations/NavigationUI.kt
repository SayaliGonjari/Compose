package com.plcoding.navigationdrawercompose.test

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.plcoding.navigationdrawercompose.DrawerHeader
import com.plcoding.navigationdrawercompose.R
import com.plcoding.navigationdrawercompose.presentation.login.LoginScreen
import com.plcoding.navigationdrawercompose.presentation.navigations.DrawerScreens
import com.plcoding.navigationdrawercompose.viewmodel.UserViewModel
import com.plcoding.navigationdrawercompose.presentation.profile.ProfileScreen
import com.plcoding.navigationdrawercompose.presentation.settings.SettingScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Navigation(navController: NavHostController) {
    val userViewModel = UserViewModel()
    NavHost(navController = navController, startDestination = DrawerScreens.Login.id) {
        composable(DrawerScreens.Home.id) {
            HomeScreen(userViewModel)
        }
        composable(DrawerScreens.Settings.id) {
            SettingScreen()
        }
        composable(DrawerScreens.Profile.id) {
            ProfileScreen()
        }
    }


}

@Composable
fun TopBar(scope: CoroutineScope, scaffoldState: ScaffoldState) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name), fontSize = 18.sp)
        }, navigationIcon = {

            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon(Icons.Filled.Menu, "")
            }
        },
        backgroundColor = colorResource(id = R.color.teal_700),
        contentColor = Color.White
    )

}

@Composable
fun Drawer(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavController) {
    val items = listOf(
        DrawerScreens.Home,
        DrawerScreens.Profile,
        DrawerScreens.Settings
    )
    Column(modifier = Modifier.background(Color.White)) {
        DrawerHeader()

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { items ->

            DrawerItem(item = items, selected = currentRoute == items.id, onItemClick = {
                navController.navigate(items.id) {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    // Avoid multiple copies of the same destination when
                    // reselecting the same item
                    launchSingleTop = true
                    // Restore state when reselecting a previously selected item
                    restoreState = true
                }
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            })
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Developed by John Codeos",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterHorizontally)
        )


    }
}

@Composable
fun DrawerItem(item: DrawerScreens, selected: Boolean, onItemClick: (DrawerScreens) -> Unit) {
    val background = if (selected) R.color.purple_500 else android.R.color.transparent
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onItemClick(item) })
            .height(45.dp)
            .background(color = Color.White)
            .padding(start = 10.dp)
    ) {

        /* Image(
             imageVector = item.icon, contentDescription = item.title,
             colorFilter = ColorFilter.tint(Color.White),
             contentScale = ContentScale.Fit,
             modifier = Modifier
                 .height(35.dp)
                 .width(35.dp)
         )*/
        Image(
            painter = painterResource(id = item.icon),
            contentDescription = stringResource(id = R.string.profile_image),
            modifier = Modifier.size(50.dp), contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            text = item.title,
            fontSize = 18.sp,
            color = Color.Black
        )
    }
}

@Preview(showBackground = false)
@Composable
fun DrawerItemPreview() {
    DrawerItem(item = DrawerScreens.Home, selected = true, onItemClick = {})
}

@Preview
@Composable
fun DrawerPreview() {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val navController = rememberNavController()
    Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
}

@Preview
@Composable
fun TopBarPreview() {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    TopBar(scope = scope, scaffoldState = scaffoldState)
}
