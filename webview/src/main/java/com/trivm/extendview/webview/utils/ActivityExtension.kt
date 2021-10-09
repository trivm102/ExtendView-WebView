package com.trivm.extendview.webview.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity

fun Activity.hideKeyboard() {
    val view = if (currentFocus != null) currentFocus else View(this)
    val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view?.windowToken, 0)
}

fun AppCompatActivity.setTitleActivity(string: String?) {
    string?.let {
        this.supportActionBar?.title = string
    }
}

fun AppCompatActivity.getTitleActivity(): String {
    return this.supportActionBar?.title.toString()
}