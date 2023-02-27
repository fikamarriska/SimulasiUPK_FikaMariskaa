package com.example.simulasiupk_fikamariskaa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterPersegi(private  var dataSet : MutableList<DataPersegi>):
        RecyclerView.Adapter<AdapterPersegi.DataPersegiHolder>(){
    class DataPersegiHolder (view: View) : RecyclerView.ViewHolder(view){
        val Sisipersegi = view.findViewById<TextView>(R.id.txtSisi)
        val Luaspersegi = view.findViewById<TextView>(R.id.txtLuas)
        val Kelilingpersegi = view.findViewById<TextView>(R.id.txtKeliling)
        val hapus = view.findViewById<ImageView>(R.id.ic_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataPersegiHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_adapter_persegi, parent, false
        )
        return DataPersegiHolder(view)
    }

    override fun onBindViewHolder(holder: DataPersegiHolder, position: Int) {
        val data = dataSet[position]
        holder.Sisipersegi.text = dataSet[position].sisi_persegi
        holder.Luaspersegi.text = dataSet[position].luas_persegi
        holder.Kelilingpersegi.text = dataSet[position].keliling_persegi
        holder.hapus.setOnClickListener{
            dataSet.removeAt(position)
            notifyItemRangeRemoved(position, dataSet.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}