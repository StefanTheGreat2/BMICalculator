package org.antem.bmicalculator

class BMICalculator() {

    fun calculateMetricBMI(weight: Double, height: Double): Double {
        return (weight / ((height / 100) * (height / 100)))
    }
}