package com.krivic.handson;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ModificarActivity extends ActionBarActivity implements RadioGroup.OnCheckedChangeListener {

    MyDBHandler dbHandler;
    EditText nombre_input;
    EditText apellido_input;
    EditText dni_input;         /// se modifico edad por dni
    EditText telefono_input;
    EditText email_input;
    EditText motivo_input;
    TextView user_gender;
    //EditText sangre_input;
    /*radiobutton*/
    //RadioButton check_desestresarce;      //se agrego radiobutton
    //RadioButton check_aliviar;      //se agrego radiobutton
    //RadioButton check_reducir;   //se agrego radiobutton

    int idglobal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Aqui se hace el retrieve de la base de datos tomando un valor que viene en el intent anterior

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        nombre_input = (EditText) findViewById(R.id.nombre_input);
        apellido_input = (EditText) findViewById(R.id.apellido_input);
        dni_input = (EditText) findViewById(R.id.dni_input);            // se modifico edad por dni
        telefono_input = (EditText) findViewById(R.id.telefono_input);
        email_input = (EditText) findViewById(R.id.email_input);
        motivo_input = (EditText) findViewById(R.id.motivo_input);

        //declaro los radiogroup y radiobutton para registro
        //check_desestresarce = (RadioButton)findViewById(R.id.check_desestresarce);   //se agrego radiobutton
        //check_aliviar = (RadioButton)findViewById(R.id.check_aliviar);              //se agrego radiobutton
        //check_reducir = (RadioButton)findViewById(R.id.check_reducir);           //se agrego radiobutton
        //sangre_input = (EditText) findViewById(R.id.sangre_input);
        dbHandler = new MyDBHandler(this, null, null, 1);
        Personas persona = new Personas(nombre_input.getText().toString(), apellido_input.getText().toString(), Integer.parseInt(dni_input.getText().toString()), telefono_input.getText().toString(), email_input.getText().toString(), motivo_input.getText().toString(),user_gender.toString());


        Intent i = getIntent(); // gets the previously created intent
        String stringid = i.getStringExtra("id_persona");
        int id = Integer.parseInt(stringid);
        Cursor c = dbHandler.personabyid(id);

        //Vuelve a rellenar los inputs con los valores del cursor
        nombre_input.setText(c.getString(c.getColumnIndexOrThrow("nombre")));
        apellido_input.setText(c.getString(c.getColumnIndexOrThrow("apellido")));
        dni_input.setText(c.getString(c.getColumnIndexOrThrow("dni")));             //se modifico edad por dni
        telefono_input.setText(c.getString(c.getColumnIndexOrThrow("telefono")));
        email_input.setText(c.getString(c.getColumnIndexOrThrow("email")));
        motivo_input.setText(c.getString(c.getColumnIndexOrThrow("motivo")));



        //declaro los radiogroup y radiobutton para registro
        //check_desestresarce.setText(c.getString(c.getColumnIndexOrThrow("desestresarce")));
        //check_aliviar.setText(c.getString(c.getColumnIndexOrThrow("aliviar")));
        //check_reducir.setText(c.getString(c.getColumnIndexOrThrow("reducir")));


        //sangre_input.setText(c.getString(c.getColumnIndexOrThrow("tiposangre")));
        idglobal = c.getInt(c.getColumnIndexOrThrow("_id"));

   }

    public void modificar_clicked(View view){

        Personas persona = new Personas(nombre_input.getText().toString(),
                apellido_input.getText().toString(),
                Integer.parseInt(dni_input.getText().toString()),
                telefono_input.getText().toString(),
                email_input.getText().toString(),
                motivo_input.getText().toString(),
                user_gender.toString()

                );
                                            /*Radio buttons y radiogroup*/
                //check_desestresarce.getText().toString(),
                //check_aliviar.getText().toString(),
                //check_reducir.getText().toString()
                // se borro /*, sangre_input.getText().toString()
        dbHandler.addPersona(persona);
        confirmacion();
        limpiarcampos();
    }

    public void confirmacion(){

        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Se ha modificado exitosamente!");
        dlgAlert.setTitle("Agregar Persona");
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //dismiss the dialog
                    }
                });
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }

    public void RadioButtonClicked(View view) {

//This variable will store whether the user was male or female
        String user_gender = "";
// Check that the button is  now checked?
        boolean checked = ((RadioButton) view).isChecked();

// Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_female:
                if (checked)
                    user_gender = "female";
                break;
            case R.id.radio_male:
                if (checked)
                    user_gender = "male";
                break;
        }
    }
    //Limpia los valores entrados para efectos de estetica
    public void limpiarcampos(){

        nombre_input.setText("");
        apellido_input.setText("");
        dni_input.setText("");      //se cambio edad por dni
        telefono_input.setText("");
        email_input.setText("");
        motivo_input.setText("");
        //sangre_input.setText("");
        /*Radio buttons y radiogroup*/
       // check_desestresarce.setText("");
        //check_aliviar.setText("");
        //check_reducir.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modificar, menu);
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
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

    }
}
