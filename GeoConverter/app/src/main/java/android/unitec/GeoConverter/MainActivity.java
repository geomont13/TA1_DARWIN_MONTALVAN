package android.unitec.GeoConverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.view.View;
import android.view.Gravity;
import android.widget.Toast;
import android.view.LayoutInflater;



public class MainActivity extends AppCompatActivity{
    private Spinner Menu1, Menu2;
    private EditText Edit_Valor1,Edit_valor2;
    private Button btn_Limpiar;
    float C,F,K,Ra,res;
    String Valores1,Valores2;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Edit_Valor1 = (EditText) findViewById(R.id.editText_valor1);
        Edit_valor2 = (EditText) findViewById(R.id.editText_Valor2);
        btn_Limpiar = (Button) findViewById(R.id.btnLimpiar);



        final String[] datos =
                new String[]{"Seleccione el Grado", "Celsius", "Fahrenheit", "Kelvin", "Rankine"};
        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, datos);

        Menu1 = (Spinner) findViewById(R.id.spinner_Menu1);
        Menu2 = (Spinner) findViewById(R.id.spinner_Menu2);
        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        Menu1.setAdapter(adaptador);
        Menu2.setAdapter(adaptador);

        btn_Limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Edit_Valor1.setText("");
                Edit_valor2.setText("");
            }
        });

        Menu1.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {
                        Valores1 = datos[position];
                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

        Menu2.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {
                        Valores2 = datos[position];
                        if(Valores2 == "Seleccione el Grado" && Valores1 == "Seleccione el Grado"){

                        }else{
                            if(Valores1 == "Seleccione el Grado"){
                                Mensaje();
                            }else {
                                String vacio = Edit_Valor1.getText().toString();
                                if (vacio.equals("")) {
                                    MensajeInconToast(R.layout.toast, Toast.LENGTH_LONG);
                                    Edit_Valor1.requestFocus();
                                } else {
                                    if (Valores1 == "Celsius" && Valores2 == "Fahrenheit") {

                                        C = Float.parseFloat(Edit_Valor1.getText().toString());
                                        res = (C * 1.8f) + 32;

                                        String resultado = String.valueOf(res);
                                        Edit_valor2.setText(resultado);
                                    }
                                    if (Valores1 == "Fahrenheit" && Valores2 == "Celsius") {
                                        F = Float.parseFloat((Edit_Valor1.getText().toString()));

                                        res = (F - 32) / 1.8f;
                                        String resultado = String.valueOf(res);
                                        Edit_valor2.setText(resultado);
                                    }
                                    if(Valores1 == "Celsius" && Valores2 == "Kelvin"){

                                        C = Float.parseFloat(Edit_Valor1.getText().toString());
                                        res = (C  + 273.15f);
                                        String resultado = String.valueOf(res);
                                        Edit_valor2.setText(resultado);
                                    }
                                    if(Valores1 == "Kelvin" && Valores2 == "Celsius"){

                                        K = Float.parseFloat(Edit_Valor1.getText().toString());
                                        res = (K  - 273.15f);
                                        String resultado = String.valueOf(res);
                                        Edit_valor2.setText(resultado);
                                    }
                                    if(Valores1 == "Celsius" && Valores2 == "Rankine"){

                                        C = Float.parseFloat(Edit_Valor1.getText().toString());
                                        res = (C  + 1.8000f) + 491.67f;
                                        String resultado = String.valueOf(res);
                                        Edit_valor2.setText(resultado);
                                    }
                                    if(Valores1 == "Rankine" && Valores2 == "Celsius") {

                                        Ra = Float.parseFloat(Edit_Valor1.getText().toString());
                                        res = (Ra - 491.67f) + 1.8000f;
                                        String resultado = String.valueOf(res);
                                        Edit_valor2.setText(resultado);
                                    }
                                    //Rankine
                                    if(Valores1 == "Fahrenheit" && Valores2 == "Rankine"){

                                        F = Float.parseFloat(Edit_Valor1.getText().toString());
                                        res = (F  - 491.67f) + 32;
                                        String resultado = String.valueOf(res);
                                        Edit_valor2.setText(resultado);
                                    }
                                    if(Valores1 == "Rankine" && Valores2 == "Fahrenheit") {

                                        Ra = Float.parseFloat(Edit_Valor1.getText().toString());
                                        res = (Ra - 32f) + 491.67f;
                                        String resultado = String.valueOf(res);
                                        Edit_valor2.setText(resultado);
                                    }
                                    if(Valores1 == "Kalvin" && Valores2 == "Rankine"){

                                        K = Float.parseFloat(Edit_Valor1.getText().toString());
                                        res = ((K  + 273.15f) * 1.8000f) + 491.67f;
                                        String resultado = String.valueOf(res);
                                        Edit_valor2.setText(resultado);
                                    }
                                    if(Valores1 == "Fahrenheit" && Valores2 == "Kalvin") {

                                        F = Float.parseFloat(Edit_Valor1.getText().toString());
                                        res = ((F - 32) / 1.8000f)+273.15f;
                                        String resultado = String.valueOf(res);
                                        Edit_valor2.setText(resultado);
                                    }
                                    if(Valores1 == "Kalvin" && Valores2 == "Fahrenheit") {

                                        K = Float.parseFloat(Edit_Valor1.getText().toString());
                                        res = ((K + 273.15f) * 1.8000f) + 32;
                                        String resultado = String.valueOf(res);
                                        Edit_valor2.setText(resultado);
                                    }


                                }
                            }
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

    }

    private void MensajeInconToast(int layout, int duration){

        LayoutInflater inflater = getLayoutInflater();
        View layoutView = inflater.inflate(layout, null);

        Toast toast = new Toast(getApplicationContext());

        toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);

        toast.setDuration(Toast.LENGTH_LONG);
        toast.setDuration(duration);
        toast.setView(layoutView);
        toast.show();

    }
    public void Mensaje(){
        Toast toast = Toast.makeText(this, "Seleccione un Grado", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }



}
