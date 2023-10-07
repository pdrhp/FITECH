package com.pedrohucb.fitech.view.calculadoraimc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.pedrohucb.fitech.R

class AdapterCalculoAnteriores(private val context: Context, private val calculoAnterioresList: List<CalculoAnteriores>) : BaseAdapter() {
    override fun getCount(): Int {
        return calculoAnterioresList.size
    }

    override fun getItem(position: Int): Any {
        return calculoAnterioresList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder : ViewHolder

        if (convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item_historicocalculos, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val calculoAnterior = getItem(position) as CalculoAnteriores
        viewHolder.resultadoCalculo.text =  calculoAnterior.resultadoCalculo
        viewHolder.dataCalculo.text = calculoAnterior.dataCalculo

        return view;
    }

    private class ViewHolder(view: View){
        val resultadoCalculo: TextView = view.findViewById(R.id.listItemResultadoCalculo)
        val dataCalculo: TextView = view.findViewById(R.id.listItemDataCalculo)
    }

}