package com.pedrohucb.fitech.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.pedrohucb.fitech.R
import com.pedrohucb.fitech.models.RegiaoDosExercicios

class AdapterRegiaoExercico(private val context : Context, private val regiaoExercicioList : List<RegiaoDosExercicios>) : BaseAdapter() {
    override fun getCount(): Int {
        return regiaoExercicioList.size
    }

    override fun getItem(position: Int): Any {
        return regiaoExercicioList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View
        val viewHolder : ViewHolder

        if(convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item_regiaoexercicio, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val regiaoDosExercicios = getItem(position) as RegiaoDosExercicios
        viewHolder.imagemRegiao.setImageResource(regiaoDosExercicios.imagem)
        viewHolder.regiaoDoExercicio.text = regiaoDosExercicios.tipoExercicio.descParte

        return view;
    }

    private class ViewHolder(view : View){
        val imagemRegiao : ImageView = view.findViewById(R.id.imageViewRegiaoExercicio)
        val regiaoDoExercicio :  TextView = view.findViewById(R.id.TextViewRegiaoExercicio)
    }
}