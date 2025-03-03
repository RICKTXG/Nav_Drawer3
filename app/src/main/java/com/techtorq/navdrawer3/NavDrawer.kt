package com.techtorq.navdrawer3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
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
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavDrawer(modifier: Modifier = Modifier) {
    //Base Navigation

    val navController = rememberNavController()
    val scope = rememberCoroutineScope()

    // Now start Navigation drawer

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(drawerContent = {
        ModalDrawerSheet {
            Column(modifier = Modifier
                .padding(horizontal = 12.dp)
                .verticalScroll(
                rememberScrollState() // verticalScroll(rememberScrollState() ) for scroll the elements of navigation
            )   .fillMaxWidth(0.9f)
            ) {

                Text("Drawer Title", modifier = Modifier.padding(vertical = 12.dp))

                HorizontalDivider()

                Text("Section 1", modifier = Modifier.padding(vertical = 12.dp))

                NavigationDrawerItem(label = {
                    Text(text = "profile")
                }, selected = false, onClick = {})

                NavigationDrawerItem(label = {
                    Text(text = "Home")
                }, selected = false, onClick = {})

                NavigationDrawerItem(label = {
                    Text(text = "Menu")
                }, selected = false, onClick = {})


                HorizontalDivider()

                NavigationDrawerItem(label = {
                    Text(text = "New")
                }, selected = false, onClick = {}, badge = {Text("20")},
                    icon = { Icon(imageVector = Icons.Rounded.Info, contentDescription = " ") })

                NavigationDrawerItem(label = {
                    Text(text = "Build")
                }, selected = false, onClick = {}, // No Badge
                    icon = { Icon(imageVector = Icons.Rounded.Build, contentDescription = " ") })


            }
        }
    }, drawerState = drawerState) {
        Scaffold(
            topBar = {
            TopAppBar(title = {}, navigationIcon = {
                IconButton(onClick = {
                    scope.launch{
                        drawerState.open()
                    }


                }) {
                    Icon(imageVector = Icons.Rounded.Menu, contentDescription = "")
                }

            })
        },
            bottomBar = {}, floatingActionButton = {
                FloatingActionButton(onClick = {

                }) {
                    Icon(imageVector = Icons.Rounded.Add, contentDescription = " ")
                }
            }

        )
        {
            NavHost(navController, startDestination = Routes.Home, Modifier.padding(it) ){
            composable(Routes.Home){
                Screen1()
            }
            composable(Routes.Menu){
                Screen2()
            }
        }
        }
    }

    
}