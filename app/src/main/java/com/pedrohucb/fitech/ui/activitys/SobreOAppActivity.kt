package com.pedrohucb.fitech.ui.activitys
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pedrohucb.fitech.databinding.ActivitySobreoappBinding

class SobreOAppActivity : AppCompatActivity() {

    /**
     * Activity para a tela "Sobre o App".
     */
    // Instância do objeto de binding com acesso às views do layout.
    private lateinit var binding : ActivitySobreoappBinding

    /**
     * Chamado quando a activity está iniciando.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySobreoappBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Define o listener de clique para o botão de voltar.
        binding.iconButtonVoltarTelaSobreOApp.setOnClickListener {
            finish()
        }

    }
}