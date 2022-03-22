package com.example.testlanguage

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import java.util.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_choose_language,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            //khi chọn tiếng việt
            R.id.vietnamese -> {
                changeLanguage("vi")
            }
            //khi chọn tiếng anh
            R.id.american -> {
                changeLanguage("en")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun changeLanguage(s: String) {
        //thay đổi ngôn ngữ
        val locale = Locale(s)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(
            config,
            baseContext.resources.displayMetrics
        )
        //refesh view
        this.recreate()

        //nếu muốn fragment thay đổi thì ở đây
        viewModel.onChangeLanguage()
    }
}