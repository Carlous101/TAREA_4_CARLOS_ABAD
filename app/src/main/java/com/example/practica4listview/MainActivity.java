package com.example.practica4listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView txtItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DATOS
        final String[] datos = new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};
        //ADAPTADOR
        ArrayAdapter<String> adaptador =new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, datos);

        //Enlazarlos A LA LISTA
        Spinner cmbOpciones = (Spinner)findViewById(R.id.cmbOpciones);//el combo opciones
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones.setAdapter(adaptador);
        //DECIRLE QUE LO EJECUTE EN LA CLASE PRINCIPAL, EN EL DISEÑO, PORQUE ESTAMOS USANDO SOLO UNO.
        //SI SE MOSTRARA EN OTRO DISEÑO, SE AGREGA EL NOMBRE
        //cmbOpciones.setOnItemSelectedListener(this);

        TextView txtItem =(TextView)findViewById(R.id.txtElemento);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //ME LO MUESTRE EN UN TEXTVIEW
        //CUANDO HA SELECCIONADO ALGO
        //TextView txtItem =(TextView)findViewById(R.id.txtElemento);
        txtItem.setText("Seleccionado: " +adapterView.getItemAtPosition(i));

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //CUANDO SE HA DEJADO DE SELECCIONAR ALGO
        //TextView txtItem =(TextView)findViewById(R.id.txtElemento);
        txtItem.setText("No ha seleccionado nada!");
    }
}