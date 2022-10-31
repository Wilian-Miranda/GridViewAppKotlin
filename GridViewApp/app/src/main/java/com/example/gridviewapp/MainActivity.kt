package com.example.gridviewapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.GridView
import com.example.gridviewapp.adapters.AdapterCustome
import com.example.gridviewapp.models.PersonModel

class MainActivity : AppCompatActivity() {
    //variables para conectar los elementos de la vista con el código
    private lateinit var gvPersons: GridView;

    //creamos el arreglo de datos de tipo PersonModel que se cargaran en el grid view
    var arrayListPersons = ArrayList<PersonModel>();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //sincronizamos la variable con el grid view
        gvPersons = findViewById(R.id.gv_main_id);

        arrayListPersons.add(PersonModel(R.drawable.image1,"Kemberly","Chalatenango"));
        arrayListPersons.add(PersonModel(R.drawable.image2,"Carlos","Del Corral"));
        arrayListPersons.add(PersonModel(R.drawable.image3,"Manuel","Agua Caliente"));
        arrayListPersons.add(PersonModel(R.drawable.image4,"Ary","San Vicente"));

        //creamos una variable adapter personalizado al que le agregamos los datos del array que queremos muestre
        var adapterGrid: AdapterCustome? = AdapterCustome(arrayListPersons,this);

        gvPersons.adapter = adapterGrid;

        gvPersons.onItemClickListener = object : AdapterView.OnItemClickListener{
            //este método nos permite detectar cuando se ha dado click en un elemento del grid
            override fun onItemClick(parent: AdapterView<*>?, view: View?, positon: Int, id: Long) {
                val windowDetailItemGrid: Intent = Intent(applicationContext,DetailItemGrid::class.java);
                windowDetailItemGrid.putExtra("detailImg",arrayListPersons[positon].person_id);
                windowDetailItemGrid.putExtra("detailName",arrayListPersons[positon].person_name);
                windowDetailItemGrid.putExtra("detailDepartment",arrayListPersons[positon].person_department);
                startActivity(windowDetailItemGrid);
            }

        }

    }
}