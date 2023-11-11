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

class FormCadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding
    private val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCadastrarCadastro.setOnClickListener { view ->

            val email = binding.etInputEmailCadastro.text.toString();
            val senha = binding.etInputSenhaCadastro.text.toString();

            CadastraUsuario(email, senha, view)
        }

    }

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

    private fun SnackBarAviso(view: View, mensagem: String) {
        val snackbar = Snackbar.make(
            view,
            mensagem,
            Snackbar.LENGTH_SHORT
        )
        snackbar.setBackgroundTint(Color.rgb(255, 153, 51))
        snackbar.show()
    }

    private fun snackBarSucesso(view: View, mensagem: String) {
        val snackbar = Snackbar.make(
            view,
            mensagem,
            Snackbar.LENGTH_SHORT
        )
        snackbar.setBackgroundTint(Color.GREEN)
        snackbar.show()
    }

    private fun SnackBarErro(view: View, mensagem: String) {
        val snackbar =
            Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.RED)
        snackbar.show()
    }
}