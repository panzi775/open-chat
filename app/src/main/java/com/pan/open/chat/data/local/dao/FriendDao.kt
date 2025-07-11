package com.pan.open.chat.data.local.dao

import androidx.room.*
import com.pan.open.chat.data.local.entity.FriendEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FriendDao {
    @Query("SELECT * FROM friends WHERE userId = :userId")
    fun getFriendsForUser(userId: String): Flow<List<FriendEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFriend(friend: FriendEntity)

    @Delete
    suspend fun deleteFriend(friend: FriendEntity)
} 