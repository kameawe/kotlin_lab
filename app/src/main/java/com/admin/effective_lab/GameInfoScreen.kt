package com.admin.effective_lab

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun GameInfoScreen() {
    Column(Modifier.fillMaxSize()) {
        HeaderBackground(picture = R.drawable.dota_background)
        GameSection()
    }

}

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
fun GameSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GameLogo(
            gameLogo = R.drawable.dota_logo, modifier = Modifier
                .offset(y = (-17).dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        GameInfo(gameName = "Dota 2", ratingsCount = 70, starCount = 5)
    }
    CategorySection(
        modifier = Modifier
            .padding(horizontal = 20.dp)
    )
    Spacer(modifier = Modifier.height(30.dp))
    GameDescription(text = "Dota 2 is a multiplayer online battle arena (MOBA) game which has two teams of five players compete to collectively destroy a large structure defended by the opposing team known as the \"Ancient\", whilst defending their own.")

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
                .size(sizeGameIcon + 17.dp * 2)
                .background(Color.Black, shape = RoundedCornerShape(13.dp))
                .border(2.dp, Color.Gray, RoundedCornerShape(13.dp))
        ) {
            Image(
                painter = painterResource(id = gameLogo),
                contentDescription = "Game Logo",
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
    starCount: Int,
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
            RatingStars(starCount)
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


@Composable
fun CategorySection(
    modifier: Modifier = Modifier
) {
    val height = 22.dp
    val minWidth = 95.dp
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
    ) {
        CategoryButton(
            text = "MOBA", modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        CategoryButton(
            text = "MULTIPLAYER", modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        CategoryButton(
            text = "STRATEGY", modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
    }
}

@Composable
fun CategoryButton(
    modifier: Modifier = Modifier,
    text: String? = null,

    ) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(
                color = Color(68, 169, 244, 24),
                shape = RoundedCornerShape(100.dp)
            )
            .padding(1.dp)
    ) {
        if (text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.Normal,
                fontSize = 10.sp,
                color = Color(android.graphics.Color.parseColor("#41A0E7"))
            )
        }
    }

}

@Composable
fun BackgroundRoundedShape(
    hexColor: String,
    modifier: Modifier = Modifier
) {
    val color = Color(android.graphics.Color.parseColor(hexColor))
    Box(
        modifier = modifier
            .background(
                color = color,
                shape = RoundedCornerShape(
                    topStart = 21.dp,
                    topEnd = 21.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                )
            )
    )
}

@Composable
fun GameDescription(
    text: String? = null,
) {
    Box(modifier = Modifier.padding(horizontal = 20.dp)) {
        if (text != null) {
            Text(
                text = text,
                lineHeight = 19.sp,
                fontSize = 12.sp,
                fontStyle = FontStyle.Normal,
                color = Color.Black,
            )
        }
    }
}