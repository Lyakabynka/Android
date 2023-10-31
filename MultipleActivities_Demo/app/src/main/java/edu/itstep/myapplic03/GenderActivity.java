package edu.itstep.myapplic03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class GenderActivity extends AppCompatActivity {
    public static final String KEY_GENDER = "gender";
    private RadioGroup rGrGender;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        rGrGender = findViewById(R.id.rGrGender);
        btnOk = findViewById(R.id.btnOk);

        rGrGender.setOnCheckedChangeListener((radioGroup, selectedId) -> {
            Intent returnIntent = new Intent();
            if (selectedId == R.id.rbMan) {
                returnIntent.putExtra(KEY_GENDER, getString(R.string.man));
            } else if (selectedId == R.id.rbWoman) {
                returnIntent.putExtra(KEY_GENDER, getString(R.string.woman));
            } else if (selectedId == R.id.rbOther) {
                returnIntent.putExtra(KEY_GENDER, getString(R.string.other));
            }
            setResult(RESULT_OK, returnIntent);
        });
        btnOk.setOnClickListener(view -> {
            finish();
        });

    }
}