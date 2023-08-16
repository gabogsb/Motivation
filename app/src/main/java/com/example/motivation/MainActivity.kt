package com.example.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    //Esconde a barra de navegacao
    supportActionBar?.hide()

  binding.newPhrase.setOnClickListener(this)

  }

  override fun onClick(view: View) {
    if (view.id == R.id.new_phrase) {
      var s = "asda"
    }
  }
}