package com.pan.open.chat.ui

import android.os.Bundle
import android.os.Build
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
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
        // 沉浸式状态栏
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = android.graphics.Color.TRANSPARENT
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.setSystemBarsAppearance(
                0,
                WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
            )
        }
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
    var selectedTab by remember { mutableStateOf<MainTab>(MainTab.Chat) }
    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        bottomBar = {
            BottomNavigationBar(selectedTab) { selectedTab = it }
        }
    ) { innerPadding ->
        androidx.compose.animation.Crossfade(
            targetState = selectedTab,
            modifier = Modifier.padding(innerPadding)
        ) { tab ->
            when (tab) {
                MainTab.Chat -> ChatPage()
                MainTab.Dynamic -> DynamicPage()
                MainTab.Profile -> ProfilePage()
            }
        }
    }
}

@Composable
fun BottomNavigationBar(selectedTab: MainTab, onTabSelected: (MainTab) -> Unit) {
    NavigationBar {
        mainTabs.forEach { tab ->
            NavigationBarItem(
                icon = { Icon(tab.icon, contentDescription = tab.label) },
                label = { Text(tab.label) },
                selected = selectedTab == tab,
                onClick = { onTabSelected(tab) }
            )
        }
    }
}
