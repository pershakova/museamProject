package com.kotlin.museamproject.mvp.model.entity.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

@Entity
class RoomPictureObject(
    @PrimaryKey var id: Int,
    var title: String,
    var primaryImage: String,
    var primaryImageSmall: String,
    var artistDisplayName: String,
)