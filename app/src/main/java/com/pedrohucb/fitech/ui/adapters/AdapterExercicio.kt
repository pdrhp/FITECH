package com.pedrohucb.fitech.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.pedrohucb.fitech.R
import com.pedrohucb.fitech.models.Exercicio

class AdapterExercicio(private val context : Context, private val listaDeExercicios : List<Exercicio>) : BaseAdapter() {
    override fun getCount(): Int { return listaDeExercicios.size }

    override fun getItem(position: Int): Any {
        return listaDeExercicios[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view : View
        val viewHolder : ViewHolder

        if(convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item_exercicios, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val exercicio = getItem(position) as Exercicio
        viewHolder.imagem.setImageResource(exercicio.imagem)
        viewHolder.tituloExercicio.text = exercicio.tituloExercicio
        viewHolder.finalidadeExercicio.text = exercicio.finalidadeExercicio
        viewHolder.dificuldadeExercicio.text = exercicio.dificuldadeExercicio

        return view
    }

    private class ViewHolder(view : View){
        val imagem : ImageView = view.findViewById(R.id.imageExercicio)
        val tituloExercicio : TextView = view.findViewById(R.id.TextViewNomeDoExercicio)
        val finalidadeExercicio : TextView = view.findViewById(R.id.TextViewFinalidadeExercicio)
        val dificuldadeExercicio : TextView = view.findViewById(R.id.TextViewDificuldadeExercicio)
    }

}