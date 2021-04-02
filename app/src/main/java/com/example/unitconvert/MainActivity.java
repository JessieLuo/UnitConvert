package com.example.unitconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner unit;
    private EditText input;
    private TextView output1, output2, output3;
    private ImageButton convertLengthButton, convertTemperatureButton, convertWeightButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unit = findViewById(R.id.unitList);
        input = findViewById(R.id.inputNumber);
        output1 = findViewById(R.id.resultView1);
        output2 = findViewById(R.id.resultView2);
        output3 = findViewById(R.id.resultView3);
        convertLengthButton = findViewById(R.id.convertLength);
        convertTemperatureButton = findViewById(R.id.convertTemperature);
        convertWeightButton = findViewById(R.id.convertWeight);

        //when click spinner item, remove all textView data
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.UnitArray, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        unit.setAdapter(adapter);
        unit.setOnItemSelectedListener(this);

        //add onClick event for button
        convertLengthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertFromMetre();
            }
        });
        convertTemperatureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertFromCelsius();
            }
        });
        convertWeightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calling convert from kilogram to other three value
                convertFromKilo();
            }
        });
    }

    //Methods
    //spinner selected listener
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        output1.setText("");
        output2.setText("");
        output3.setText("");
        //This is not implement successful requirement. Not have enough knowledge to complete bind spinner and onClick event.
        // String text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //onClick listener for length, temperature, weight buttons
    public void convertFromMetre() {
        String inputValue = input.getText().toString();
        //convert the string to number
        double Metre = Double.parseDouble(inputValue);
        double centimetre = Metre * 100;
        double foot = Metre * 3.281;
        double inch = Metre * 39.37;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        //display the result
        output1.setText(decimalFormat.format(centimetre) + " centimetres");
        output2.setText(decimalFormat.format(foot) + " foot");
        output3.setText(decimalFormat.format(inch) + " inch");
    }
    public void convertFromCelsius() {
        String inputValue = input.getText().toString();
        //convert the string to number
        double Celsius = Double.parseDouble(inputValue);
        double fahrenheit = Celsius * 33.8;
        double kelvin = Celsius * 274.15;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        //display the result
        output1.setText(decimalFormat.format(fahrenheit) + " fahrenheit" );
        output2.setText(decimalFormat.format(kelvin) + " kelvin");
    }
    public void convertFromKilo() {
        String inputValue = input.getText().toString();
        //convert the string to number
        double Kilo = Double.parseDouble(inputValue);
        double pounds = Kilo * 2.205;
        double gram = Kilo * 1000;
        double ounce = Kilo * 35.274;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        //display the result
        output1.setText(decimalFormat.format(pounds) + " pounds" );
        output2.setText(decimalFormat.format(gram) + " gram");
        output3.setText(decimalFormat.format(ounce) + " ounce");
    }
}