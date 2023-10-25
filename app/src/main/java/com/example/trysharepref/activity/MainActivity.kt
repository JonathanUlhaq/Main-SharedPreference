package com.example.trysharepref.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.trysharepref.databinding.ActivityMainBinding
import com.example.trysharepref.utils.CustomSharePrefs

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var prefs:CustomSharePrefs
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        checkCondition()
        loginClick()
    }

    fun init () {
        prefs = CustomSharePrefs(this@MainActivity)
    }

    fun checkCondition() {
        if (!prefs.getLogin().equals(0)) {
            val intent =   Intent(this@MainActivity,MenuActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun loginClick() {
        binding.btnLogin.setOnClickListener {
            prefs.saveLogin(1).let {
                val intent =   Intent(this@MainActivity,MenuActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }
}