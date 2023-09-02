package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private String currentInput = "";
    private double currentResult = 0.0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.search_bar_text_view);
    }

    public void onNumberButtonClick(View view) {
        Button button = (Button) view;
        currentInput += button.getText().toString();
        resultTextView.setText(currentInput);
    }

    public void onOperatorButtonClick(View view) {
        Button button = (Button) view;
        String newOperator = button.getText().toString();

        if (!currentInput.isEmpty()) {
            if (!operator.isEmpty()) {
                calculateResult();
            }
            currentResult = Double.parseDouble(currentInput);
            currentInput = "";
            operator = newOperator;
        }
    }

    public void onEqualButtonClick(View view) {
        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            calculateResult();
            operator = "";
        }
    }

    public void onClearButtonClick(View view) {
        currentInput = "";
        currentResult = 0.0;
        operator = "";
        resultTextView.setText("0");
    }

    private void calculateResult() {
        double inputValue = Double.parseDouble(currentInput);

        switch (operator) {
            case "+":
                currentResult += inputValue;
                break;
            case "-":
                currentResult -= inputValue;
                break;
            case "X":
                currentResult *= inputValue;
                break;
            case "/":
                if (inputValue != 0) {
                    currentResult /= inputValue;
                } else {
                    resultTextView.setText("Error");
                    return;
                }
                break;
            case "%":
                currentResult = currentResult % inputValue;
                break;
        }

        currentInput = String.valueOf(currentResult);
        resultTextView.setText(currentInput);
    }
}