package org.antem.bmicalculator

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val weight: EditText = findViewById(R.id.weight)
        val height: EditText = findViewById(R.id.height)
        val result: TextView = findViewById(R.id.result)
        val calculate: Button = findViewById(R.id.calculate)
        val background: FrameLayout = findViewById(R.id.BMIBackground)



        calculate.setOnClickListener(calculate(result, weight, height, background))


    }

    fun calculate(
        textView: TextView,
        weight: EditText,
        height: EditText,
        background: FrameLayout
    ): View.OnClickListener {
        return View.OnClickListener {
            if (weight.text.toString().isNotEmpty() && height.text.toString().isNotEmpty()) {
                if (weight.text.toString().toDouble() > 0 && height.text.toString()
                        .toDouble() > 0
                ) {
                    val h = height.text.toString().toDouble()
                    val w = weight.text.toString().toDouble()

                    val resultBMI = BMICalculator().calculateMetricBMI(w, h)
                    val formattedBMI: String = String.format("%.2f", resultBMI)


                    if (resultBMI < 18.5) {

                        textView.text = ("BMI : $formattedBMI\n Underweight ")
                        background.background =
                            AppCompatResources.getDrawable(this, R.drawable.red_bkg)


                    } else if (resultBMI >= 18.5 && resultBMI < 25) {
                        textView.text = ("BMI : $formattedBMI\n Healthy ")
                        background.background =
                            AppCompatResources.getDrawable(this, R.drawable.green_bkg)

                    } else if (resultBMI >= 25 && resultBMI < 30) {
                        textView.text = ("BMI : $formattedBMI\n Overweight ")
                        background.background =
                            AppCompatResources.getDrawable(this, R.drawable.yellow_bkg)

                    } else {
                        textView.text = ("BMI : $formattedBMI\n Obese ")
                        background.background =
                            AppCompatResources.getDrawable(this, R.drawable.red_bkg)


                    }


                } else {
                    Toast.makeText(
                        this,
                        "Please enter numbers greater then zero",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            } else {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            }
        }
    }


}