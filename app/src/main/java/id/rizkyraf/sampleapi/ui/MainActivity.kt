package id.rizkyraf.sampleapi.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.rizkyraf.sampleapi.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        onClick()
    }

    private fun onClick() {
        bLayoutVertical.setOnClickListener {
            val i = Intent(this, VerticalActivity::class.java)
            startActivity(i)
        }

        bLayoutHorizontal.setOnClickListener {
            val i = Intent(this, HorizontalActivity::class.java)
            startActivity(i)
        }

        bLayoutRelative.setOnClickListener {
            val i = Intent(this, RelativeActivity::class.java)
            startActivity(i)
        }

        bLayoutTable.setOnClickListener {
            val i = Intent(this, TabelActivity::class.java)
            startActivity(i)
        }

        bLayoutFrame.setOnClickListener {
            val i = Intent(this, FrameActivity::class.java)
            startActivity(i)
        }

        bLayoutGrid.setOnClickListener {
            val i = Intent(this, GridActivity::class.java)
            startActivity(i)
        }

        bLayoutApi.setOnClickListener {
            val i = Intent(this, ApiActivity::class.java)
            startActivity(i)
        }
    }

}
