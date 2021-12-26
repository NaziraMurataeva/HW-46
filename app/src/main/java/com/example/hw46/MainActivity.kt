package com.example.hw46

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.annotation.MainThread
import com.example.hw46.databinding.ActivityMainBinding

 lateinit var  binding :ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var pref = getPreferences(Context.MODE_PRIVATE)
        val text = pref.getString("TEXT", "")
        binding.editText.setText(text)



        binding.buttonSave.setOnClickListener {
            var pref = getPreferences(Context.MODE_PRIVATE)
            val editor = pref.edit()

            editor.putString("TEXT", binding.editText.text.toString())
            editor.commit()
            val toast = Toast.makeText(applicationContext, "сохранено", Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP, 0, 140)
            toast.show()

            binding.buttonDel.setOnClickListener {

                editor.clear()
                editor.commit()
                binding.editText.setText("")

                val toast = Toast.makeText(applicationContext, "Удалено", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.TOP, 0, 140)
                toast.show()

            }


        }
    }
}
