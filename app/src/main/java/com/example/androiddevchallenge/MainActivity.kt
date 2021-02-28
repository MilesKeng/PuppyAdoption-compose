/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.DataProvider
import com.example.androiddevchallenge.data.model.Puppy
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Home") {
        val list = DataProvider().listPuppy
        composable("Home") {
            HomePage(
                list,
                goDetail = {
                    navController.navigate("DetailPage" + "/${it.id}")
                }
            )
        }
        composable("DetailPage" + "/{id}") { backStackEntry ->
            val puppyId = backStackEntry.arguments?.get("id")
            val puppy = list.find { it.id == puppyId }

            DetailPage(puppy = puppy!!, goBack = { navController.popBackStack() })
        }
    }
}

@Composable
fun HomePage(listPuppy: List<Puppy>, goDetail: (Puppy) -> Unit) {
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        topBar = {
            TopAppBar(
                title = {
                    Text("Puppy adoption")
                },
            )
        },
        content = {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
            ) {
                // Add 5 items
                items(listPuppy.size) { index ->
                    PuppyItem(listPuppy[index], goDetail)
                }
            }
        }
    )
}

@Composable
fun PuppyItem(puppy: Puppy, goDetail: (Puppy) -> Unit) {
    Card(
        backgroundColor = Color.LightGray,
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                goDetail.invoke(puppy)
            }
    ) {
        Row {
            Image(
                painter = painterResource(puppy.picture),
                contentDescription = null,
                modifier = Modifier
                    .height(120.dp)
                    .width(140.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                val typography = MaterialTheme.typography
                Text(
                    puppy.name,
                    style = typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    "Age : ${puppy.age}",
                    style = typography.body2
                )
                Text(
                    "Description : ${puppy.description}",
                    style = typography.body2
                )
            }
        }
    }
}

@Composable
fun DetailPage(puppy: Puppy, goBack: () -> Unit) {
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        puppy.name
                    )
                },
                navigationIcon = {
                    IconButton(onClick = goBack) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(PaddingValues(horizontal = 8.dp, vertical = 8.dp))
            ) {
                Image(
                    painter = painterResource(puppy.picture),
                    contentDescription = null,
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .background(Color.LightGray)
                        .clip(shape = RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )

                val typography = MaterialTheme.typography
                Text(
                    puppy.name,
                    style = typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    "Age : ${puppy.age}",
                    style = typography.body2
                )
                Text(
                    "Description : ${puppy.description}",
                    style = typography.body2
                )
            }
        }
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
