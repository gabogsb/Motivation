package com.example.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motivation.infraStructure.MotivationConstants
import com.example.motivation.R
import com.example.motivation.infraStructure.SecurityPreferences
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

  private lateinit var binding: ActivityUserBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityUserBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.btnSave.setOnClickListener(this)

    supportActionBar?.hide()

    verifyUserName()
  }

  override fun onClick(v: View) {
    if (v.id == R.id.btn_save) {
      handleSave()
    }
  }

  private fun verifyUserName(){
    val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
    if (name != ""){
      startActivity(Intent(this, MainActivity::class.java))
      finish()
    }
  }

  private fun handleSave() {
    val name = binding.editName.text.toString()
    if (name != "") {
      SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, name)
      startActivity(Intent(this, MainActivity::class.java))
      finish()
    } else {
      Toast.makeText(this, "Nome invalid", Toast.LENGTH_SHORT).show()
    }
  }



}