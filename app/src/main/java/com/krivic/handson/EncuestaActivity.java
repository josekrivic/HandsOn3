package com.krivic.handson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;

public class EncuestaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);

        //OCULTAR TECLADO EN EDITEX Y DESPUES HACER CLICK Y MOSTRAR
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.FIRST_APPLICATION_WINDOW);

    }

    /////////Abre la pantalla de Registro//////////
    public void OpenInicioActivity(View view){
        Intent i=new Intent(this,InicioActivity.class);
        startActivity(i);




    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.checkMuybueno1:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.checkBueno1:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.checkRegular1:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.checkMalo1:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.checkMuymalo1:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}
