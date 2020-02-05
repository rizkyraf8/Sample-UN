package id.rizkyraf.sampleapi

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        onClick()
    }

    fun onClick() {
        bLayoutVertical.setOnClickListener {
            val i = Intent(this, VerticalActivity::class.java)
            startActivity(i)
        }

        bLayoutHorizontal.setOnClickListener {
            val i = Intent(this, HorizontalActivity::class.java)
            startActivity(i)
        }
    }

}