package com.example.chetansharma.trs2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question4 extends AppCompatActivity {
    private RadioGroup rg1, rg2, rg3, rg4;
    private int m_score_cm,r_score_cm,b_score_cm,s_score_cm;
    DatabaseHelper2 databaseHelper2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        databaseHelper2=new DatabaseHelper2(getApplicationContext());
        setContentView(R.layout.activity_question4);
        rg1 = findViewById(R.id.radioGroup);
        rg2 = findViewById(R.id.radioGroup2);
        rg3 = findViewById(R.id.radioGroup3);
        rg4 = findViewById(R.id.radioGroup4);

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
                if (checkedRadioButton.getText().equals("Strongly Agree")) {
                    m_score_cm = 5;
                } else if (checkedRadioButton.getText().equals("Agree")) {

                    m_score_cm = 4;
                } else if (checkedRadioButton.getText().equals("Disagree")) {
                    m_score_cm = 2;
                } else {
                    m_score_cm = 1;
                }
            }
        });

        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
                if (checkedRadioButton.getText().equals("Strongly Agree")) {
                    r_score_cm = 5;
                } else if (checkedRadioButton.getText().equals("Agree")) {

                    r_score_cm = 4;
                } else if (checkedRadioButton.getText().equals("Disagree")) {
                    r_score_cm = 2;
                } else {
                    r_score_cm = 1;
                }
            }
        });

        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
                if (checkedRadioButton.getText().equals("Strongly Agree")) {
                    b_score_cm = 5;
                } else if (checkedRadioButton.getText().equals("Agree")) {

                    b_score_cm = 4;
                } else if (checkedRadioButton.getText().equals("Disagree")) {
                    b_score_cm = 2;
                } else {
                    b_score_cm = 1;
                }
            }
        });
        rg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
                if (checkedRadioButton.getText().equals("Strongly Agree")) {
                    s_score_cm = 5;
                } else if (checkedRadioButton.getText().equals("Agree")) {

                    s_score_cm = 4;
                } else if (checkedRadioButton.getText().equals("Disagree")) {
                    s_score_cm = 2;
                } else {
                    s_score_cm = 1;
                }
            }
        });
    }

    public void feed(View view) {
        if (rg1.getCheckedRadioButtonId() == -1 || rg2.getCheckedRadioButtonId() == -1 || rg3.getCheckedRadioButtonId() == -1 || rg4.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Please answer all the questions.", Toast.LENGTH_SHORT).show();
        }
        else {

            Intent intent4= getIntent();
            Bundle bundle = intent4.getExtras();
            Integer msk=bundle.getInt("m_score_sk");
            Integer rsk=bundle.getInt("r_score_sk");
            Integer bsk=bundle.getInt("b_score_sk");
            Integer ssk=bundle.getInt("s_score_sk");
            Integer mtm=bundle.getInt("m_score_tm");
            Integer rtm=bundle.getInt("r_score_tm");
            Integer btm=bundle.getInt("b_score_tm");
            Integer stm=bundle.getInt("s_score_tm");
            Integer mrs=bundle.getInt("m_score_rs");
            Integer rrs=bundle.getInt("r_score_rs");
            Integer brs=bundle.getInt("b_score_rs");
            Integer srs=bundle.getInt("s_score_rs");

            databaseHelper2.insertDataMahesh(msk,mtm,mrs,m_score_cm);
            databaseHelper2.insertDataRama(rsk,rtm,rrs,r_score_cm);
            databaseHelper2.insertDataBhasker(bsk,btm,brs,b_score_cm);
            databaseHelper2.insertDataSrinivas(ssk,stm,srs,s_score_cm);


            startActivity(new Intent(Question4.this, Feedback.class));
        }
    }
}
