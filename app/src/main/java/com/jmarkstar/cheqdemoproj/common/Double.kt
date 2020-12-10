package com.jmarkstar.cheqdemoproj.common

import java.text.NumberFormat
import java.util.*

fun Double.formatted(): String = NumberFormat.getNumberInstance(Locale.US).format(this) ?: ""