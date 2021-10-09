package com.trivm.extendview.webview.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder

class GsonParser {
    companion object  {
        private var gson: Gson? = null
        fun getParser(): Gson? {
            if (null == gson) {
                val builder = GsonBuilder()
                gson = builder.create()
            }
            return gson
        }
    }
}

object BundleKeyWebView {
    const val URL = "WebViewUrl"
}