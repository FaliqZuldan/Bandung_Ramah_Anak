package com.example.bandungramahanak

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity3 : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        // Initialize Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Show the back button

        val webView: WebView = findViewById(R.id.webView1)

        // HTML content with multiple iframes and spacing
        val videoContent = """
            <html>
            <body style="margin:0; padding:0;">
            <div style="display: flex; flex-direction: column; align-items: center;">
                <iframe width="90%" height="450" style="margin-bottom: 25px;" src="https://www.youtube.com/embed/aCn8ERT7hLs?si=FYbuZqenmsjGswMX" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                <iframe width="90%" height="450" style="margin-bottom: 25px;" src="https://www.youtube.com/embed/dVA4wvqcyBU?si=FYbuZqenmsjGswMX" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                <iframe width="90%" height="450" style="margin-bottom: 25px;" src="https://www.youtube.com/embed/EfIE3qx5Jww?si=MLbRUXwiwQKkWl85" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
                <iframe width="90%" height="450" style="margin-bottom: 25px;" src="https://www.youtube.com/embed/Ck261jZrHpA?si=j63fnQ40aElSkrUN" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
            </div>
            </body>
            </html>
        """

        // Configure WebView settings
        webView.settings.javaScriptEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.settings.domStorageEnabled = true
        webView.webViewClient = WebViewClient() // Handle navigation within WebView
        webView.webChromeClient = WebChromeClient() // Handle JavaScript dialogs, favicons, titles, and the progress

        // Load video content
        webView.loadData(videoContent, "text/html", "utf-8")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed() // Handle the back button press
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
