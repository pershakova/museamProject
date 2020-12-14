package com.kotlin.museamproject.mvp.model.entity.room.dao

import androidx.room.*
import com.kotlin.museamproject.mvp.model.entity.room.RoomPictureObject

@Dao
interface PictureObjectDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: RoomPictureObject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: RoomPictureObject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: List<RoomPictureObject>)

    @Update
    fun update(user: RoomPictureObject)

    @Update
    fun update(vararg users: RoomPictureObject)

    @Update
    fun update(users: List<RoomPictureObject>)

    @Delete
    fun delete(user: RoomPictureObject)

    @Delete
    fun delete(vararg users: RoomPictureObject)

    @Delete
    fun delete(users: List<RoomPictureObject>)

    @Query("SELECT * FROM RoomPictureObject")
    fun getAll(): List<RoomPictureObject>

    @Query("SELECT * FROM RoomPictureObject WHERE id = :id LIMIT 1")
    fun findById(id: Int): RoomPictureObject?
}