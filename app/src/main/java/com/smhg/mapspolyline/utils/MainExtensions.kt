package com.smhg.mapspolyline.utils

import android.content.Context
import android.content.Intent
import android.widget.Toast

fun Context.intentTo(clazz: Class<*>) {
    startActivity(
        Intent(this, clazz)
    )
}

fun Context.toast(msg: String?) = Toast.makeText(this, msg,Toast.LENGTH_SHORT).show()