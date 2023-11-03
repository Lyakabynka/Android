package edu.itstep.myapplic03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView tvMessage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvMessage = findViewById(R.id.tvMessage);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.KEY_MESSAGE);
        tvMessage.setText(message);
    }
}
