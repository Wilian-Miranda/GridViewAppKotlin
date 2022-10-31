package com.example.gridviewapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.gridviewapp.R
import com.example.gridviewapp.models.PersonModel

class AdapterCustome(
    var arrayListPersons: ArrayList<PersonModel>,
    var context: Context
):BaseAdapter(){
    //retorna la cantidad de registros del array
    override fun getCount(): Int {
        return arrayListPersons.size;
    }

    //obtiene un registro del array en una posición
    override fun getItem(position: Int): Any {
        return arrayListPersons[position]
    }

    //retorna el id del elemento según su posicion
    override fun getItemId(position: Int): Long {
        return position.toLong();
    }

    //retorna una vista dada una posición
    override fun getView(position: Int, layout: View?, viewGroup: ViewGroup?): View {
        var viewRowLayout = layout;
        if(viewRowLayout == null){
            //si la vista está vacía buscamos el layout creado para los items del grid
            viewRowLayout = LayoutInflater.from(context).inflate(R.layout.grid_row_layout,viewGroup,false);
        }
        //luego se tener el layout con el que vamos a trabajar creamos variables para conectar
        //cada elemento del layout (imagen, nombre, departemento)
        var personImg:ImageView = viewRowLayout!!.findViewById(R.id.row_img_id);
        var personName: TextView = viewRowLayout!!.findViewById(R.id.row_name);
        var personDeparment:TextView = viewRowLayout!!.findViewById(R.id.row_deparment);

        //ahora accedemos al registro en la una posicion determinada para encontrar los datos
        var personDataAtPosition:PersonModel = arrayListPersons[position];

        //luego cargamos cada dato en las variables que nos relacionan a los elementos del layout
        personImg.setImageResource(personDataAtPosition.person_id);
        personName.setText(personDataAtPosition.person_name);
        personDeparment.setText(personDataAtPosition.person_department);

        //una vez agregados los datos retornamos la vista de los datos en una
        //posicion de array en específico
        return viewRowLayout;
    }

}