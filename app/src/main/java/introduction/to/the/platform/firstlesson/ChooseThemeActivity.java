package introduction.to.the.platform.firstlesson;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class ChooseThemeActivity extends AppCompatActivity {
    private static final int AppThemeCoolCodeStyle = 0;
    private static final int AppThemeLightCodeStyle = 1;
    private static final int AppThemeDarkCodeStyle = 2;
    private static final String AppTheme = "APP_THEME";
    public static final String NameSharedPreference = "LOGIN";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(getAppTheme(R.style.MyCoolStyle));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes);
        initThemeChooser();

        findViewById(R.id.buttonCoolCalc).setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
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

    public int getAppTheme(int codeStyleInt) {
        return codeStyleToStyleResId(getCodeStyle(codeStyleInt));
    }

    public void setAppTheme(int codeStyleInt) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(AppTheme, codeStyleInt);
        editor.apply();
    }

    public int codeStyleToStyleResId(int codeStyleInt){
        switch (codeStyleInt){
            case AppThemeLightCodeStyle:
                return R.style.MyLightStyle;
            case AppThemeDarkCodeStyle:
                return R.style.MyDarkStyle;
            case AppThemeCoolCodeStyle:
                return R.style.MyCoolStyle;
            default: return R.style.MyCoolStyle;
        }
    }

    public int getCodeStyle(int codeStyleInt){
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return sharedPref.getInt(AppTheme, codeStyleInt);
    }
}
