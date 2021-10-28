package introduction.to.the.platform.firstlesson;

import android.widget.TextView;

public class Calc {
    private double input1 = 0;
    private double input2 = 0;
    private boolean addition;
    private boolean subtract;
    private boolean multiplication;
    private boolean division;
    private boolean decimal;


    public void setDecimal(TextView v) {
        if (!decimal) {
            v.append(".");
        }
        decimal = true;
    }

    public void addition(TextView v) {
        if (v.getText().length() > 0) {
            input1 = Double.parseDouble(v.getText().toString());
            addition = true;
            decimal = false;
            v.setText(null);
        }
    }

    public void subtract(TextView v) {
        if (v.getText().length() > 0) {
            input1 = Double.parseDouble(v.getText().toString());
            subtract = true;
            decimal = false;
            v.setText(null);
        }
    }

    public void multiplication(TextView v) {
        if (v.getText().length() > 0) {
            input1 = Double.parseDouble(v.getText().toString());
            multiplication = true;
            decimal = false;
            v.setText(null);
        }
    }

    public void division(TextView v) {
        if (v.getText().length() > 0) {
            input1 = Double.parseDouble(v.getText().toString());
            division = true;
            decimal = false;
            v.setText(null);
        }
    }

    public String result(String s) {
        String setText = null;
        if (addition || subtract || multiplication || division) {
            input2 = Double.parseDouble(s);
        }
        if (addition) {
            addition = false;
            setText = String.valueOf(input1 + input2);
        }
        if (subtract) {
            subtract = false;
            setText = String.valueOf(input1 - input2);
        }
        if (multiplication) {
            multiplication = false;
            setText = String.valueOf(input1 * input2);
        }
        if (division) {
            division = false;
            if (input2 != 0) {
                setText = String.valueOf(input1 / input2);
            } else setText = "error";
        }
        return setText;
    }
}
