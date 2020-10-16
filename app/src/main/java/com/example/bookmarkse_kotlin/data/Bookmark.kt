package com.example.bookmarkse_kotlin.data

import androidx.annotation.NonNull
import androidx.room.*
import java.util.*

@Entity(tableName = "bookmarks")
data class Bookmark @JvmOverloads constructor(
    @NonNull @ColumnInfo(name = "title") var title: String = "",
    @NonNull @ColumnInfo(name = "url") var url: String = "",
    @Embedded val category: Category,
    @Relation(parentColumn = "id", entityColumn = "categoryId") val categoryId: String,
    @ColumnInfo(name = "selectedAt") var selectedAt: Date?,
    @PrimaryKey @ColumnInfo(name = "id") var id: String = UUID.randomUUID().toString()
) {

    @ColumnInfo(name = "position")
    var position: Int = 0

    @ColumnInfo(name = "favicon")
    var favicon: String = ""

    val isEmpty
        get() = title.isEmpty()
}
