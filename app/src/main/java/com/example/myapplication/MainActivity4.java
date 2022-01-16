package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    private TextView tvquestion1, tvScore1, tvTimer1, tvQuestionno1;
    private RadioGroup rad;
    private RadioButton btn11, btn12, btn13, btn14;
    private Button btnNext1;

    int totalquestions1;
    int qCounter1 = 0;
    int score1;

    ColorStateList dfRbColor1;
    boolean answered1;

    private QM currentQuestion1;

    private List<QM> questionsList1;
    int timerMaxValue1 = 59;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

       questionsList1 = new ArrayList<>();
        tvquestion1 = findViewById(R.id.question1);
        tvScore1= findViewById(R.id.textScore1);
        tvTimer1 = findViewById(R.id.texttimmer1);

        tvQuestionno1= findViewById(R.id.textquestionno1);

        rad = findViewById(R.id.group1);
        btn11 = findViewById(R.id.button11);
        btn12 = findViewById(R.id.button12);
        btn13 = findViewById(R.id.button13);
        btn14 = findViewById(R.id.button14);
        btnNext1 = findViewById(R.id.buttonn10);

        dfRbColor1 = btn11.getTextColors();

        addQuestions1();
        totalquestions1 = questionsList1.size();
        showNextQuestion1();

        displayTimer1();

        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered1 == false) {
                    if(btn11.isChecked() || btn12.isChecked() || btn13.isChecked() || btn14.isChecked() ) {
                        checkAnswer1();


                    }else {
                        Toast.makeText(MainActivity4.this, "Please select an option", Toast.LENGTH_SHORT).show();

                    }
                }else {
                    showNextQuestion1();
                    timerMaxValue1 = 20;
                    Toast.makeText(getApplicationContext(), "showing next question", 60000).show();
                    handler.removeCallbacks(runnable);
                    displayTimer1();
                }

            }
        });


    }

    private void checkAnswer1() {
        answered1 = true;

        RadioButton rbSelected = findViewById(rad.getCheckedRadioButtonId());
        int answerNo = rad.indexOfChild(rbSelected) + 1;
        if(answerNo == currentQuestion1.getCorrectAnsNo1()){
            score1++;
            tvScore1.setText("Score: "+score1);


        }

        btn11.setTextColor(Color.RED);
        btn12.setTextColor(Color.RED);
        btn13.setTextColor(Color.RED);
        btn14.setTextColor(Color.RED);
        switch (currentQuestion1.getCorrectAnsNo1()){

            case 1:
                btn11.setTextColor(Color.GREEN);
                break;

            case 2:
                btn12.setTextColor(Color.GREEN);
                break;

            case 3:
                btn13.setTextColor(Color.GREEN);
                break;

        }
        if(qCounter1 < totalquestions1 ) {
            btnNext1.setText("Next");

        }else {
            btnNext1.setText("finish");


        }

    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            timerMaxValue1--;
            tvTimer1.setText("00:"+timerMaxValue1);

            if(1 <= 0 ){
                showNextQuestion1();
                timerMaxValue1 = 20;
                tvTimer1.setText(""+timerMaxValue1);
                displayTimer1();
            }else{
                handler.postDelayed(this, 1000);
            }

        }
    };
    public void displayTimer1(){

        tvTimer1.setText(""+timerMaxValue1);

        handler.postDelayed(runnable, 1000);
    }



    private void showNextQuestion1() {
        rad.clearCheck();
        btn11.setTextColor(dfRbColor1);
        btn12.setTextColor(dfRbColor1);
        btn13.setTextColor(dfRbColor1);
        btn14.setTextColor(dfRbColor1);


        if(qCounter1 < totalquestions1) {




            currentQuestion1 = questionsList1.get(qCounter1);
            tvquestion1.setText(currentQuestion1.getQuestion1());
            btn11.setText(currentQuestion1.getButton11());
            btn12.setText(currentQuestion1.getButton12());
            btn13.setText(currentQuestion1.getButton13());
            btn14.setText(currentQuestion1.getButton14());

            qCounter1++;


            btnNext1.setText("Submit");
            tvQuestionno1.setText("Question: "+qCounter1+"/"+totalquestions1);
            answered1 = false;
    }else
        {
            finish();


        }
    }

    private void addQuestions1() {





            questionsList1.add(new QM("Vinay is older than Muthu. Jack is older than Vinay. Muthu is older than Jack. If the first two statements are true, the third statement is", "True", "False", "Uncertain", "None of the above", 2 ));
            questionsList1.add(new QM("RQP, ONM, _, IHG, FED, find the missing letters", "CDE", "LKI", "LKJ", "BAC", 3 ));
            questionsList1.add(new QM("If in a certain language, NOIDA is coded as OPJEB, how is DELHI coded in that language?", "CDKGH", "EFMIJ", "FGNJK", "IHLED", 2 ));
            questionsList1.add(new QM("Pooja is older than Mukesh. Suresh is older than Pooja. Mukesh is older than Suresh. If the two statements are true, the third statement is", "True", "False", "Uncertain", "None of the above", 1 ));
            questionsList1.add(new QM("DNN, FPP, HRR, _____, LVV", "GRR", "GSS", "JTT", "ITT", 3 ));
            questionsList1.add(new QM("Pointing to a photograph, a man said, \"I have no brother, and that man's father is my father's son.\" Whose photograph was it?", "His son", "His own", "His father", "His nnephew", 1 ));
            questionsList1.add(new QM("Arrange the following words in a meaning ful sequence. 1-> Infection 2-> Consulattion 3-> Doctor 4-> Treatment 5-> Recovery", "1, 3, 4, 5, 2", "1, 3, 2, 4, 5", "1, 2, 3, 4, 5", "2, 3, 5, 1, 4", 2 ));
            questionsList1.add(new QM("Peter is in the East of Tom and Tom is in the North of John. Mike is in the South of John then in which direction of Peter is Mike?", "Judy is Dan’s mother-in-law", "Margaret is Dan’s mother", "Judy is Joshua’s grandmother", "None of the above", 4 ));
            questionsList1.add(new QM("Dan is Joshua’s son and Guy’s brother. Margaret is Guy’s mother and Judy’s daughter. Which of the statements below is definitely true?", "CDE", "LKI", "LKJ", "BAC", 3 ));
            questionsList1.add(new QM("If there are no dancers that aren’t slim and no singers that aren’t dancers, then which statements are always true?", " not one slim person that isn’t a dancer", "All singers are slim", "Anybody slim is also a singer", "None of the above", 2 ));
            questionsList1.add(new QM("Find the next number in the sequence: 16, 30, 54, 88, 132…", "186", "188", "190", "206", 1 ));
            questionsList1.add(new QM("Which word does NOT belong with the others?", "guitar", "flute", "violin", "cello", 2 ));
            questionsList1.add(new QM("Which word does NOT belong with the others?", "mayonnaise", "dill", "parsley", "basil", 4 ));
            questionsList1.add(new QM("Which word does NOT belong with the others?", "wing", "fin", "break", "rubber", 3 ));
            questionsList1.add(new QM("SCD, TEF, UGH, ___, WKL, find the missing letters", "CMN", "UJI", "VIJ", "IJT", 3 ));

        }
    }
