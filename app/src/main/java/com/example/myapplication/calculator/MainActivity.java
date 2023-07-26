package com.example.myapplication.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;

public class MainActivity extends AppCompatActivity {

    // Declare buttons and text views for the calculator interface
    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0;
    Button btn_dot, btn_equal, btn_ac, btn_module, btn_plus, btn_minus, btn_multiplication, btn_square;
    Button btn_del;
    TextView inputTxt, outPuttxt;
    String data; // Variable to store the current input data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a click listener for all number buttons
        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Append the clicked number to the input text
                String data = inputTxt.getText().toString();
                inputTxt.setText(data + ((TextView) view).getText());
            }
        };

        // Find and assign UI elements to their corresponding variables
        outPuttxt = findViewById(R.id.outPuttxt);
        inputTxt = findViewById(R.id.inputTxt);

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);

        btn_dot = findViewById(R.id.btn_dot);
        btn_del = findViewById(R.id.btn_del);
        btn_equal = findViewById(R.id.btn_equal);
        btn_ac = findViewById(R.id.btn_ac);
        btn_module = findViewById(R.id.btn_module);
        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_multiplication = findViewById(R.id.btn_multiplication);
        btn_square = findViewById(R.id.btn_square);

        // Set individual click listeners for each number button
        // Each button appends its respective number to the input text when clicked
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "9");
            }
        });

        // Clear button (AC) click listener
        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear both input and output text fields
                inputTxt.setText("");
                outPuttxt.setText("");
            }
        });

        // Delete button (DEL) click listener
        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentText = inputTxt.getText().toString();
                if (currentText.length() > 0){
                    // Remove the last character from the input text
                    currentText = currentText.substring(0, currentText.length() - 1);
                    inputTxt.setText(currentText);
                }
            }
        });

        // Decimal point (.) button click listener
        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + ".");
            }
        });

        // Mathematical operation buttons (+, -, *, /, %) click listeners
        // Each button appends its respective operation symbol to the input text when clicked
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "+");
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "-");
            }
        });

        btn_module.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "%");
            }
        });

        btn_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();
                inputTxt.setText(data + "×");
            }
        });

        // Square button (^2) click listener
        btn_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Calculate the square of the entered number and display the result
                String data = inputTxt.getText().toString();
                if (!data.isEmpty()) {
                    double number = Double.parseDouble(data);
                    double square = number * number;
                    outPuttxt.setText(String.valueOf(square));
                }
            }
        });

        // Equal button (=) click listener
        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputTxt.getText().toString();

                // Replace the symbols for multiplication (×), division (÷), and percentage (%) with appropriate symbols for JavaScript evaluation
                data=data.replaceAll("×","*");
                data=data.replaceAll("%","/100");
                data=data.replaceAll("÷","/");


                // Evaluate the mathematical expression using JavaScript engine (Rhino)
                //Only use this context org.mozilla.javascript.Context
                //don't use Context.android.os
                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult="";

                ScriptableObject scriptable=rhino.initStandardObjects();
                finalResult=rhino.evaluateString(scriptable,data,"Javsscript",1,null).toString();

                // Display the result of the expression evaluation
                outPuttxt.setText(finalResult);

            }
        });

    }
}