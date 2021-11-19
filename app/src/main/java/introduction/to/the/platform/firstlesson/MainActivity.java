package introduction.to.the.platform.firstlesson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView displayTextView;
    public static final String NameSharedPreference = "LOGIN";
    private static final String AppTheme = "APP_THEME";

    Calc calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ChooseThemeActivity chooseThemeActivity = new ChooseThemeActivity();
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        setTheme(chooseThemeActivity.codeStyleToStyleResId(sharedPref.getInt(AppTheme, 0)));
        setContentView(R.layout.activity_main2);

        displayTextView = findViewById(R.id.textViewDisplayText);

        findViewById(R.id.buttonClearDisplay).setOnClickListener(v -> displayTextView.setText(""));
        findViewById(R.id.buttonDigit1).setOnClickListener(v -> displayTextView.append("1"));
        findViewById(R.id.buttonDigit2).setOnClickListener(v -> displayTextView.append("2"));
        findViewById(R.id.buttonDigit3).setOnClickListener(v -> displayTextView.append("3"));
        findViewById(R.id.buttonDigit4).setOnClickListener(v -> displayTextView.append("4"));
        findViewById(R.id.buttonDigit5).setOnClickListener(v -> displayTextView.append("5"));
        findViewById(R.id.buttonDigit6).setOnClickListener(v -> displayTextView.append("6"));
        findViewById(R.id.buttonDigit7).setOnClickListener(v -> displayTextView.append("7"));
        findViewById(R.id.buttonDigit8).setOnClickListener(v -> displayTextView.append("8"));
        findViewById(R.id.buttonDigit9).setOnClickListener(v -> displayTextView.append("9"));
        findViewById(R.id.buttonDigit0).setOnClickListener(v -> displayTextView.append("0"));

        calc = new Calc();
        findViewById(R.id.buttonDotInDecimal).setOnClickListener(v -> {
            calc.setDecimal(displayTextView);
        });

        findViewById(R.id.buttonOperatorPlus).setOnClickListener(v -> {
            calc.addition(displayTextView);
        });
        findViewById(R.id.buttonOperatorMinus).setOnClickListener(v -> {
            calc.subtract(displayTextView);
        });
        findViewById(R.id.buttonOperatorMultiply).setOnClickListener(v -> {
            calc.multiplication(displayTextView);
        });
        findViewById(R.id.buttonOperatorDivide).setOnClickListener(v -> {
            calc.division(displayTextView);
        });
        findViewById(R.id.buttonResult).setOnClickListener(v -> {
            displayTextView.setText(calc.result(displayTextView.getText().toString()));
        });

        findViewById(R.id.buttonThemesActivity).setOnClickListener(v -> {
            Intent intent = new Intent(this, ChooseThemeActivity.class);
            startActivity(intent);
        });
    }
}