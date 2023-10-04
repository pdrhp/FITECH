package com.pedrohucb.fitech.view.formlogin

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.pedrohucb.fitech.R
import com.pedrohucb.fitech.databinding.ActivityFormLoginBinding
import com.pedrohucb.fitech.view.formcadastro.FormCadastro
import com.pedrohucb.fitech.view.telaprincipal.TelaPrincipal

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding
    private var auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btEntrarLogin.setOnClickListener { view ->
            val email = binding.etInputEmailLogin.text.toString();
            val senha = binding.etInputSenhaLogin.text.toString();

            if(email.isEmpty() || senha.isEmpty()){
                val snackbar = Snackbar.make(view, "Preencha todos os campos", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            }else{
                auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener{ autenticacao ->
                    if(autenticacao.isSuccessful){
                        NavegarParaATelaPrincipal();
                    }
                }.addOnFailureListener{ exception ->
                    val mensagemErro = when(exception){
                        is FirebaseAuthInvalidCredentialsException -> "E-mail ou senha errados"
                        is FirebaseAuthInvalidUserException -> "E-mail não encontrado"
                        else -> "Não foi possivel fazer login"
                    }

                    val snackbar = Snackbar.make(view, mensagemErro, Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show()
                }
            }
        }

        binding.btCadastrarLogin.setOnClickListener{
            val intent = Intent(this, FormCadastro::class.java)
            startActivity(intent)
        }
    }
    private fun NavegarParaATelaPrincipal(){
        val intent = Intent(this, TelaPrincipal::class.java)
        startActivity(intent)
        finish()
    }

    override fun onStart() {
        super.onStart()

        val usuarioAtual = FirebaseAuth.getInstance().currentUser

        if (usuarioAtual != null){
            NavegarParaATelaPrincipal();
        }

    }
}