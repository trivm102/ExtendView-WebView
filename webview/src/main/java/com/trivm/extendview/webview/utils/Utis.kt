package com.trivm.extendview.webview.utils

import android.os.Bundle
import androidx.core.os.bundleOf
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.trivm.extendview.webview.model.WebViewModel

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

class WebViewUtilities {
    companion object {
        fun toObjBundle(url: String): Bundle {
            val model = WebViewModel().apply {
                this.url = url
            }
            val modelSting = GsonParser.getParser()?.toJson(model)
            return bundleOf(BundleKeyWebView.URL to modelSting)
        }
    }
}