package co.edu.udea.compumovil.gr08_20181.lab1;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Platos extends AppCompatActivity implements View.OnClickListener {
Button button,mostrartodo;
EditText hora;
TextView textnombres;
EditText nombres;
private int horas, minutos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platos);

        button = (Button)findViewById(R.id.button);
        hora = (EditText)findViewById(R.id.hora);
        button.setOnClickListener(this);

        mostrartodo = (Button)findViewById(R.id.mostrar);
        textnombres = (TextView)findViewById(R.id.nombre);

        mostrartodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(mostrartodo.isClickable()){
                   textnombres.setText(textnombres.getText());
               }
            }
        });
    }
        public void onCheckboxClicked(View view) {
            // Is the view now checked?
            boolean checked = ((CheckBox) view).isChecked();
            // Check which checkbox was clicked
            switch(view.getId()) {
                case R.id.mañana:
                    if (checked) {
                        // Put some meat on the sandwich
                    }else
                    // Remove the meat
                    break;
                case R.id.tarde:
                    if (checked) {
                        // Cheese me
                    }else
                    // I'm lactose intolerant
                    break;
                // TODO: Veggie sandwich
                case R.id.noche:
                    if (checked) {
                        // Cheese me
                    }else
                    // I'm lactose intolerant
                    break;
            }
        }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.tipoE:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.tipoF:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }


    @Override
    public void onClick(View V) {
        if (V==button){
            final Calendar c = Calendar.getInstance();
            horas = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    hora.setText(hourOfDay+":"+minute);
                }
            },horas,minutos,false);
            timePickerDialog.show();
        }
    }
}
