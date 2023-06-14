package com.iuyar.instagramuicompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iuyar.instagramuicompose.R
import com.iuyar.instagramuicompose.components.RoundImage
import com.iuyar.instagramuicompose.model.Story


// control + shift + C block comment
// control + c line comment
@Preview(showBackground = true)
@Composable
fun Home() {
    Column(modifier = Modifier.fillMaxSize()) {
        HomeHeader(
            modifier = Modifier
                .height(60.dp)
                .padding(horizontal = 12.dp)
        )
        StoryContainer(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        )
        Divider(modifier = Modifier.padding(top = 6.dp))
    }
}

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            tint = Color.Black,
            modifier = Modifier.weight(3f)
        )
        Spacer(
            modifier = Modifier
                .weight(4f)
                .fillMaxHeight()
        )
        Icon(
            painter = painterResource(id = R.drawable.heart),
            contentDescription = "",
            modifier = Modifier
                .size(24.dp)
                .weight(1f)
                .padding(end = 10.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.dm),
            contentDescription = "",
            modifier = Modifier
                .size(24.dp)
                .weight(1f)
        )
    }
}

@Composable
fun StoryContainer(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box() {
                RoundImage(
                    image = painterResource(id = R.drawable.ibrahim),
                    modifier = Modifier.size(82.dp)
                )
                Icon(
                    imageVector = Icons.Filled.AddCircle,
                    contentDescription = "Add",
                    tint = Color(0, 149, 246),
                    modifier = Modifier
                        .align(
                            Alignment.BottomEnd
                        )
                        .clip(CircleShape)
                        .size(22.dp)
                        .background(Color.White)
                        .border(1.dp, color = Color.White, CircleShape),
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = "Your story", fontSize = 12.sp)
        }

        StorySection(
            stories = listOf(
                Story(
                    image = painterResource(id = R.drawable.jetpack_compose),
                    isOpened = false,
                    userName = "user_1"
                ),
                Story(
                    image = painterResource(id = R.drawable.jetpack_compose),
                    isOpened = false,
                    userName = "user_2"
                ),
                Story(
                    image = painterResource(id = R.drawable.jetpack_compose),
                    isOpened = false,
                    userName = "user_3"
                ),
                Story(
                    image = painterResource(id = R.drawable.jetpack_compose),
                    isOpened = false,
                    userName = "user_4"
                ),
                Story(
                    image = painterResource(id = R.drawable.jetpack_compose),
                    isOpened = false,
                    userName = "user_5"
                ),
                Story(
                    image = painterResource(id = R.drawable.jetpack_compose),
                    isOpened = false,
                    userName = "user_6"
                ),
            )
        )

    }
}

@Composable
fun StorySection(
    modifier: Modifier = Modifier,
    stories: List<Story>
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        items(stories.size) {
            Spacer(modifier = Modifier.width(10.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                RoundImage(
                    image = stories[it].image,
                    modifier = Modifier.size(82.dp)
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = stories[it].userName, fontSize = 12.sp)
            }
        }
    }
}