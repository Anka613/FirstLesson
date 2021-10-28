package introduction.to.the.platform.firstlesson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button number1 = findViewById(R.id.button1);
        Button number2 = findViewById(R.id.button2);
        Button number3 = findViewById(R.id.button3);
        Button number4 = findViewById(R.id.button4);
        Button number5 = findViewById(R.id.button5);
        Button number6 = findViewById(R.id.button6);
        Button number7 = findViewById(R.id.button7);
        Button number8 = findViewById(R.id.button8);
        Button number9 = findViewById(R.id.button9);
        Button number0 = findViewById(R.id.button10);
        Button minus = findViewById(R.id.button12);
        Button plus = findViewById(R.id.button11);
        Button multiply = findViewById(R.id.button13);
        Button divide = findViewById(R.id.button14);
        Button equals = findViewById(R.id.button15);
        Button clear = findViewById(R.id.button16);
        Button dot = findViewById(R.id.button17);
        TextView display = findViewById(R.id.textView2);
    }

    public void set(Button button){
        TextView text = (TextView) button.getText();

    }
}