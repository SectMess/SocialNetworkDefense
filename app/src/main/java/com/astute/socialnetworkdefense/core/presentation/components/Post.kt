package com.astute.socialnetworkdefense.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Comment
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.astute.socialnetworkdefense.R
import com.astute.socialnetworkdefense.core.domain.models.Post
import com.astute.socialnetworkdefense.presentation.ui.theme.*
import com.astute.socialnetworkdefense.core.util.Constants

@Composable
fun Post(
    post: Post,
    modifier: Modifier = Modifier,
    showProfileImage: Boolean = true,
    onPostClick: () -> Unit = {}
) {

    Box(
        modifier = Modifier

    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = ProfilePictureSize / 2f)
                .clip(MaterialTheme.shapes.medium)
                .shadow(5.dp)
                .background(MediumGray)
                .clickable {
                    onPostClick()
                }
        ) {

            //Post Image
            Image(
                painterResource(id = R.drawable.explosion),
                contentDescription = "Post Image",
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(SpaceMedium)

            ) {
                //Action Row below Post Image
                ActionRow(
                    modifier = Modifier.fillMaxWidth(),
                    onLikeClick = { isLiked ->

                    },
                    onCommentClick = {

                    },
                    onShareClick = {

                    },
                    username = "Testing",
                    onUsernameClick = { username ->

                    }
                )

                //Post Description
                Text(
                    text = buildAnnotatedString {
                        append(post.description)
                        withStyle(SpanStyle(color = HintGray)){
                            append(
                                LocalContext.current.getString(R.string.read_more)
                            )
                        }
                    },
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = Constants.MAX_POST_DESCRIPTION_LINES,
                )

                Spacer(modifier = Modifier.height(SpaceSmall))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(id = R.string.liked_by_x_people, post.likeCount),
                        style = MaterialTheme.typography.h2,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        )
                    Text(
                        text = stringResource(id = R.string.x_comments, post.commentCount),
                        style = MaterialTheme.typography.h2,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        )
                }
            }
        }

        Image(
            painterResource(id = R.drawable.explosion),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(ProfilePictureSize)
                .clip(CircleShape)
                .align(Alignment.TopEnd)
        )
    }

}

@Composable
fun EngagementButton(
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
    iconSize: Dp = 30.dp,
    onLikeClick: (Boolean)-> Unit,
    onCommentClick: ()-> Unit,
    onShareClick: ()-> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ){
        IconButton(
            onClick = { onLikeClick(!isLiked) },
            modifier = Modifier.size(iconSize),
        ) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                tint = if(isLiked){
                    Color.Red
                } else {
                    Color.White
                },
                contentDescription = if(isLiked){
                    stringResource(R.string.unlike)
                } else {
                    stringResource(R.string.liked)
                }
            )
        }
        Spacer(modifier = Modifier.width(SpaceMedium))

        IconButton(
            onClick = { onCommentClick() },
            modifier = Modifier.size(iconSize),
        ) {
            Icon(
                imageVector = Icons.Filled.Comment,
                contentDescription = stringResource(R.string.comment)
            )
        }
        Spacer(modifier = Modifier.width(SpaceMedium))

        IconButton(
            onClick = { onShareClick() },
            modifier = Modifier.size(iconSize),
        ) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = stringResource(R.string.share)
            )
        }
    }

}

@Composable
fun ActionRow(
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
    onLikeClick: (Boolean)-> Unit,
    onCommentClick: ()-> Unit,
    onShareClick: ()-> Unit,
    username: String,
    onUsernameClick: (String)-> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            text = username,
            style = MaterialTheme.typography.h1,
            modifier = Modifier.clickable {
                onUsernameClick(username)
            }
        )

        EngagementButton(
            isLiked = isLiked,
            onLikeClick = onLikeClick,
            onCommentClick = onCommentClick,
            onShareClick = onShareClick,
        )
    }
}

