package com.trivm.extendview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trivm.extendview.webview.view.WebViewFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}