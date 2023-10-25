package com.example.trysharepref.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trysharepref.R
import com.example.trysharepref.databinding.ActivityMenuBinding
import com.example.trysharepref.utils.CustomSharePrefs

class MenuActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMenuBinding
    private lateinit var prefs:CustomSharePrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        checkLogin()
        logoutClick()
    }

    fun init() {
        prefs = CustomSharePrefs(this@MenuActivity)
    }

    fun checkLogin() {
        if (prefs.getLogin().equals(0)) {
            val intent =   Intent(this@MenuActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun logoutClick(){
        binding.btnLogout.setOnClickListener {
            prefs.saveLogin(0).let {
                val intent =   Intent(this@MenuActivity,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }


}