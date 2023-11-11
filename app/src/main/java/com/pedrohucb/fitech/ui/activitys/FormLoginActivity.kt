package com.pedrohucb.fitech.ui.activitys

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.pedrohucb.fitech.databinding.ActivityFormLoginBinding

class FormLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding
    private var auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btEntrarLogin.setOnClickListener { view ->
            val email = binding.etInputEmailLogin.text.toString();
            val senha = binding.etInputSenhaLogin.text.toString();

            AutenticaUsuario(email, senha, view)
        }

        binding.tvLabelEsqueceuSuaSenha.setOnClickListener {
            NavegarTelaEsqueceuSuaSenha()
        }

        binding.btCadastrarLogin.setOnClickListener {
            NavegarTelaDeCadastro()
        }
    }

    override fun onStart() {
        super.onStart()

        val usuarioAtual = FirebaseAuth.getInstance().currentUser

        if (usuarioAtual != null) {
            NavegarParaATelaPrincipal();
        }

    }

    private fun AutenticaUsuario(email: String, senha: String, view: View) {
        if (email.isEmpty() || senha.isEmpty()) {
            EnvioSnackBarErro(view, "Preencha todos os campos")
        } else {
            auth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener { autenticacao ->
                    if (autenticacao.isSuccessful) {
                        NavegarParaATelaPrincipal();
                    }
                }.addOnFailureListener { exception ->
                    val mensagemErro = when (exception) {
                        is FirebaseAuthInvalidCredentialsException -> "E-mail ou senha errados"
                        is FirebaseAuthInvalidUserException -> "E-mail não encontrado"
                        else -> "Não foi possivel fazer login"
                    }

                    EnvioSnackBarErro(view, mensagemErro)
                }
        }
    }

    private fun EnvioSnackBarErro(view: View, mensagemErro: String) {
        val snackbar = Snackbar.make(view, mensagemErro, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.RED)
        snackbar.show()
    }

    private fun NavegarTelaDeCadastro() {
        val intent = Intent(this, FormCadastroActivity::class.java)
        startActivity(intent)
    }

    private fun NavegarTelaEsqueceuSuaSenha() {
        val intent = Intent(this, FormEsqueceuSuaSenhaActivity::class.java)
        startActivity(intent)
    }

    private fun NavegarParaATelaPrincipal() {
        val intent = Intent(this, TelaPrincipalActivity::class.java)
        startActivity(intent)
        finish()
    }
}