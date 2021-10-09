package com.trivm.extendview.webview.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.trivm.extendview.webview.R
import com.trivm.extendview.webview.databinding.FragmentWebViewBinding
import com.trivm.extendview.webview.model.WebViewModel
import com.trivm.extendview.webview.utils.*

class WebViewFragment : Fragment() {

    private lateinit var binding: FragmentWebViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity?.hideKeyboard()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_web_view, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewReady(view, savedInstanceState)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun onViewReady(view: View, savedInstanceState: Bundle?) {
        binding.webView.webChromeClient = object : WebChromeClient() {
            override fun onReceivedTitle(view: WebView?, title: String?) {
                super.onReceivedTitle(view, title)
                if ((activity as? AppCompatActivity)?.getTitleActivity().isNullOrEmpty()) {
                    (activity as? AppCompatActivity)?.setTitleActivity(title ?: "")
                }
            }
        }
        binding.webView.settings.javaScriptEnabled = true
        setupView(savedInstanceState)
    }

    private fun setupView(bundle: Bundle?) {
        val jsonString = bundle?.get(BundleKeyWebView.URL) as? String
        jsonString?.let { obj ->
            val webViewModel = GsonParser.getParser()?.fromJson(obj, WebViewModel::class.java)
            loadUrl(webViewModel?.url)
        }
    }

    private fun loadUrl(url: String?) {
        url?.let {
            binding.webView.loadUrl(it)
        }
    }
}