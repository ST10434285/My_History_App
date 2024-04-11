package com.ST10434285.myhistoryapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /* Declarations */

        val genbutton = findViewById<Button>(R.id.genbutton)
        val clrbutton = findViewById<Button>(R.id.clrbutton)
        val ageNumtext = findViewById<EditText>(R.id.ageNumText)
        val resultview = findViewById<TextView>(R.id.resultview)

        genbutton.setOnClickListener {


            /* if else statement */
            val age = ageNumtext.text.toString().toIntOrNull()
            if (age == null) {
                resultview.text = "Please enter a valid age"


            } else {

                if (age < 20 || age > 100) {
                    resultview.text = "please enter a valid age between 20 to 100"
                    ageNumtext.text.clear()
                } else {
                    /* 10 Dead Famous People I chose */
                    val result = when (age) {
                        40 -> "Paul Walker IV was an American actor. He was best known for his role as Brian O'Connor in the Fast & Furious franchise."
                        43 -> "Chadwick Bosman was an American actor, he received several accolades in his two-decade career he was best known for his Marvel Black Panther Role."
                        74 -> "Muhammed Ali, An American professional boxer and activist Nicknamed 'the greatest', he is regarded as one of the most significant sports figured of the 20th century and the greatest heavyweight boxer of all time."
                        82 -> "Pele, a Brazilian Professional footballer who played as a forward Widely regarded as one of the greatest players of all time."
                        62 -> "Lance Solomon Reddick, an American actor and musician he was known for his roles as Cedric Daniels in 'The Wire' and starred as Charon in the John Wick Franchise."
                        36 -> "Diana, Princess of wales was a member of the British royal family. Her activism and glamour made her an international icon and earned her enduring popularity."
                        96 -> "Elizabeth||, Queen of the United Kingdom and other Commonwealth realms.She was Queen regnant of 32 sovereign states over the course of her lifetime and remained the monarch of 15 realms by the time of her death."
                        60 -> "Diego Maradona was an Argentine soccer legend who was widely regarded as one of the best players of all time,he also famously starred for Argentinean team that won the world cup in 1986."
                        58 -> "Gianluca Vialli, an Italian football player and manager who played as a striker, he joined Chelsea in the summer of 1996 shortly after captaining Juventus to Champions league glory. The club called him a Chelsea Legend loved by fans, players and staff at Stamford Bridge."
                        76 -> "Carl Weathers, an American actor, director and gridiron football linebacker. His roles included boxer Apollo Creed in the first four Rocky films."

                        else -> "No one Died at this age, try a different one!"

                    }
                    resultview.text = result

                }

            }
            clrbutton.setOnClickListener {
                ageNumtext.text.clear()
                resultview.text = ""
            }


        }
    }
}
