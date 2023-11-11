package com.pedrohucb.fitech.ui.activitys

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.pedrohucb.fitech.databinding.ActivityFormCadastroBinding

/**
 * Activity para o formulário de cadastro.
 */
class FormCadastroActivity : AppCompatActivity() {

    // Instância do objeto de binding com acesso às views do layout.
    private lateinit var binding: ActivityFormCadastroBinding
    // Instância do FirebaseAuth para autenticação do usuário.
    private val auth = FirebaseAuth.getInstance()

    /**
     * Chamado quando a activity está iniciando.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Define o listener de clique para o botão de cadastro.
        binding.btCadastrarCadastro.setOnClickListener { view ->

            val email = binding.etInputEmailCadastro.text.toString();
            val senha = binding.etInputSenhaCadastro.text.toString();

            CadastraUsuario(email, senha, view)
        }

    }

    /**
     * Cadastra o usuário.
     */
    private fun CadastraUsuario(email: String, senha: String, view: View) {
        if (email.isEmpty() || senha.isEmpty()) {
            SnackBarErro(view, "Preencha todos os campos")
        } else {
            if (binding.cbTermos.isChecked) {
                auth.createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener { cadastro ->
                        if (cadastro.isSuccessful) {
                            snackBarSucesso(view, "Sucesso ao cadastrar usuário")
                            binding.etInputEmailCadastro.setText("")
                            binding.etInputSenhaCadastro.setText("")
                        }
                    }.addOnFailureListener { exception ->

                        val mensagemErro = when (exception) {
                            is FirebaseAuthWeakPasswordException -> "Digite uma senha com no minimo 6 caracteres."
                            is FirebaseAuthInvalidCredentialsException -> "Digite um e-mail válido"
                            is FirebaseAuthUserCollisionException -> "E-mail já cadastrado"
                            is FirebaseNetworkException -> "Sem conexão com a internet"
                            else -> "Erro ao cadastrar usuário!"
                        }

                        SnackBarErro(view, mensagemErro)
                    }
            } else {
                SnackBarAviso(view, "É necessario aceitar os termos e serviços")
            }
        }
    }

    /**
     * Exibe um Snackbar de aviso.
     */
    private fun SnackBarAviso(view: View, mensagem: String) {
        val snackbar = Snackbar.make(
            view,
            mensagem,
            Snackbar.LENGTH_SHORT
        )
        snackbar.setBackgroundTint(Color.rgb(255, 153, 51))
        snackbar.show()
    }

    /**
     * Exibe um Snackbar de sucesso.
     */
    private fun snackBarSucesso(view: View, mensagem: String) {
        val snackbar = Snackbar.make(
            view,
            mensagem,
            Snackbar.LENGTH_SHORT
        )
        snackbar.setBackgroundTint(Color.GREEN)
        snackbar.show()
    }

    /**
     * Exibe um Snackbar de erro.
     */
    private fun SnackBarErro(view: View, mensagem: String) {
        val snackbar =
            Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.RED)
        snackbar.show()
    }
}