package introduction.to.the.platform.firstlesson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class MainActivity extends AppCompatActivity {
    private TextView displayTextView;
    private static final int AppThemeCoolCodeStyle = 0;
    private static final int AppThemeLightCodeStyle = 1;
    private static final int AppThemeDarkCodeStyle = 2;
    private static final String AppTheme = "APP_THEME";
    private static final String NameSharedPreference = "LOGIN";

    Calc calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.MyCoolStyle));
        setContentView(R.layout.activity_main2);

        initThemeChooser();

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
    }

    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.radioButtonCoolTheme),
                AppThemeCoolCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonLightTheme),
                AppThemeLightCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonDarkTheme),
                AppThemeDarkCodeStyle);
        RadioGroup rg = findViewById(R.id.radioButtonsGroupChooseTheme);
        ((MaterialRadioButton)rg.getChildAt(getCodeStyle(AppThemeCoolCodeStyle))).setChecked(true);
        // - При первом запуске падает, но я не смогла понять почему он не нашел чайлда радиогруппы по стилю
    }
    private void initRadioButton(View button, final int codeStyle){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAppTheme(codeStyle);
                recreate();
            }
        });
    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    private void setAppTheme(int codeStyle) {
       SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
       SharedPreferences.Editor editor = sharedPref.edit();
       editor.putInt(AppTheme, codeStyle);
       editor.apply();
   }

    private int codeStyleToStyleId(int codeStyle){
        switch (codeStyle){
            case AppThemeLightCodeStyle:
                return R.style.MyLightStyle;
            case AppThemeDarkCodeStyle:
                return R.style.MyDarkStyle;
            default: return R.style.MyCoolStyle;
        }
    }

    private int getCodeStyle(int codeStyle){
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return sharedPref.getInt(AppTheme, codeStyle);
    }
}