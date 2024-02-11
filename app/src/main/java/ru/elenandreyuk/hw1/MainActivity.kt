package ru.elenandreyuk.hw1

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.elenandreyuk.hw1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateUI(binding)
        binding.imageButtonAdd.setOnClickListener {
            if (counter == 50) {
                updateUI(binding)
            } else {
                counter++
                binding.textCount.text = "$counter"
                updateUI(binding)
            }
        }
        binding.imageButtonRemove.setOnClickListener {
            if (counter == 0) {
                updateUI(binding)
            } else {
                counter--
                binding.textCount.text = "$counter"
                updateUI(binding)
            }
        }
//        binding.textCount.text = "$counter"
//        if (counter < 50 && counter > 0) {
//            updateUI(binding)
//
//        }
        binding.buttonReset.setOnClickListener {
            counter = 0
            binding.buttonReset.visibility = View.INVISIBLE
            updateUI(binding)
        }
    }

    fun updateUI(binding: ActivityMainBinding) {
        binding.textCount.text = "$counter"
        when (counter) {
            0 -> {
                binding.textCenter.text = getText(R.string.centerStart)
                binding.textCenter.setTextColor(getColor(R.color.green))
                binding.imageButtonRemove.isEnabled = false
                binding.buttonReset.visibility = View.INVISIBLE
            }

            in 1..49 -> {
                binding.textCenter.text = "${getText(R.string.centerMiddle)} ${50 - counter}"
                binding.textCenter.setTextColor(getColor(R.color.blue))
                binding.imageButtonRemove.isEnabled = true
                binding.buttonReset.visibility = View.INVISIBLE
            }

            50 -> {
                binding.textCenter.text = getText(R.string.centerFinish)
                binding.textCenter.setTextColor(getColor(R.color.red))
                binding.imageButtonRemove.isEnabled = true
                binding.buttonReset.visibility = View.VISIBLE
            }
        }
    }
}