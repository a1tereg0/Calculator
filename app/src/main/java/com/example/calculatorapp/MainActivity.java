package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnAdd, btnSub, btnMul, btnDiv;
    Button btnDot, btnClr, btnEql, btnDel;
    TextView textResult;
    Double value1, value2;
    enum ACTIONS {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    }
    ACTIONS action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = (Button) findViewById(R.id.button_zero);
        btn1 = (Button) findViewById(R.id.button_one);
        btn2 = (Button) findViewById(R.id.button_two);
        btn3 = (Button) findViewById(R.id.button_three);
        btn4 = (Button) findViewById(R.id.button_four);
        btn5 = (Button) findViewById(R.id.button_five);
        btn6 = (Button) findViewById(R.id.button_six);
        btn7 = (Button) findViewById(R.id.button_seven);
        btn8 = (Button) findViewById(R.id.button_eight);
        btn9 = (Button) findViewById(R.id.button_nine);

        textResult = (TextView) findViewById(R.id.show_result);

        btnAdd = (Button) findViewById(R.id.button_plus);
        btnSub = (Button) findViewById(R.id.button_minus);
        btnMul = (Button) findViewById(R.id.button_multiplication);
        btnDiv = (Button) findViewById(R.id.button_division);

        btnDot = (Button) findViewById(R.id.button_decimal);
        btnClr = (Button) findViewById(R.id.button_clear);
        btnEql = (Button) findViewById(R.id.button_equality);
        btnDel = (Button) findViewById(R.id.button_delete);

        btnClr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textResult.setText(null);
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textResult.setText(String.format("%s0", textResult.getText()));
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textResult.setText(String.format("%s1", textResult.getText()));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textResult.setText(String.format("%s2", textResult.getText()));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textResult.setText(String.format("%s3", textResult.getText()));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textResult.setText(String.format("%s4", textResult.getText()));
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textResult.setText(String.format("%s5", textResult.getText()));
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textResult.setText(String.format("%s6", textResult.getText()));
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textResult.setText(String.format("%s7", textResult.getText()));
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textResult.setText(String.format("%s8", textResult.getText()));
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                textResult.setText(String.format("%s9", textResult.getText()));
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(!textResult.getText().toString().contains("."))
                    textResult.setText(String.format("%s.", textResult.getText()));
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String enteredNumber = textResult.getText().toString();
                if (enteredNumber != null && enteredNumber.length() > 0) {
                    enteredNumber = enteredNumber.substring(0, enteredNumber.length() - 1);
                }
                textResult.setText(enteredNumber);

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    value1 = Double.parseDouble(textResult.getText().toString());
                } catch (Exception e) {
                    return;
                }

                textResult.setText(null);
                action = ACTIONS.ADD;
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    value1 = Double.parseDouble(textResult.getText().toString());
                } catch (Exception e) {
                    return;
                }
                textResult.setText(null);
                action = ACTIONS.SUBTRACT;
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    value1 = Double.parseDouble(textResult.getText().toString());
                } catch (Exception e) {
                    return;
                }
                textResult.setText(null);
                action = ACTIONS.MULTIPLY;
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    value1 = Double.parseDouble(textResult.getText().toString());
                } catch (Exception e) {
                    return;
                }
                textResult.setText(null);
                action = ACTIONS.DIVIDE;
            }
        });

        btnEql.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                    double result = 0.0;
                    try {
                        value2 = Double.parseDouble(textResult.getText().toString());
                    } catch (Exception e) {
                        return;
                    }
                    if (value1 == null || value2 == null) return;
                    switch (action) {
                        case ADD:
                            result = value1 + value2;
                            break;
                        case SUBTRACT:
                            result = value1 - value2;
                            break;
                        case MULTIPLY:
                            result = value1 * value2;
                            break;
                        case DIVIDE:
                            result = value1 / value2;
                            break;
                    }
                    String resultText = String.format("%s", result);
                    if (resultText.endsWith(".0")) {
                        resultText = resultText.replace(".0", "");
                    }
                    textResult.setText(resultText);

            }
        });

    }
}
