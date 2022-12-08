package com.example.kotlin_android

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

//import kotlinx.coroutines.flow.internal.NoOpContinuation.context

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        val textView: TextView = findViewById(R.id.text_view)
        button.setOnClickListener {
            textView.text = getString(R.string.hello)
            val myToast = Toast.makeText(this, getString(R.string.toast_message), Toast.LENGTH_LONG)
            myToast.show()
        }
        var city = City("Керчь", "700", " лет до хр. э.")
        val textViewCity: TextView = findViewById(R.id.text_view_city)
        textViewCity.text = "Город-герой " + city.town + " был основан " + city.year + city.age
        val repositoryData = Repository.getData()
        val textAncient: TextView = findViewById(R.id.text_ancient)
        textAncient.text = repositoryData
        var cities: ArrayList<String> = arrayListOf("")
        cities.clear()
        cities.add("Москва")
        cities.add("Питер")
        cities.add("Саратов")
        println("Цикл for each")
        for (city in cities) {
            println(city)
        }
        println("Простая итерация по возростанию")
        for (i in 1..8) {
            println("Line " + i)
        }
        println("Итерация по убыванию с шагом 2")
        for (i in 20 downTo 1 step 2) {
            println("Count " + i)
        }
        println("Итерация по возростанию until")
        for (i in 0 until cities.size) {
            var str = if (cities[i] != null) {
                cities[i]
            } else {
                cities[0]
            }
            println(str + " " + i)
        }
    }

    data class City(val town: String, val year: String, val age: String)

    object Repository {
        fun getData(): String {
            return "Он самый древний город России"
        }
    }

}