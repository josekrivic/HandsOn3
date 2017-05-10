
package com.krivic.handson;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static com.krivic.handson.R.id.radio_female;
import static com.krivic.handson.R.id.radio_male;

/**
 * Created by Emilio on 29/11/2016.
 */

public class RegistroActivity extends ActionBarActivity implements RadioGroup.OnCheckedChangeListener {

    MyDBHandler dbHandler;
    EditText nombre_input;
    EditText apellido_input;
    EditText dni_input;         ///se cambio edad por dni
    EditText telefono_input;
    EditText email_input;
    EditText motivo_input;
    String sexo;

       //EditText sangre_input;


    //declaro los radiogroup y radiobutton para registro
    /*RadioButton check_desestresarce;
    RadioButton check_aliviar;
    RadioButton check_reducir;
    RadioGroup check_motivo;*/

    //RadioButton radio_male;
    //RadioButton radio_female;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nombre_input = (EditText) findViewById(R.id.nombre_input);
        apellido_input = (EditText) findViewById(R.id.apellido_input);
        dni_input = (EditText) findViewById(R.id.dni_input); ///se cambio edad por dni
        telefono_input = (EditText) findViewById(R.id.telefono_input);
        email_input = (EditText) findViewById(R.id.email_input);
        motivo_input = (EditText) findViewById(R.id.motivo_input);
        //radio_female = (RadioButton) findViewById(radio_female);
        //radio_male = (RadioButton) findViewById(radio_male);

        //sangre_input = (EditText) findViewById(R.id.sangre_input);


        //declaro los radiogroup y radiobutton para registro
       // check_desestresarce = (RadioButton) findViewById(R.id.check_desestresarce);
        //check_aliviar = (RadioButton) findViewById(R.id.check_aliviar);
        //check_reducir = (RadioButton) findViewById(R.id.check_reducir);
        //check_motivo = (RadioGroup) findViewById(R.id.check_motivo);

        dbHandler = new MyDBHandler(this, null, null, 1);

        //OCULTAR TECLADO EN EDITEX Y DESPUES HACER CLICK Y MOSTRAR
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.FIRST_APPLICATION_WINDOW);



    }


    /////////Abre la pantalla de Registro//////////
    public void OpenInicioActivity(View view) {
        Intent i = new Intent(this, InicioActivity.class);
        startActivity(i);
    }


    //Añade una Persona a la Base de Datos

    public void agregar_clicked(View view) {



        Personas persona = new Personas(nombre_input.getText().toString(),
                apellido_input.getText().toString(),
                Integer.parseInt(dni_input.getText().toString()),
                telefono_input.getText().toString(),
                email_input.getText().toString(),
                motivo_input.getText().toString(),
                sexo.toString()
                /*Radio buttons y radiogroup*/
                /*check_desestresarce.getText().toString(),
                check_aliviar.getText().toString(),
                check_reducir.getText().toString(),
                check_motivo.getCheckedRadioButtonId()*/); // se borro /*, sangre_input.getText().toString()
        dbHandler.addPersona(persona);
        confirmacion();
        limpiarcampos();




    }



    //Limpia los valores entrados para efectos de estetica
    public void limpiarcampos() {

        nombre_input.setText("");
        apellido_input.setText("");
        dni_input.setText("");      //se cambio edad por dni
        telefono_input.setText("");
        email_input.setText("");
        motivo_input.setText("");

        //sangre_input.setText("");
        /*Radio buttons y radiogroup*/
        /*check_desestresarce.setText("");
        check_aliviar.setText("");
        check_reducir.setText("");*/

    }


       public void confirmacion() {

        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Se guardo exitosamente!");
        dlgAlert.setTitle("Gracias");
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //dismiss the dialog
                    }
                });
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }



    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {


    }
    public void RadioButtonClicked(View view) {

//This variable will store whether the user was male or female
        sexo = "";
// Check that the button is  now checked?
        boolean checked = ((RadioButton) view).isChecked();

// Check which radio button was clicked
        switch (view.getId()) {
            case radio_female:
                if (checked)
                    sexo = "female";
                break;
            case radio_male:
                if (checked)
                    sexo = "male";
                break;
        }
    }


}
