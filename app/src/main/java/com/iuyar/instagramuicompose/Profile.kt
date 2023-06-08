package com.iuyar.instagramuicompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Profile() {
    Column(modifier = Modifier.fillMaxSize()) {
        Header(name = "ibrhm_uyar")
        Spacer(modifier = Modifier.height(5.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(5.dp))
        Description(
            "İbrahim Uyar", "Software Developer", "uyaribrahim.com",
            listOf("daftpunk", "androidev"), 13
        )
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
            .padding(top = 18.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
            modifier = Modifier.size(24.dp),
            tint = Color.Black
        )
        Text(
            text = name, overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_notifications),
            contentDescription = "Back",
            modifier = Modifier.size(24.dp),
            tint = Color.Black
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dots),
            contentDescription = "Back",
            modifier = Modifier.size(20.dp),
            tint = Color.Black
        )
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
            ProfileImage(
                image = painterResource(id = R.drawable.ibrahim),
                modifier = Modifier
                    .size(88.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(14.dp))
            StatContainer(modifier = Modifier.weight(7f))
        }
    }
}

@Composable
fun ProfileImage(
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