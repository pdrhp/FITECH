package com.pedrohucb.fitech.ui.activitys

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.pedrohucb.fitech.databinding.ActivityFormCadastroBinding

class FormCadastroActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFormCadastroBinding
    private val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

            binding.btCadastrarCadastro.setOnClickListener { view ->

                val email = binding.etInputEmailCadastro.text.toString();
                val senha = binding.etInputSenhaCadastro.text.toString();

                if (email.isEmpty() || senha.isEmpty()) {
                    val snackbar =
                        Snackbar.make(view, "Preencha todos os campos", Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show()
                } else {
                    if (binding.cbTermos.isChecked) {
                        auth.createUserWithEmailAndPassword(email, senha)
                            .addOnCompleteListener { cadastro ->
                                if (cadastro.isSuccessful) {
                                    val snackbar = Snackbar.make(
                                        view,
                                        "Sucesso ao cadastrar usuário",
                                        Snackbar.LENGTH_SHORT
                                    )
                                    snackbar.setBackgroundTint(Color.GREEN)
                                    snackbar.show()
                                    binding.etInputEmailCadastro.setText("")
                                    binding.etInputSenhaCadastro.setText("")
                                }
                            }.addOnFailureListener { exception ->

                                val mensagemErro = when(exception){
                                    is FirebaseAuthWeakPasswordException -> "Digite uma senha com no minimo 6 caracteres."
                                    is FirebaseAuthInvalidCredentialsException -> "Digite um e-mail válido"
                                    is FirebaseAuthUserCollisionException -> "E-mail já cadastrado"
                                    is FirebaseNetworkException -> "Sem conexão com a internet"
                                    else -> "Erro ao cadastrar usuário!"
                                }

                                val snackbar = Snackbar.make(view, mensagemErro, Snackbar.LENGTH_SHORT)
                                snackbar.setBackgroundTint(Color.RED)
                                snackbar.show()

                            }
                    }else{
                      val snackbar = Snackbar.make(view, "É necessario aceitar os termos e serviços", Snackbar.LENGTH_SHORT)
                      snackbar.setBackgroundTint(Color.rgb(255, 153, 51))
                      snackbar.show()
                }
            }
        }

    }
}