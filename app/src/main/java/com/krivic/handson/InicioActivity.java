package com.krivic.handson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class InicioActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
    }

    public void onClick(View view){

        Intent i = new Intent(this, RegistroActivity.class);
        startActivity(i);
    }

    public void onListar(View view){
        Intent i = new Intent(this, ConsultaActivity.class);
        startActivity(i);
    }

    /*public void onEliminar(View view){
        Intent i = new Intent(this, eliminar.class);
        startActivity(i);
    }*/

    public void premodificar(View view){
        Intent i = new Intent(this, PreModificarActivity.class);
        startActivity(i);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    /////CODIGO PROPIO////////////////

    /////////Abre la pantalla de Registro//////////
    public void OpenRegistroActivity(View view){
        Intent i=new Intent(this,RegistroActivity.class);
        startActivity(i);
    }

    /////////Abre la pantalla de Tratamientos//////////
    public void OpenTratamientoActivity(View view){
        Intent j=new Intent(this,TratamientoActivity.class);
        startActivity(j);
    }


    /////////Abre la pantalla de Encuesta//////////
    public void OpenEncuestaActivity(View view){
        Intent h=new Intent(this,EncuestaActivity.class);
        startActivity(h);
    }

    public void OpenConsultaActivity(View view){
        Intent h=new Intent(this,ConsultaActivity.class);
        startActivity(h);
    }


}
