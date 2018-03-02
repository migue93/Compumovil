package co.edu.udea.compumovil.gr08_20181.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Kokoriko extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kokoriko);


        ImageButton Ibutton = (ImageButton) findViewById(R.id.platos);
        Ibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do something in response to button click
                Intent Ibutton = new Intent(Kokoriko.this, Platos.class);
                startActivity(Ibutton);
            }
        });


        ImageButton I2button = (ImageButton) findViewById(R.id.bebidas);
        I2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do something in response to button click
                Intent I2button = new Intent(Kokoriko.this, Bebidas.class);
                startActivity(I2button);
            }
        });
    }
}