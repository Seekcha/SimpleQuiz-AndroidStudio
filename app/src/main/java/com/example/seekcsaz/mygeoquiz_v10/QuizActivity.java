package com.example.seekcsaz.mygeoquiz_v10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    //create two variables which will hold our button object
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView score;
    private int mScore = 0;

    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, true),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true)
    };

    private int mCurrentIndex= 0; // index value

    private void updateQuestions() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer (boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;
        if(userPressedTrue == answerIsTrue){
            mScore++;
            score.setText("Score: " + mScore);
            messageResId = R.string.correct_toast;
        }
        else {
            if (mScore > 0){
                mScore--;
                score.setText("Score: " + mScore);
                messageResId = R.string.incorrect_toast;
            }
            else{
                messageResId = R.string.incorrect_toast;
            }



        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //getting hold of button or view which were generated
        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (Button) findViewById(R.id.next_button);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        score = (TextView) findViewById(R.id.score);

        score.setText("Score: " + mScore);

        final int mCurrentQuestion = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(mCurrentQuestion);

        //set an onclick listener on the true button
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //write the logic ehich corresponds to the button click

                //Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                checkAnswer(true);

            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(QuizActivity.this,R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                checkAnswer(false);
            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(QuizActivity.this, "NEXT!", Toast.LENGTH_SHORT).show();
            //startActivity(new Intent(getApplicationContext(), UtilityActivity.class)); //when click activity the onCreate on utility Activity is being activited
            mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length; //kan arrive last element li return to first element
                updateQuestions();
            }
        });


    }




}
