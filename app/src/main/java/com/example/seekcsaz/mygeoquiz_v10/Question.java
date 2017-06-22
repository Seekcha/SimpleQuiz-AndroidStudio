package com.example.seekcsaz.mygeoquiz_v10;

/**
 * Created by seekc on 5/19/2017.
 */
public class Question {
    private int mTextResId;
    private boolean mAnswerTrue;
    public Question(int mTextResId, boolean mAnswerTrue){
        this.mTextResId = mTextResId;
        this.mAnswerTrue = mAnswerTrue;
    }
    public int getTextResId(){
        return mTextResId;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }
    public void setTextResId(int textResId){
        mTextResId = textResId;
    }
    public void setmAnswerTrue(boolean answerTrue){
        mAnswerTrue = answerTrue;
    }
}

