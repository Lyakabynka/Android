package edu.itstep.myapplic03;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_GENDER_ACTIVITY = 101;
    public static final String KEY_MESSAGE = "message";
    private TextView tvGender;
    private Button btnGender;
    private EditText etMessage;
    private Button btnNext;


    private ActivityResultLauncher<Intent> genderActivityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvGender = findViewById(R.id.tvGender);
        btnGender = findViewById(R.id.btnGender);
        etMessage = findViewById(R.id.etMessage);
        btnNext = findViewById(R.id.btnNext);

        btnGender.setOnClickListener(view -> {
            //old
            Intent intent = new Intent(this, GenderActivity.class);
            genderActivityResultLauncher.launch(intent);
        });

        genderActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            String gender = data.getStringExtra(GenderActivity.KEY_GENDER);
                            tvGender.setText(String.format("%s%s", getString(R.string.selected_gender), gender));
                        }
                    } else {
                        tvGender.setText(String.format("%s?", getString(R.string.selected_gender)));
                    }
                });

        btnNext.setOnClickListener(view -> {
            String message = etMessage.getText().toString();
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(KEY_MESSAGE, message);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_GENDER_ACTIVITY:
                if (resultCode == RESULT_OK) {
                    String gender = data.getStringExtra(GenderActivity.KEY_GENDER);
                    tvGender.setText(String.format("%s%s", getString(R.string.selected_gender), gender));
                } else {
                    tvGender.setText(String.format("%s?", getString(R.string.selected_gender)));
                }
                break;
            case 102:

                break;
        }
    }
}