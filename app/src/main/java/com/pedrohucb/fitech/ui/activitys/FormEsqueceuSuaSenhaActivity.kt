package com.pedrohucb.fitech.ui.activitys

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.pedrohucb.fitech.databinding.ActivityFormEsqueceuSuaSenhaBinding

class FormEsqueceuSuaSenhaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormEsqueceuSuaSenhaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormEsqueceuSuaSenhaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btEsqueceuASenha.setOnClickListener {
            val email: String =
                binding.etInputEmailEsqueceuASenha.text.toString().trim { it <= ' ' }
            MandaEmailDeRecuperacao(email, it)
        }

        binding.btCancelar.setOnClickListener {
            finish()
        }
    }

    private fun MandaEmailDeRecuperacao(email: String, it: View) {
        if (email.isEmpty()) {
            SnackBarErro(it, "Preencha o campo email")
        } else {
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        SnackBarSucesso(it, "Email enviado com sucesso")
                    }
                }.addOnFailureListener { exception ->
                    val mensagemErro = when (exception) {
                        is FirebaseAuthInvalidUserException -> "Endereço de email invalido"
                        else -> "Não foi possivel concluir a operação"
                    }
                    SnackBarErro(it, mensagemErro)
                }
        }
    }

    private fun SnackBarErro(it: View, mensagem: String) {
        val snack = Snackbar.make(it, mensagem, Snackbar.LENGTH_SHORT)
        snack.setBackgroundTint(Color.RED)
        snack.show()
    }

    private fun SnackBarSucesso(it: View, mensagem: String) {
        val snack = Snackbar.make(it, mensagem, Snackbar.LENGTH_SHORT)
        snack.setBackgroundTint(Color.GREEN)
        snack.show()
    }
}