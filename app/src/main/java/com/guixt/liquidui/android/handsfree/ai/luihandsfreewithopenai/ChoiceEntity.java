package com.guixt.liquidui.android.handsfree.ai.luihandsfreewithopenai;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ChoiceEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String content;
    private boolean userInput;
    private String action;
    private String mood;

    public ChoiceEntity() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isUserInput() {
        return userInput;
    }

    public void setUserInput(boolean userInput) {
        this.userInput = userInput;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public ChoiceEntity(int id, String content, boolean userInput, String action, String mood) {
        this.id = id;
        this.content = content;
        this.userInput = userInput;
        this.action = action;
        this.mood = mood;
    }
}