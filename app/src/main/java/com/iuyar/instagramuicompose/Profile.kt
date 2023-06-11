package com.iuyar.instagramuicompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Profile() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Header(name = "ibrhm_uyar")
        Spacer(modifier = Modifier.height(5.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(20.dp))
        ButtonSection(
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        HighlightSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            highlights = listOf(
                StoryHighlight(
                    image = painterResource(id = R.drawable.jetpack_compose),
                    text = "GitHub"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.jetpack_compose),
                    text = "Compose"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.jetpack_compose),
                    text = "LinkedIn"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.jetpack_compose),
                    text = "Kotlin"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.jetpack_compose),
                    text = "Android"
                )
            )
        )
        Spacer(modifier = Modifier.height(15.dp))
        TabView(
            tabs = listOf(
                ProfileTabs(
                    image = painterResource(id = R.drawable.ic_grid),
                    text = "Posts"
                ),
                ProfileTabs(
                    image = painterResource(id = R.drawable.ic_reels),
                    text = "Reels"
                ),
                ProfileTabs(
                    image = painterResource(id = R.drawable.profile),
                    text = "Profile"
                ),
            )
        ) {
            selectedTabIndex = it
        }

    }
}

@Composable
fun Header(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 18.dp).padding(horizontal = 20.dp)
    ) {
        /*Icon(
            imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
            modifier = Modifier.size(24.dp),
            tint = Color.Black
        )*/
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(8f)) {
            Text(
                text = name, overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "",
                tint = Color.Black
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .weight(2f)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.outline_add),
                contentDescription = "Back",
                modifier = Modifier.size(24.dp),
                tint = Color.Black
            )
            Icon(
                painter = painterResource(id = R.drawable.outline_menu),
                contentDescription = "Back",
                modifier = Modifier.size(24.dp),
                tint = Color.Black
            )
        }

    }
}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.ibrahim),
                modifier = Modifier
                    .size(88.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(14.dp))
            StatContainer(modifier = Modifier.weight(7f))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Description(
            "İbrahim Uyar", "Software Developer", "uyaribrahim.com",
            listOf("daftpunk", "androidev"), 13
        )
    }
}

@Composable
fun RoundImage(
    image: Painter, modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(1.dp, color = Color.LightGray, CircleShape)
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StatContainer(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(valueText = "98", text = "Posts")
        ProfileStat(valueText = "1.324", text = "Followers")
        ProfileStat(valueText = "142", text = "Following")
    }
}

@Composable
fun ProfileStat(
    valueText: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = valueText, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(3.dp))
        Text(text = text)
    }
}

@Composable
fun Description(
    name: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpace = 0.5.sp
    val lineHeight = 20.sp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 22.dp)
    ) {
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpace,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            letterSpacing = letterSpace,
            lineHeight = lineHeight
        )
        Text(
            text = url,
            color = Color(0xFF3D3D91),
            letterSpacing = letterSpace,
            lineHeight = lineHeight
        )
        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (otherCount > 2) {
                        append(" and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                }, letterSpacing = letterSpace,
                lineHeight = lineHeight
            )

        }
    }
}

@Composable
fun ButtonSection(modifier: Modifier = Modifier) {
    val minWidth = 95.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier,
    ) {
        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .size(height)
        )

    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)

    ) {
        if (text != null) {
            Text(text = text, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        }
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }

    }

}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<StoryHighlight>
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        items(highlights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(end = 18.dp)
            ) {
                RoundImage(
                    image = highlights[it].image,
                    modifier = Modifier.size(70.dp)
                )
                Text(
                    text = highlights[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )

            }
        }
    }
}

@Composable
fun TabView(
    modifier: Modifier = Modifier,
    tabs: List<ProfileTabs>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val defaultColor = Color(0xFF7777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier

    ) {
        tabs.forEachIndexed { index, profileTabs ->
            Tab(selected = selectedTabIndex == index,
                selectedContentColor = contentColorFor(Color.Black),
                unselectedContentColor = defaultColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }) {
                Icon(
                    painter = profileTabs.image,
                    contentDescription = profileTabs.text,
                    tint = if (selectedTabIndex == index) Color.Black else defaultColor,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(20.dp)
                )
            }
        }

    }
}