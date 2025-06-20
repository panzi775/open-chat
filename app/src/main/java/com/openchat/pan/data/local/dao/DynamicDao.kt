package com.openchat.pan.data.local.dao

import androidx.room.*
import com.openchat.pan.data.local.entity.DynamicEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DynamicDao {
    @Query("SELECT * FROM dynamics ORDER BY timestamp DESC")
    fun getAllDynamics(): Flow<List<DynamicEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDynamic(dynamic: DynamicEntity)

    @Delete
    suspend fun deleteDynamic(dynamic: DynamicEntity)
} 