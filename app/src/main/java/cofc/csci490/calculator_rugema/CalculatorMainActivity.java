package cofc.csci490.calculator_rugema;

import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

public class CalculatorMainActivity extends AppCompatActivity {

    //define instance variables for widgets
    private Button clear, clearall, numberBtn0, equalBtn, numberBtn1,numberBtn2,numberBtn3;
    private Button numberBtn4, numberBtn5,numberBtn6,numberBtn7,numberBtn8,numberBtn9;
    private Button plusBtn, minusBtn, multBtn, divBtn, decimalPtBtn, plusMinus;
    private TextView resultText;
    private String operationSign = "";
    private String total = "";
    private final static String SAVED_VAL = "savedVal";
    private final static String SAVED_VAL2 = "savedVal2";
    private final static String SAVED_VAL3 = "savedVal3";
    private final static String SAVED_VAL4 = "savedVal4";
    private Double resultNum1, resultNum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_main);

        //wire the widgets, buttons and text view
        clear = (Button) findViewById(R.id.btnClear);
        resultText = (TextView) findViewById(R.id.resultTextView);
        clearall = (Button) findViewById(R.id.btnClearAll);
        plusBtn = (Button) findViewById(R.id.btnPlus);
        plusMinus = (Button) findViewById(R.id.btnPlusMinus);
        equalBtn = (Button) findViewById(R.id.btnEqual);
        minusBtn = (Button) findViewById(R.id.btnMinus);
        multBtn = (Button) findViewById(R.id.btnMultiplication);
        divBtn = (Button) findViewById(R.id.btnDivButton);
        decimalPtBtn = (Button) findViewById(R.id.btnDecimalSign);
        numberBtn0 = (Button) findViewById(R.id.btnNumber0);
        numberBtn1 = (Button) findViewById(R.id.btnNumber1);
        numberBtn2 = (Button) findViewById(R.id.btnNumber2);
        numberBtn3 = (Button) findViewById(R.id.btnNumber3);
        numberBtn4 = (Button) findViewById(R.id.btnNumber4);
        numberBtn5 = (Button) findViewById(R.id.btnNumber5);
        numberBtn6 = (Button) findViewById(R.id.btnNumber6);
        numberBtn7 = (Button) findViewById(R.id.btnNumber7);
        numberBtn8 = (Button) findViewById(R.id.btnNumber8);
        numberBtn9 = (Button) findViewById(R.id.btnNumber9);

        if (savedInstanceState != null){
            resultNum1 = savedInstanceState.getDouble(SAVED_VAL2);
            resultNum2 = savedInstanceState.getDouble(SAVED_VAL3);
            operationSign = savedInstanceState.getString(SAVED_VAL4);
        }

        //set button event handlers
        numberBtn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.append("0");
            }
        });

        numberBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.append("1");
            }
        });

        numberBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.append("2");
            }
        });

        numberBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.append("3");
            }
        });

        numberBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.append("4");
            }
        });
        numberBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.append("5");
            }
        });

        numberBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.append("6");
            }
        });

        numberBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.append("7");
            }
        });

        numberBtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.append("8");
            }
        });

        numberBtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.append("9");
            }
        });

        decimalPtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.append(".");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strVal = resultText.getText().toString();
                strVal.split(strVal);

                Character val = strVal.charAt(strVal.length()-1);
                resultText.setText(val.toString());
            }
        });

        clearall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.setText("");
            }
        });

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultNum1 = Double.parseDouble(resultText.getText().toString());
                resultText.setText("");
                operationSign ="+";
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultNum1 = Double.parseDouble(resultText.getText().toString());
                resultText.setText("");
                operationSign ="-";
            }
        });

        multBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultNum1 = Double.parseDouble(resultText.getText().toString());
                resultText.setText("");
                operationSign ="*";
            }
        });

        plusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.setText("-" + resultText.getText());
            }
        });

        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultNum1 = Double.parseDouble(resultText.getText().toString());
                resultText.setText("");
                operationSign ="/";
            }
        });

        equalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TextView resOutput = (TextView) findViewById(R.id.resultTextView);
                resultNum2 = Double.parseDouble(resultText.getText().toString());

                if (operationSign.equals("+")){
                    total = Double.toString(resultNum1 + resultNum2);
                    resultText.setText(total);
                } else if (operationSign.equals("-")){
                    total = Double.toString(resultNum1 - resultNum2);
                    resultText.setText(total);
                } else if (operationSign.equals("*")){
                    total = Double.toString(resultNum1 * resultNum2);
                    resultText.setText(total);
                } else if (operationSign.equals("/")){
                    if (resultNum2 == 0){
                        resultText.setText("Div/0");
                    }else {
                        total = Double.toString(resultNum1 / resultNum2);
                        resultText.setText(total);
                    }
                }
                operationSign = "";
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putDouble(SAVED_VAL2,resultNum1);
        outState.putDouble(SAVED_VAL3,resultNum2);
        outState.putString(SAVED_VAL4,operationSign);
        outState.putString(SAVED_VAL, resultText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.getDouble(SAVED_VAL3);
        savedInstanceState.getDouble(SAVED_VAL2);
        savedInstanceState.getString(SAVED_VAL4);
        resultText.setText(savedInstanceState.getString(SAVED_VAL));
    }

}
