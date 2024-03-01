package com.admin.effective_lab

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderBackground(
    picture: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = picture),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .size(310.dp)
                .drawWithContent {
                    val gradient = Brush.verticalGradient(
                        colors = listOf(Color.Black, Color.Transparent),
                        startY = 0f,
                        endY = (size.height / 3).coerceAtMost(126.dp.toPx())// Вниз
                    )
                    drawContent()
                    drawRect(brush = gradient, blendMode = BlendMode.Multiply, alpha = 0.92f)
                }

        )
    }
}


@Composable
fun GameLogo(
    gameLogo: Int,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.padding(horizontal = 20.dp)) {
        val sizeGameIcon = 54.dp
        Box(
            modifier = Modifier
                .size(sizeGameIcon + 17.dp * 2, sizeGameIcon + 17.dp * 2)
                .background(Color.Black, shape = RoundedCornerShape(13.dp))
                .border(2.dp, Color.Gray, RoundedCornerShape(13.dp))
                .align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(id = gameLogo),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(sizeGameIcon)
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
fun GameInfo(
    gameName: String,
    ratingsCount: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {

        Text(
            text = gameName,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            letterSpacing = 0.5.sp
        )
        Spacer(modifier = Modifier.height(7.dp))
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            RatingStars(starCount = 5)
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = ratingsCount.toString() + "M",
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                letterSpacing = 0.5.sp
            )
        }


    }
}

@Composable
fun RatingStars(starCount: Int) {
    repeat(starCount) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Rating Star",
            tint = Color.Yellow,
            modifier = Modifier.size(12.dp)
        )
    }
}