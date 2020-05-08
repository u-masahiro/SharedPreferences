package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.SharedPreferences
// Kotlin Android Extensions
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // "DataStore"という名前でインスタンスを生成
        val dataStore: SharedPreferences = getSharedPreferences("DataStore", Context.MODE_PRIVATE)

        buttonWrite.setOnClickListener{
            // エディットテキストのテキストを取得
            val stringText = editText.text.toString()

            textWrite.text = stringText

            // 入力文字列を"Input"に書き込む
            val editor = dataStore.edit()
            editor.putString("Input", stringText)

            //editor.commit();
            editor.apply()
        }

        buttonRead.setOnClickListener{
            // "Input"から読み出す
            val str = dataStore.getString("Input", "NoData")

            textRead.text = str

        }
    }
}
