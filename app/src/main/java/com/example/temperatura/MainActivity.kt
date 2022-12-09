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
        val cF = (temperatura * 1.8) + 32
        val cK = temperatura + 273
        val cC = temperatura
        val fC = (temperatura -32) / 1.8
        val fK = (temperatura + 459.67) * 5 / 9
        val fF = temperatura
        val kC = temperatura -273
        val kF = ((temperatura -273) *9/5) +32
        val kK = temperatura

        when {
            binding.radioButtonCelsius1.isChecked && binding.radioButtonFahrenheit2.isChecked ->
                binding.textViewResultado.setText("%.2f".format(cF))
            binding.radioButtonCelsius1.isChecked && binding.radioButtonKelvin2.isChecked ->
                binding.textViewResultado.setText("%.2f".format(cK))
            binding.radioButtonCelsius1.isChecked && binding.radioButtonCelsius2.isChecked ->
                binding.textViewResultado.setText("%.2f".format(cC))
            binding.radioButtonFahrenheit1.isChecked && binding.radioButtonCelsius2.isChecked ->
                binding.textViewResultado.setText("%.2f".format(fC))
            binding.radioButtonFahrenheit1.isChecked && binding.radioButtonKelvin2.isChecked ->
                binding.textViewResultado.setText("%.2f".format(fK))
            binding.radioButtonFahrenheit1.isChecked && binding.radioButtonFahrenheit2.isChecked ->
                binding.textViewResultado.setText("%.2f".format(fF))
            binding.radioButtonKelvin1.isChecked && binding.radioButtonCelsius2.isChecked ->
                binding.textViewResultado.setText("%.2f".format(kC))
            binding.radioButtonKelvin1.isChecked && binding.radioButtonFahrenheit2.isChecked ->
                binding.textViewResultado.setText("%.2f".format(kF))
            binding.radioButtonKelvin1.isChecked && binding.radioButtonKelvin2.isChecked ->
                binding.textViewResultado.setText("%.2f".format(kK))

        }

    }
}
