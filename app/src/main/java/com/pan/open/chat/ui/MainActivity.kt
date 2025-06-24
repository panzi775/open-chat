package com.pan.open.chat.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pan.open.chat.ui.page.ProfilePage
import com.pan.open.chat.ui.page.ChatPage
import com.pan.open.chat.ui.page.DynamicPage
import com.pan.open.chat.ui.theme.OpenChatTheme

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
            composable(MainTab.Chat.route) { KeepAlive { ChatPage() } }
            composable(MainTab.Dynamic.route) { KeepAlive { DynamicPage() } }
            composable(MainTab.Profile.route) { KeepAlive { ProfilePage() } }
        }
    }
}

@Composable
fun KeepAlive(content: @Composable () -> Unit) {
    // 只创建一次，避免重组时内容重建
    val composableContent = remember { content }
    composableContent()
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
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
