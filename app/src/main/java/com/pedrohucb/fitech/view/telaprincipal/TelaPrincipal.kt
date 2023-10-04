package com.pedrohucb.fitech.view.telaprincipal

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.PopupMenu
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.pedrohucb.fitech.R
import com.pedrohucb.fitech.databinding.ActivityTelaPrincipalBinding
import com.pedrohucb.fitech.view.formlogin.FormLogin

class TelaPrincipal : AppCompatActivity() {

    private lateinit var binding : ActivityTelaPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.buttonMeuUsuario.setOnClickListener{ view ->
            AbrirPopUpMeuUsuario();
        }
    }

    private fun AbrirPopUpMeuUsuario(){
        PopupMenu(this, binding.buttonMeuUsuario).apply {
            menuInflater.inflate(R.menu.menu_popup_usuario, this.menu)
            setOnMenuItemClickListener { item: MenuItem ->
                when(item.itemId){
                    R.id.item_sair -> {
                        FirebaseAuth.getInstance().signOut()
                        val voltarTelaLogin = Intent(this@TelaPrincipal, FormLogin::class.java)
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