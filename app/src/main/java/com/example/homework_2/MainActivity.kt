package com.example.homework_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button:Button = findViewById(R.id.button)
        val editText:EditText = findViewById(R.id.editText)
        val textView:TextView = findViewById(R.id.textView)

            button.setOnClickListener(){

                val inputText = editText.text.toString()

                if(inputText.isEmpty()) {
                    textView.text = "ცარიელი ინფთი, სვადეთ თავიდან"
                }
                else {
                    try {
                        val result = returnInputAsText(inputText.toInt())
                        textView.text = "რიცხვი ტექსტურ ფორმატში: $result"

                    } catch (e: NumberFormatException) {
                        textView.text = "არასწორი ინფუთი, სცადეთ თავიდან"
                    }
                }
            }
        }
    }

    fun returnInputAsText(i: Int): String {
        var input = i
        if (input > 1000 || input <= 0) {
            return "არასწორი ინფუთი, აირჩიეთ რიცხვი 1-1000ის ფარგლებში"
        }

        if (input == 1000) {
            return "ათასი"
        }

        // Handling 100-s
        var result = ""

        if (input >= 100) {
            when (input / 100) {
                1 -> {
                    result += "ას"
                }
                2 -> {
                    result += "ირას"
                }
                3 -> {
                    result += "სამას"
                }
                4 -> {
                    result += "ოთხას"
                }
                5 -> {
                    result += "ხუთას"
                }
                6 -> {
                    result += "ექვსას"
                }
                7 -> {
                    result += "შვიდას"
                }
                8 -> {
                    result += "რვაას"
                }
                9 -> {
                    result += "ცხრაას"
                }
            }
        }

        input %= 100

        if (input == 0) {
            return result + "ი"
        }
        // Handling 20-s
        val twenty_count = input / 20
        if (input >= 20) {
            when (twenty_count) {
                1 -> result += " ოც"
                2 -> result += " ორმოც"
                3 -> result += " სამოც"
                4 -> result += " ოთხმოც"
            }
        }

        input %= 20
        if (input == 0) {
            return result + "ი"
        }

        if (twenty_count > 0) {
            result += "და"
        }

        // Handling [0-20)
        when (input) {
            1 -> return result + "ერთი"
            2 -> return result + "ორი"
            3 -> return result + "სამი"
            4 -> return result + "ოთხი"
            5 -> return result + "ხუთი"
            6 -> return result + "ექვსი"
            7 -> return result + "შვიდი"
            8 -> return result + "რვა"
            9 -> return result + "ცხრა"
            10 -> return result + "ათი"
            11 -> return result + "თერთმეტი"
            12 -> return result + "თორმეტი"
            13 -> return result + "ცამეტი"
            14 -> return result + "თოთხმეტი"
            15 -> return result + "თხუთმეტი"
            16 -> return result + "თექვსმეტი"
            17 -> return result + "ჩვიდმეტი"
            18 -> return result + "თვრამეტი"
            19 -> return result + "ცხრამეტი"
        }
        return result
    }