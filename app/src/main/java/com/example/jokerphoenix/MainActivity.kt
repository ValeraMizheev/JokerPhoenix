package com.example.jokerphoenix

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var d:Dialog
    var t = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        imgStart.setOnClickListener {
            val intent = Intent(MainActivity@this, GameActivity::class.java)
            intent.putExtra("isD" , true)
            finish()
            startActivity(intent)
        }
        imgRules.setOnClickListener {
            showRules()
        }
    }
    fun showRules() {
        d = Dialog(this)
        d.requestWindowFeature(Window.FEATURE_NO_TITLE)
        d.setContentView(R.layout.d_rules)
        d.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        d.setCancelable(false)
        val ok = d.findViewById<Button>(R.id.bOk)
        val imgExit = d.findViewById<ImageView>(R.id.iExit)
        ok.setOnClickListener {
            d.dismiss()
            finish()
            startActivity(Intent(MainActivity@this, GameActivity::class.java))
        }
        imgExit.setOnClickListener {
            d.dismiss()
        }
        d.show()
    }
    override fun onBackPressed() {
        if(t+1000<System.currentTimeMillis()){
            super.onBackPressed()
        } else {
            t=System.currentTimeMillis()
            Toast.makeText(this,"Double click to exit.",Toast.LENGTH_SHORT).show()
        }

    }
}