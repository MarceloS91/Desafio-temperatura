package com.example.temperatura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.temperatura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressWarnings("WrongViewCast", "MissingInflateId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonresult.setOnClickListener {
            converter()
        }
    }

    fun converter() {
        val temperatura = binding.editTextTemperatura.text.toString().toDouble()
        val celsiusToFahrenheit = (temperatura * 1.8) + 32
        val celsiusToKelvin = temperatura + 273
        val celsiusToCelsius = temperatura
        val fahrenheitToCelsius = (temperatura -32) / 1.8
        val fahrenheitToKelvin = (temperatura + 459.67) * 5 / 9
        val fahrenheitToFahrenheit = temperatura
        val kelvinToCelsius = temperatura -273
        val kelvinToFahrenheit = ((temperatura -273) *9/5) +32
        val kelvinToKelvin = temperatura

        when {
            binding.radioButtonCelsius1.isChecked && binding.radioButtonFahrenheit2.isChecked ->
                binding.textViewResultado.setText("%.2f".format(celsiusToFahrenheit))
            binding.radioButtonCelsius1.isChecked && binding.radioButtonKelvin2.isChecked ->
                binding.textViewResultado.setText("%.2f".format(celsiusToKelvin))
            binding.radioButtonCelsius1.isChecked && binding.radioButtonCelsius2.isChecked ->
                binding.textViewResultado.setText("%.2f".format(celsiusToCelsius))
            binding.radioButtonFahrenheit1.isChecked && binding.radioButtonCelsius2.isChecked ->
                binding.textViewResultado.setText("%.2f".format(fahrenheitToCelsius))
            binding.radioButtonFahrenheit1.isChecked && binding.radioButtonKelvin2.isChecked ->
                binding.textViewResultado.setText("%.2f".format(fahrenheitToKelvin))
            binding.radioButtonFahrenheit1.isChecked && binding.radioButtonFahrenheit2.isChecked ->
                binding.textViewResultado.setText("%.2f".format(fahrenheitToFahrenheit))
            binding.radioButtonKelvin1.isChecked && binding.radioButtonCelsius2.isChecked ->
                binding.textViewResultado.setText("%.2f".format(kelvinToCelsius))
            binding.radioButtonKelvin1.isChecked && binding.radioButtonFahrenheit2.isChecked ->
                binding.textViewResultado.setText("%.2f".format(kelvinToFahrenheit))
            binding.radioButtonKelvin1.isChecked && binding.radioButtonKelvin2.isChecked ->
                binding.textViewResultado.setText("%.2f".format(kelvinToKelvin))

        }
    }
}
