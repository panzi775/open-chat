package com.openchat.pan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.openchat.pan.ui.theme.OpenChatTheme

sealed class MainTab(val route: String, val label: String, val icon: ImageVector) {
    data object Chat : MainTab("chat", "聊天", Icons.AutoMirrored.Filled.Chat)
    data object Dynamic : MainTab("dynamic", "动态", Icons.Filled.Home)
    data object Profile : MainTab("profile", "我的", Icons.Filled.Person)
}

val mainTabs = listOf(MainTab.Chat, MainTab.Dynamic, MainTab.Profile)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OpenChatTheme {
                MainScreen()
            }
        }
    }
}

@Preview
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MainTab.Chat.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(MainTab.Chat.route) { ChatPage() }
            composable(MainTab.Dynamic.route) { DynamicPage() }
            composable(MainTab.Profile.route) { ProfilePage() }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    NavigationBar {
        mainTabs.forEach { tab ->
            NavigationBarItem(
                icon = { Icon(tab.icon, contentDescription = tab.label) },
                label = { Text(tab.label) },
                selected = currentRoute == tab.route,
                onClick = {
                    navController.navigate(tab.route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun ChatPage() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Text("聊天页面", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun DynamicPage() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Text("动态页面", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun ProfilePage() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Text("我的页面", style = MaterialTheme.typography.headlineMedium)
    }
} 