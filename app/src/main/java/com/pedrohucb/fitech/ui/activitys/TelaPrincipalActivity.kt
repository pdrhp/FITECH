package com.pedrohucb.fitech.ui.activitys

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.pedrohucb.fitech.R
import com.pedrohucb.fitech.databinding.ActivityTelaPrincipalBinding

/**
 * Activity para a tela principal.
 */
class TelaPrincipalActivity : AppCompatActivity() {

    // Instância do objeto de binding com acesso às views do layout.
    private lateinit var binding : ActivityTelaPrincipalBinding

    /**
     * Chamado quando a activity está iniciando.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Define o listener de clique para o botão da calculadora de IMC.
        binding.buttonCalculadoraIMC.setOnClickListener {
            NavegarTelaCalculadoraIMC();
        }

        // Define o listener de clique para o botão da lista de exercícios.
        binding.buttonListaDeExercicios.setOnClickListener {
            NavegarTelaListaExercicios();
        }

        // Define o listener de clique para o botão de calcular calorias.
        binding.buttonCalcularCalorias.setOnClickListener {
            NavegarTelaCalculadoraTMB()
        }

        // Define o listener de clique para o botão "Sobre o App".
        binding.buttonSobreoApp.setOnClickListener{
            NavegarTelaSobreOApp()
        }

        // Define o listener de clique para o botão "Meu Usuário".
        binding.buttonMeuUsuario.setOnClickListener{ view ->
            AbrirPopUpMeuUsuario();
        }


    }


    /**
     * Navega para a tela da lista de exercícios.
     */
    private fun NavegarTelaListaExercicios(){
        val intent = Intent(this, ListExerciciosActivity::class.java)
        startActivity(intent)
    }

    /**
     * Navega para a tela da calculadora de IMC.
     */
    private fun NavegarTelaCalculadoraIMC(){
        val intent = Intent(this, CalculadoraIMCActivity::class.java)
        startActivity(intent)
    }

    /**
     * Navega para a tela da calculadora de TMB.
     */
    private fun NavegarTelaCalculadoraTMB(){
        val intent = Intent(this, CalculadoraTMBActivity::class.java)
        startActivity(intent)
    }

    /**
     * Navega para a tela "Sobre o App".
     */
    private fun NavegarTelaSobreOApp(){
        val intent = Intent(this, SobreOAppActivity::class.java)
        startActivity(intent)
    }

    /**
     * Abre o pop-up "Meu Usuário".
     */
    private fun AbrirPopUpMeuUsuario(){
        PopupMenu(this, binding.buttonMeuUsuario).apply {
            menuInflater.inflate(R.menu.menu_popup_usuario, this.menu)
            setOnMenuItemClickListener { item: MenuItem ->
                when(item.itemId){
                    R.id.item_sair -> {
                        FirebaseAuth.getInstance().signOut()
                        val voltarTelaLogin = Intent(this@TelaPrincipalActivity, FormLoginActivity::class.java)
                        startActivity(voltarTelaLogin)
                        finish()
                        true
                    }
                    R.id.item_MinhaConta -> {
                        TODO("Fazer activity Minha_Conta")
                        true
                    }
                    else -> {
                        true
                    }
                }
            }
            show()
        }
    }
}