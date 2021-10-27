package com.astute.socialnetworkdefense.feature_post.domain.repository

import android.net.Uri
import androidx.paging.PagingData
import com.astute.socialnetworkdefense.core.domain.models.Comment
import com.astute.socialnetworkdefense.core.domain.models.Post
import com.astute.socialnetworkdefense.core.domain.models.UserItem
import com.astute.socialnetworkdefense.core.util.Constants
import com.astute.socialnetworkdefense.core.util.Resource
import com.astute.socialnetworkdefense.core.util.SimpleResource
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    val posts: Flow<PagingData<Post>>

    suspend fun createPost(description: String, imageUri: Uri): SimpleResource

    suspend fun getPostDetails(postId: String): Resource<Post>

    suspend fun getCommentsForPost(postId: String): Resource<List<Comment>>

    suspend fun createComment(postId: String, comment: String): SimpleResource

    suspend fun likeParent(parentId: String, parentType: Int): SimpleResource

    suspend fun unlikeParent(parentId: String, parentType: Int): SimpleResource

    suspend fun getLikesForParent(parentId: String): Resource<List<UserItem>>

}