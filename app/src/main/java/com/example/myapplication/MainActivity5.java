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

public class MainActivity5 extends AppCompatActivity {

    private TextView tvquestion2, tvScore2, tvTimer2, tvQuestionno2;
    private RadioGroup radio2;
    private RadioButton btn21, btn22, btn23, btn24;
    private Button btnNext2;

    int totalquestions2;
    int qCounter2 = 0;
    int score2;

    ColorStateList dfRbColor2;
    boolean answered2;


    private Quest currentQuestion2;
    private List<Quest> questionsList2;
    int timerMaxValue2 = 59;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        questionsList2 = new ArrayList<>();
        tvquestion2 = findViewById(R.id.question2);
        tvScore2 = findViewById(R.id.textScore2);
        tvTimer2 = findViewById(R.id.texttimmer2);

        tvQuestionno2 = findViewById(R.id.textquestionno2);

        radio2 = findViewById(R.id.group2);
        btn21 = findViewById(R.id.button21);
        btn22 = findViewById(R.id.radioButton22);
        btn23 = findViewById(R.id.button23);
        btn24 = findViewById(R.id.button24);
        btnNext2 = findViewById(R.id.buttona);

        dfRbColor2 = btn21.getTextColors();

        addQuestions2();
        totalquestions2 = questionsList2.size();
        showNextQuestion2();

        displayTimmer2();

        btnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answered2 == false) {
                    if(btn21.isChecked() || btn22.isChecked() || btn23.isChecked() || btn24.isChecked() ) {
                        checkAnswer2();


                    }else {
                        Toast.makeText(MainActivity5.this, "Please select an option", Toast.LENGTH_SHORT).show();

                    }
                }else {
                    showNextQuestion2();
                    timerMaxValue2 = 20;
                    Toast.makeText(getApplicationContext(), "showing next question", 60000).show();
                    handler.removeCallbacks(runnable);
                    displayTimmer2();
                }


            }
        });


    }



    private void checkAnswer2() {
        answered2= true;

        RadioButton rbSelected = findViewById(radio2.getCheckedRadioButtonId());
        int answerNo = radio2.indexOfChild(rbSelected) + 1;
        if(answerNo == currentQuestion2.getCorrectAnsNo2()){
            score2++;
            tvScore2.setText("Score: "+score2);


        }


        btn21.setTextColor(Color.RED);
        btn22.setTextColor(Color.RED);
        btn23.setTextColor(Color.RED);
        btn24.setTextColor(Color.RED);
        switch (currentQuestion2.getCorrectAnsNo2()){

            case 1:
                btn21.setTextColor(Color.GREEN);
                break;

            case 2:
                btn22.setTextColor(Color.GREEN);
                break;

            case 3:
                btn23.setTextColor(Color.GREEN);
                break;

        }
        if(qCounter2 < totalquestions2) {
            btnNext2.setText("Next");

        }else {
            btnNext2.setText("finish");


        }

    }
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            timerMaxValue2--;
            tvTimer2.setText("00:"+timerMaxValue2);

            if(timerMaxValue2 <= 0 ){
                showNextQuestion2();
                timerMaxValue2 = 20;
                tvTimer2.setText(""+timerMaxValue2);
                displayTimmer2();
            }else{
                handler.postDelayed(this, 1000);
            }

        }
    };

    public void displayTimmer2(){

        tvTimer2.setText(""+timerMaxValue2);

        handler.postDelayed(runnable, 1000);
    }



    private void showNextQuestion2() {

        radio2.clearCheck();
        btn21.setTextColor(dfRbColor2);
        btn22.setTextColor(dfRbColor2);
        btn23.setTextColor(dfRbColor2);
        btn24.setTextColor(dfRbColor2);


        if(qCounter2 < totalquestions2) {

            currentQuestion2 = questionsList2.get(qCounter2);
            tvquestion2.setText(currentQuestion2.getQuestion2());
            btn21.setText(currentQuestion2.getButton21());
            btn22.setText(currentQuestion2.getButton22());
            btn23.setText(currentQuestion2.getButton23());
            btn24.setText(currentQuestion2.getButton24());

            qCounter2++;


            btnNext2.setText("Submit");
            tvQuestionno2.setText("Question: "+qCounter2+"/"+totalquestions2);
            answered2 = false;
        }
        else
        {
            finish();

        }
    }

    private void addQuestions2() {
        questionsList2.add(new Quest("To keeps one's temper", "To become hungry", "To be in good mood", "To preserve ones energy", "To be aloof from", 2 ));
        questionsList2.add(new Quest("To catch a tartar", "To meet with disaster", "To catch a dangerous person", "To trap wanted criminal with great difficult", "None of these", 2 ));
        questionsList2.add(new Quest("To have an axe to grind", "A private end to serve", "To fail to arouse interest", "To have no result", "To work for both sides", 1 ));
        questionsList2.add(new Quest("To cry wolf", "To listen eagerly", "To give false alarm", "To turn pale", "To keep off starvation", 2 ));
        questionsList2.add(new Quest("To be above board", "To have a good heighty", "To try to be beautiful", "They have no debts", "To be honest in any business deal", 4 ));
        questionsList2.add(new Quest("To put one's hand to plough", "To take up agricultural farming", "Take interest in technical work", "To take a difficult task", "None of these", 3 ));
        questionsList2.add(new Quest("To pick holes", "To criticise someone", "To destroy something", "To find some reason to quarrel", "To cut some part of an item", 1 ));
        questionsList2.add(new Quest("The small child does whatever his father was done.", "has done", "did", "does", "had done", 3 ));
        questionsList2.add(new Quest("You need not come unless you want to", "You don't need to come unless you want to", "You come only when you want to", "No correction required", "You come unless you don't want to", 1 ));
        questionsList2.add(new Quest("The man to who I sold my house was a cheat", "to whom I sell", "to who I sell", "who was sold to", "to whom I sold", 4 ));
        questionsList2.add(new Quest("He is too important for tolerating any delay.", "No correction required", "with tolerating", "to tolerate", "to tolerating", 3 ));
        questionsList2.add(new Quest("Opposite of the given word ENORMOUS is", "Weak", "Average", "Soft", "tiny", 4 ));
        questionsList2.add(new Quest("Opposite of the given word EXODUS is", "Influx", "Home-coming", "Return", "Restoration", 1 ));
        questionsList2.add(new Quest("Opposite of the given word QUIESCENT is", "Dormant", "Active", "Weak", "Unconcerned", 2 ));
        questionsList2.add(new Quest("Find the correctly spelt word.", "Beterment", "Employd", "Efficient", "Treatmeant", 3 ));
        questionsList2.add(new Quest("Find the correctly spelt word.", "Foreign", "Foreine", "Fariegn", "Forein", 1 ));



    }
}




