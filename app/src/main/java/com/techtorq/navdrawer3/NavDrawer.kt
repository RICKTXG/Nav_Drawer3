package com.techtorq.navdrawer3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavDrawer(modifier: Modifier = Modifier) {
    //Base Navigation

    val navController = rememberNavController()
    val scope = rememberCoroutineScope()

    // Now start Navigation drawer

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(drawerContent = {
        ModalDrawerSheet {
            Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                Text("Drawer Title", modifier = Modifier.padding(vertical = 12.dp))
                HorizontalDivider()
                NavigationDrawerItem(label = {
                    Text(text = "profile")
                }, selected = false, onClick = {})

                NavigationDrawerItem(label = {
                    Text(text = "Home")
                }, selected = false, onClick = {})

                NavigationDrawerItem(label = {
                    Text(text = "Menu")
                }, selected = false, onClick = {})
            }
        }
    }, drawerState = drawerState) {
        NavHost(navController, startDestination = Routes.Home ) {
            composable(Routes.Home){
                Screen1()
            }
            composable(Routes.Menu){
                Screen2()
            }
        }
    }

    
}