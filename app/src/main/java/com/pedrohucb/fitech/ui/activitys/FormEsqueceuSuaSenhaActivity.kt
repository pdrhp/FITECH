package com.pedrohucb.fitech.ui.activitys

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.pedrohucb.fitech.databinding.ActivityFormEsqueceuSuaSenhaBinding

class FormEsqueceuSuaSenhaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityFormEsqueceuSuaSenhaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormEsqueceuSuaSenhaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btEsqueceuASenha.setOnClickListener {
            val email : String = binding.etInputEmailEsqueceuASenha.text.toString().trim{ it <= ' ' }
            if(email.isEmpty()){
                val snack = Snackbar.make(it, "Preencha o campo email", Snackbar.LENGTH_SHORT)
                snack.setBackgroundTint(Color.RED)
                snack.show()
            }else{
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener{ task ->
                        if(task.isSuccessful){
                            val snack = Snackbar.make(it, "Email enviado com sucesso", Snackbar.LENGTH_SHORT)
                            snack.setBackgroundTint(Color.GREEN)
                            snack.show()
                        }
                    }.addOnFailureListener { exception ->
                        val mensagemErro = when(exception){
                            is FirebaseAuthInvalidUserException -> "Endereço de email invalido"
                            else -> "Não foi possivel concluir a operação"
                        }
                        val snack = Snackbar.make(it, mensagemErro, Snackbar.LENGTH_SHORT)
                        snack.setBackgroundTint(Color.RED)
                        snack.show()
                    }
            }
        }

        binding.btCancelar.setOnClickListener {
            finish()
        }
    }
}