package com.pg.fk.magicidapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etID;
    Button btnSubmit;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        etID = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String idNumber = etID.getText().toString().trim();

                String dob = idNumber.substring(0, 6);

                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));

                String sgender;

                if (gender < 5)
                    sgender = getString(R.string.female);
                else
                    sgender = getString(R.string.male);

                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));

                String snationality;

                if (nationality == 0)
                    snationality = getString(R.string.sacitizen);
                else
                    snationality = getString(R.string.pr);


                tvResults.setText(getString(R.string.dob) + dob + "\n" +
                                    getString(R.string.gender) + sgender + "\n" +
                                    getString(R.string.nationality) + snationality);
            }
        });
    }
}
