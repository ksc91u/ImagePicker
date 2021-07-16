package com.github.drjacky.imagepicker.util

import android.content.Context
import android.net.Uri
import android.provider.MediaStore

fun Uri.resolveMime(context: Context): String? {
    val projection = arrayOf(MediaStore.MediaColumns.MIME_TYPE)
    val cursor = context.contentResolver
        .query(this, projection, null, null, null) ?: return null
    val columnIndex = cursor.getColumnIndex(android.provider.MediaStore.MediaColumns.MIME_TYPE)
    var s: String? = null
    if (columnIndex >= 0) {
        cursor.moveToFirst()
        s = cursor.getString(columnIndex)
    }
    cursor.close()
    return s
}
