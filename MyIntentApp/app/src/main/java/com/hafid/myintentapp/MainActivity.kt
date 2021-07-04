package com.hafid.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity = findViewById<Button>(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveActivityWithData = findViewById<Button>(R.id.btn_move_activity_data)
        btnMoveActivityWithData.setOnClickListener(this)

        val btnDialPhone = findViewById<Button>(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity ->{
                val moveIntent = Intent(this,MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_data ->{
                val moveWithDataIntent = Intent(this,MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME,"Hafid")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE,20)
                startActivity(moveWithDataIntent)
            }

            R.id.btn_dial_number ->{
                val nohp = "08987654321"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$nohp"))
                startActivity(dialPhoneIntent)
            }

        }
    }
}