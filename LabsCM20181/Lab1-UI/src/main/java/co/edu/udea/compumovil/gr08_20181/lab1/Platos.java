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
private static String NAME_KEY = "name_key";
private static String HORARIO_KEY = "horario_key";
    private static String HORARIO1_KEY = "horario1_key";
    private static String HORARIO2_KEY = "horario2_key";
private static String TIPO_KEY = "tipo_key";
    private static String TIPO1_KEY = "tipo1_key";
private static String HORA_KEY = "hora_key";
private static String PRECIO_KEY = "precio_key";
private static String INGREDIENTE_KEY = "ingrediente_key";
EditText hora;
TextView textnombres, text, text4, text5, text1;
EditText nombres;
private int horas, minutos;
CheckBox cb1, cb2, cb3;
RadioButton rb1, rb2;
String x, y, z;
boolean x2,y2,z2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platos);

        button = (Button)findViewById(R.id.button);
        hora = (EditText)findViewById(R.id.hora);
        button.setOnClickListener(this);


        cb1 = (CheckBox)findViewById(R.id.mañana);
        cb2 = (CheckBox)findViewById(R.id.tarde);
        cb3 = (CheckBox)findViewById(R.id.noche);
        rb1 = (RadioButton)findViewById(R.id.tipoE);
        rb2 = (RadioButton)findViewById(R.id.tipoF);

        x = "";
        y = "";
        z = "";


        mostrartodo = (Button)findViewById(R.id.mostrar);
        textnombres = (TextView)findViewById(R.id.nombre);
        text = (TextView)findViewById(R.id.textnombre);
        text1 = (TextView)findViewById(R.id.ingredientes);
        text4 = (TextView)findViewById(R.id.hora);
        text5 = (TextView)findViewById(R.id.precio);



        mostrartodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x2 = y2 = z2 = false;
                x = "";
                y = "";


                text4.setText(text4.getText());
                text5.setText(text5.getText());
                text1.setText(text1.getText());
                if (rb1.isChecked()){
                    //text2.setText(rb1.getText());
                    x = rb1.getText().toString();


                }else if (rb2.isChecked()){
                    x = rb2.getText().toString();
                    //text2.setText(rb2.getText());
                }

                if(cb1.isChecked()){
                    /*text1.setText(cb1.getText());*/
                    x2 = true;
                }
                if (cb2.isChecked()){
                    /*text1.setText(cb2.getText());*/
                    y2 = true;
                }
                if (cb3.isChecked()){
                    /*text1.setText(cb3.getText());*/
                    z2 = true;
                }
                if(x2 && y2 && z2 ){
                    //text1.setText("Mañana, Tarde, Noche");
                    //text1.setText("Mañana, Tarde, Noche");
                    y = "Mañana, Tarde, Noche";
                } else if(x2 && y2){
                    y = "Mañana, Tarde";
                }else if(y2 && z2){
                    y = "Tarde, Noche";
                }else  if(x2 && z2){
                    y = "Mañama, Noche";
                }else if(x2){
                    y = "Mañana";
                }else if(y2){
                    y = "Tarde";
                }else if (z2){
                    y = "Noche";
                }else{
                    y = "";
                }
                text.setText(textnombres.getText().toString()+"\n" + y +"\n" + x +"\n"+ text4.getText().toString() +"\n"+ text5.getText().toString()+"\n"+ text1.getText().toString());

            }

        });
        if (savedInstanceState != null) {
            textnombres.setText(savedInstanceState.getString(NAME_KEY));
            cb1.setChecked(savedInstanceState.getBoolean(HORARIO_KEY));
            cb2.setChecked(savedInstanceState.getBoolean(HORARIO1_KEY));
            cb3.setChecked(savedInstanceState.getBoolean(HORARIO2_KEY));
            rb1.setChecked(savedInstanceState.getBoolean(TIPO_KEY));
            text4.setText(savedInstanceState.getString(HORA_KEY));
            text5.setText(savedInstanceState.getString(PRECIO_KEY));
            text1.setText(savedInstanceState.getString(INGREDIENTE_KEY));
        }
    }
        /*public void onCheckboxClicked(View view) {
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
        }*/

    /*public void onRadioButtonClicked(View view) {
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
    }*/


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



    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //super.onRestoreInstanceState(savedInstanceState);
        textnombres.setText(savedInstanceState.getString(NAME_KEY));
        cb1.setChecked(savedInstanceState.getBoolean(HORARIO_KEY));
        cb2.setChecked(savedInstanceState.getBoolean(HORARIO1_KEY));
        cb3.setChecked(savedInstanceState.getBoolean(HORARIO2_KEY));
        rb1.setChecked(savedInstanceState.getBoolean(TIPO_KEY));
        rb2.setChecked(savedInstanceState.getBoolean(TIPO1_KEY));
        text4.setText(savedInstanceState.getString(HORA_KEY));
        text5.setText(savedInstanceState.getString(PRECIO_KEY));
        text1.setText(savedInstanceState.getString(INGREDIENTE_KEY));
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(NAME_KEY, textnombres.getText().toString());
        outState.putBoolean(HORARIO_KEY, cb1.isChecked());
        outState.putBoolean(HORARIO1_KEY, cb2.isChecked());
        outState.putBoolean(HORARIO2_KEY, cb3.isChecked());
        outState.putBoolean(TIPO_KEY, rb1.isChecked());
        outState.putBoolean(TIPO1_KEY, rb2.isChecked());
        outState.putString(HORA_KEY, text4.getText().toString());
        outState.putString(PRECIO_KEY, text5.getText().toString());
        outState.putString(INGREDIENTE_KEY, text1.getText().toString());
        super.onSaveInstanceState(outState);
    }

}
