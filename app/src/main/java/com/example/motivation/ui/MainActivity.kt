package com.example.motivation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.motivation.infraStructure.MotivationConstants
import com.example.motivation.R
import com.example.motivation.data.Mock
import com.example.motivation.infraStructure.SecurityPreferences
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

  private lateinit var binding: ActivityMainBinding
  private var categoryId = MotivationConstants.FILTER.ALL

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    //Esconde a barra de navegacao
    supportActionBar?.hide()

    handleUserName()
    handleFilter(R.id.image_all)
    handleNextPhrase()

    //Eventos
    binding.newPhrase.setOnClickListener(this)
    binding.imageAll.setOnClickListener(this)
    binding.imageHappy.setOnClickListener(this)
    binding.imageSunny.setOnClickListener(this)
  }

  override fun onClick(view: View) {
    if (view.id == R.id.new_phrase) {
      handleNextPhrase()
    }else if (view.id in listOf(R.id.image_all, R.id.image_happy, R.id.image_sunny)){
      handleFilter(view.id)
    }
  }

  private fun handleNextPhrase(){
    val phrase = Mock().getPhrase(categoryId)
    binding.textPhrase.text = phrase
  }
  private fun handleUserName() {
    val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
    binding.textUserName.text = "Olá, $name!"
  }

  private fun handleFilter(id: Int){
    binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
    binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
    binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

    when (id) {
      R.id.image_all -> {
        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
        categoryId = MotivationConstants.FILTER.ALL
      }
      R.id.image_happy -> {
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
        categoryId = MotivationConstants.FILTER.HAPPY
      }
      R.id.image_sunny -> {
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
        categoryId = MotivationConstants.FILTER.SUNNY
      }
    }
  }
}