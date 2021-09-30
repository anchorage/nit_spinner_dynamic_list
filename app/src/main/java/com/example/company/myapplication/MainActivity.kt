package com.example.company.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var spinnerString = MutableList(0) { "" }
        spinner.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, spinnerString)

        editText.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("TAG", "$p0")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                try {
                    var size = p0.toString().toInt()
                    var numbers = MutableList<String>(size) { x -> (x + 1).toString()  }
                    var adapter = ArrayAdapter<String>(this@MainActivity, android.R.layout.simple_list_item_1, numbers)
                    spinner.adapter = adapter
                    adapter.notifyDataSetChanged()


                } catch (e:Exception){

                }
            }

            override fun afterTextChanged(p0: Editable?) {
                Log.d("TAG", "$p0")
            /*
                try {
                    var size = p0.toString().toInt()
                    var numbers = MutableList<String>(size) { x -> (x + 1).toString()  }
                    var adapter = ArrayAdapter<String>(this@MainActivity, android.R.layout.simple_list_item_1, numbers)
                    spinner.adapter = adapter
                    adapter.notifyDataSetChanged()


                } catch (e:Exception){

                }*/
            }
        })
    }
}
