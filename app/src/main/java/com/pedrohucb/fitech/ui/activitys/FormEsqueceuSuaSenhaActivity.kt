package com.pedrohucb.fitech.ui.activitys

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.pedrohucb.fitech.databinding.ActivityFormEsqueceuSuaSenhaBinding

/**
 * Activity para o formulário de recuperação de senha.
 */
class FormEsqueceuSuaSenhaActivity : AppCompatActivity() {

    // Instância do objeto de binding com acesso às views do layout.
    private lateinit var binding: ActivityFormEsqueceuSuaSenhaBinding

    /**
     * Chamado quando a activity está iniciando.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormEsqueceuSuaSenhaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Define o listener de clique para o botão de recuperação de senha.
        binding.btEsqueceuASenha.setOnClickListener {
            val email: String =
                binding.etInputEmailEsqueceuASenha.text.toString().trim { it <= ' ' }
            MandaEmailDeRecuperacao(email, it)
        }

        // Define o listener de clique para o botão de cancelar.
        binding.btCancelar.setOnClickListener {
            finish()
        }
    }

    /**
     * Envia o e-mail de recuperação de senha.
     */
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

    /**
     * Exibe um Snackbar de erro.
     */
    private fun SnackBarErro(it: View, mensagem: String) {
        val snack = Snackbar.make(it, mensagem, Snackbar.LENGTH_SHORT)
        snack.setBackgroundTint(Color.RED)
        snack.show()
    }

    /**
     * Exibe um Snackbar de sucesso.
     */
    private fun SnackBarSucesso(it: View, mensagem: String) {
        val snack = Snackbar.make(it, mensagem, Snackbar.LENGTH_SHORT)
        snack.setBackgroundTint(Color.GREEN)
        snack.show()
    }
}