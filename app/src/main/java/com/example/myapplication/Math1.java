package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Math1 extends AppCompatActivity {

    private TextView tvquestion, tvScore, tvTimer, tvQuestionno;
    private RadioGroup radio;
    private RadioButton btn1, btn2, btn3, btn4;
    private Button btnNext;

    int totalquestions;
    int qCounter = 0;
    int score;



    ColorStateList dfRbColor;
    boolean answered;
    
    private QuestionModel currentQuestion;
    
    private List<QuestionModel> questionsList;
    int timerMaxValue = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math1);

        questionsList = new ArrayList<>();
        tvquestion = findViewById(R.id.question);
        tvScore = findViewById(R.id.textScore);
        tvTimer = findViewById(R.id.texttimmer);

        tvQuestionno = findViewById(R.id.textquestionno);

        radio = findViewById(R.id.group);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btnNext = findViewById(R.id.buttonn);

        dfRbColor = btn1.getTextColors();


        questionsList = new ArrayList<>();
        
        addQuestion();

        totalquestions = questionsList.size();
        showNextQuestion();
        displayTimer();
        

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answered == false) {
                    if(btn1.isChecked() || btn2.isChecked() || btn3.isChecked() || btn4.isChecked() ) {
                        checkAnswer();


                    }else {
                        Toast.makeText(Math1.this, "Please select an option", Toast.LENGTH_SHORT).show();

                    }
                }else {
                    showNextQuestion();
                    timerMaxValue = 20;
                    Toast.makeText(getApplicationContext(), "showing next question", 60000).show();
                    handler.removeCallbacks(runnable);
                    displayTimer();


                }

            }
        });

    }


    private void checkAnswer() {
        answered = true;

        RadioButton rbSelected = findViewById(radio.getCheckedRadioButtonId());
        int answerNo = radio.indexOfChild(rbSelected) + 1;
        if(answerNo == currentQuestion.getCorrectAnsNo()){
            score++;
            tvScore.setText("Score: "+score);


        }


        btn1.setTextColor(Color.RED);
        btn2.setTextColor(Color.RED);
        btn3.setTextColor(Color.RED);
        btn4.setTextColor(Color.RED);
        switch (currentQuestion.getCorrectAnsNo()){

            case 1:
                btn1.setTextColor(Color.GREEN);
                break;

            case 2:
                btn2.setTextColor(Color.GREEN);
                break;

            case 3:
                btn3.setTextColor(Color.GREEN);
                break;

        }
        if(qCounter < totalquestions) {
            btnNext.setText("Next");

        }else {
            btnNext.setText("finish");


        }

    }

    Handler handler = new Handler();
    Runnable runnable =  new Runnable() {
        @Override
        public void run() {



            timerMaxValue--;
            tvTimer.setText("00:"+timerMaxValue);

            if(timerMaxValue <= 0 ){
                showNextQuestion();
                timerMaxValue = 20;
                tvTimer.setText(""+timerMaxValue);
                displayTimer();
            }else{
                handler.postDelayed(this, 1000);
            }

        }
    };
    public void displayTimer(){

        tvTimer.setText(""+timerMaxValue);

        handler.postDelayed(runnable, 1000);
    }



    private void showNextQuestion() {

        radio.clearCheck();
        btn1.setTextColor(dfRbColor);
        btn2.setTextColor(dfRbColor);
        btn3.setTextColor(dfRbColor);
        btn4.setTextColor(dfRbColor);

        if(qCounter < totalquestions){



            currentQuestion = questionsList.get(qCounter);
            tvquestion.setText(currentQuestion.getQuestion());
            btn1.setText(currentQuestion.getButton1());
            btn2.setText(currentQuestion.getButton2());
            btn3.setText(currentQuestion.getButton3());
            btn4.setText(currentQuestion.getButton4());

            qCounter++;
            btnNext.setText("Submit");
            tvQuestionno.setText("Question: "+qCounter+"/"+totalquestions);
            answered = false;



    }else{
            finish();

        }



}

    private void addQuestion() {
        questionsList.add(new QuestionModel("What is the compound interest on Rs. 2500 for 2 years at rate of interest 4% per annum?", "Rs. 180", "Rs. 204", "Rs. 210", "Rs. 220", 2 ));
        questionsList.add(new QuestionModel("A mother is twice as old as her son. If 20 years ago, the age of the mother was 10 times the age of the son, what is the present age of the mother?", "38 years", "40 years", "43 years", "45 years", 4 ));
        questionsList.add(new QuestionModel("A 60 liter mixture of milk and water contains 10% water. How much water must be added to make water 20% in the mixture", "8 liters", "7.5 liters", "7 liters", "6.5 liters",2 ));
        questionsList.add(new QuestionModel("A: B: C is in the ratio of 3: 2: 5. How much money will C get out of Rs 1260?", "252", "125", "503", "None of these", 4 ));
        questionsList.add(new QuestionModel("Complete the series 2, 5, 9, 19, 37......", "76", "74", "75", "None of these", 3 ));
        questionsList.add(new QuestionModel("A shopkeeper sold an article for Rs. 2500. If the cost price of the article is 2000, find the profit percent.", "23%", "25%", "27%", "29%", 2 ));
        questionsList.add(new QuestionModel("A train moving at speed of 80 km/hr crosses a pole in 7 seconds. Find the length of the train", "150 m", "165 m", "175 m", "170 m", 3 ));
        questionsList.add(new QuestionModel("In the first 10 overs of a cricket game, the run rate was only 3.2. what should be the run rate in the remaining 40 overs to reach the target of 282 runs?", "5.5", "6.25", "5", "7.4", 2 ));
        questionsList.add(new QuestionModel("The average of 20 numbers is zero. How many of them may be greater than zero, at the most?", "20", "19", "0", "1", 2 ));
        questionsList.add(new QuestionModel("Average of 5 numbers is 27. If one number is excluded, average becomes 25. What is the excluded number?", "30", "32.5", "35", "40", 3 ));
        questionsList.add(new QuestionModel("A vendor bought bananas at 6 rupee. How many for a rupee must he sell to gain 20%?", "5", "3", "6", "4", 1 ));
        questionsList.add(new QuestionModel("By selling an item for Rs.15, a trader losses one sixth of what it coasts him. The cost price of the item is", "Rs.15", "Rs.14", "Rs.16", "Rs.17", 2 ));
        questionsList.add(new QuestionModel("If the difference between the length and breadth of a rectangle is 23metre and it's perimeter is 206metre, what is the area in square metre?", "2520", "2740", "2200", "2800", 1 ));
        questionsList.add(new QuestionModel("Kamal was 4 times as old as his son 8 years ago. After 8 years, Kamal will be twice as old as his son. Find out the present age of Kamal", "38 years", "36 years", "40", "42", 3 ));
        questionsList.add(new QuestionModel("The total age of A and B is 12years more than the total age of B and C. C is younger than A by:", "12 years", "13 years", "10 years", "11 years", 1 ));
    }
}



