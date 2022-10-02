package com.example.androidlab

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidlab.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.buttonMessage.setOnClickListener{
            composeMessage("Привет! Переходи по ссылке и выиграй 1 млн рублей! http://money.ru/freemoney")
        }
        binding.buttonOpenURL.setOnClickListener{
            openWebPage()
        }
        binding.buttonGallery.setOnClickListener {
            openTime()
        }
    }


    private fun composeMessage(message: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, message)
        val chosenIntent = Intent.createChooser(intent, "Выбери куда отправить")
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(chosenIntent)
        }
    }

    private fun openWebPage() {
        val url = "https://www.purina.com/cats/cat-breeds"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)

    }

    private fun openTime() {
        val intent = Intent("ru.startandroid.intent.action.showtime");
        startActivity(intent);
    }
}