package com.elfrikiamv.random_image

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imagePhoto: ImageView = findViewById(R.id.ivRandom)
        val tvUrlImage: TextView = findViewById(R.id.tvUrlImage)
        val cardView: CardView = findViewById(R.id.cardView)
        //val model: MainActivityViewModel = MainActivityViewModel()

        val model = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        val urlImage: MutableLiveData<String?>? = model.getUrlImage()
        //Picasso.get().load(model.getUrlImage()).into(imagePhoto)

        urlImage?.observe(this, Observer { url ->
            Picasso.get().load(url).into(imagePhoto)
            tvUrlImage.text = url
        })

        cardView.setOnClickListener(View.OnClickListener {
            model.randomUrlImage()
            Toast.makeText(this, "Image Changed!", Toast.LENGTH_SHORT).show()
        })
    }
}