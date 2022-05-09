package com.example.vanguardproject;

import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class Contact {

    private String goalName;
    private int goalAmount;
    private String imageUrl;
    private int currentAmount;

    public Contact(String goalName, int goalAmount, String imageUrl, int currentAmount){
        this.setGoalName(goalName);
        this.setGoalAmount(goalAmount);
        this.setImageUrl(imageUrl);
        this.setCurrentAmount(currentAmount);
    }

    public void setCurrentAmount(int currentAmount){this.currentAmount = currentAmount;}

    public int getCurrentAmount(){return currentAmount;}

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public int getGoalAmount() {
        return goalAmount;
    }

    public void setGoalAmount(int goalAmount) {
        this.goalAmount = goalAmount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + goalName + '\'' +
                ", email='" + goalAmount + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
    /**
    public void progressBarAnimation(){
        ProgressBar goalProgress = null;
        goalProgress = (ProgressBar) goalProgress.findViewById(R.id.goalProgressBar);

        Timer t = new Timer();
        ProgressBar finalGoalProgress = goalProgress;
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                progressBarCounter++;
                finalGoalProgress.setProgress(progressBarCounter);

                if(progressBarCounter == (currentAmount/goalAmount)){
                    t.cancel();
                }
            }
        };
        t.schedule(tt,0,60);
    }
    **/
}
