package com.jeetu.memeshare

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide


class MainActivity: AppCompatActivity() {
    private val memeImageView: ImageView = TODO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadmeme()
    }

    private fun loadmeme() {

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"

        // Request a string response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
              val url = response.getString( "url")
                Glide.with(this).load(url).into(memeImageView)
            },
            { error ->
                // TODO: Handle error
            }
        )

// Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)
    }

    fun nextmeme() {
      loadmeme()
    }
    fun sharememe(view: View) {

    }
}