package com.example.aircondition;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private boolean isOn=true;
    private int mode=1; //1 mode=cool, 2=heat
    private TextView tvmode;
    private int temp;
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvmode=findViewById(R.id.tvmode);
        temp=24;
    }

    public void checkStatus(View view) {
        if(isOn)
            isOn=false;
        else
            isOn=true;
    }

    public void checkMode(View view) {
        if(mode==1) {
            mode = 2;
            tvmode.setText("Heat");
        }
        else {
            mode = 1;
            tvmode.setText("Cool");

        }

    }

    public void increaseTemperature(View view) {
        if (isOn) {
            if (temp < 30) { // Prevent increasing temperature above 30
                temp++;
                updateTemperatureDisplay();
            } else {
                Toast.makeText(this, "Temperature cannot exceed 30°C", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "AC is off. Turn it on to adjust temperature.", Toast.LENGTH_LONG).show();
        }
    }

    public void decreaseTemperature(View view) {
        if (isOn) {
            if (temp > 16) { // Prevent decreasing temperature below 16
                temp--;
                updateTemperatureDisplay();
            } else {
                Toast.makeText(this, "Temperature cannot go below 16°C", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, "AC is off. Turn it on to adjust temperature.", Toast.LENGTH_LONG).show();
        }
    }

    private void updateTemperatureDisplay() {
        TextView tempTextView = findViewById(R.id.textView2);
        tempTextView.setText(String.valueOf(temp)); // Update the temperature display
    }
}