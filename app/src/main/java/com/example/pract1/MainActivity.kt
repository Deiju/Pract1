package com.example.pract1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {
    lateinit var textData: EditText
    lateinit var button: Button
    lateinit var list: ListView
    lateinit var textView2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textData=findViewById(R.id.editText)
        list=findViewById(R.id.list)
        var Array= arrayListOf<String>()
        var adapter: ArrayAdapter<String> = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1,Array)
        list.setAdapter(adapter)
        button=findViewById(R.id.button)
        textView2=findViewById(R.id.textView2)
        button.setOnClickListener {
            val text=textData.text.toString().trim()
                if(text!=""){
                    Toast.makeText(this,"Готово",Toast.LENGTH_LONG).show()
                    Array.add(text)
                    adapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(this,"Пустая строка",Toast.LENGTH_LONG).show()
                }
        }
        list.setOnItemClickListener(object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, v: View, position: Int, id: Long) {
                val selectedItem: String = Array.get(position)
                adapter.remove(selectedItem)
            }
        })
    }
}