package com.pedrohucb.fitech.ui.activitys

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.pedrohucb.fitech.R
import com.pedrohucb.fitech.databinding.ActivityTelaPrincipalBinding

class TelaPrincipalActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTelaPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculadoraIMC.setOnClickListener {
            NavegarTelaCalculadoraIMC();
        }

        binding.buttonListaDeExercicios.setOnClickListener {
            NavegarTelaListaExercicios();
        }

        binding.buttonCalcularCalorias.setOnClickListener {
            NavegarTelaCalculadoraTMB()
        }

        binding.buttonSobreoApp.setOnClickListener{
            NavegarTelaSobreOApp()
        }

        binding.buttonMeuUsuario.setOnClickListener{ view ->
            AbrirPopUpMeuUsuario();
        }


    }



    private fun NavegarTelaListaExercicios(){
        val intent = Intent(this, ListExerciciosActivity::class.java)
        startActivity(intent)
    }
    private fun NavegarTelaCalculadoraIMC(){
        val intent = Intent(this, CalculadoraIMCActivity::class.java)
        startActivity(intent)
    }
    private fun NavegarTelaCalculadoraTMB(){
        val intent = Intent(this, CalculadoraTMBActivity::class.java)
        startActivity(intent)
    }

    private fun NavegarTelaSobreOApp(){
        val intent = Intent(this, SobreOAppActivity::class.java)
        startActivity(intent)
    }

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