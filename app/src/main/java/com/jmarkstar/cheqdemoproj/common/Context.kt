package com.jmarkstar.cheqdemoproj.common

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

fun Context.getDrawableByName(drawableName: String) : Drawable? {
    return ContextCompat.getDrawable(this, resources.getIdentifier(drawableName, "drawable", packageName))
}