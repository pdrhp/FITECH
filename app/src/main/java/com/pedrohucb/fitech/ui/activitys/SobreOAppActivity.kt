package com.pedrohucb.fitech.ui.activitys
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pedrohucb.fitech.databinding.ActivitySobreoappBinding

class SobreOAppActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySobreoappBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySobreoappBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.iconButtonVoltarTelaSobreOApp.setOnClickListener {
            finish()
        }

    }
}