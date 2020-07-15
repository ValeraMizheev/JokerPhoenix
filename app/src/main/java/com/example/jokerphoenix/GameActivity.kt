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
import android.widget.TextView

class GameActivity : AppCompatActivity() {
    lateinit var d:Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)



        val isD = intent.getBooleanExtra("isD", false)
        if(isD)
            showRules()

    }
    fun showRules() {
        d = Dialog(this)
        d.requestWindowFeature(Window.FEATURE_NO_TITLE)
        d.setContentView(R.layout.d_rules)
        d.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        d.setCancelable(false)
        val ok = d.findViewById<Button>(R.id.bOk)
        val imgExit = d.findViewById<ImageView>(R.id.iExit)
        val textRules = d.findViewById<TextView>(R.id.tRules)
        ok.setOnClickListener {
            d.dismiss()
        }
        imgExit.setOnClickListener {
            d.dismiss()
        }
        d.show()
    }
    override fun onBackPressed() {
        finish()
        startActivity(Intent(GameActivity@this, MainActivity::class.java))
    }

}