package com.translate.app.language

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.translate.app.language.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private var _binding :ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){

            btnTranslateSpanish.setOnClickListener {
                changeLang("es")
            }

            btnTranslateHindi.setOnClickListener {
                changeLang("hi")

            }

            btnTranslateKorean.setOnClickListener {
                changeLang("ko")

            }

            btnTranslateFrench.setOnClickListener {
                changeLang("fr")

            }

            btnTranslateEnglish.setOnClickListener {
                changeLang("en")

            }
        }

    }

    private fun changeLang(langCode: String){
        try {
            val myLocale = Locale(langCode)
            val res: Resources = this.resources
            val dm: DisplayMetrics = res.displayMetrics
            val configuration: Configuration = res.configuration
            configuration.setLocale(myLocale)
            res.updateConfiguration(configuration, dm)
            this@MainActivity.recreate()
        } catch (e: Exception) {
            Log.e("LanguageError","Exception Changing Language: $e")
        }
    }

}