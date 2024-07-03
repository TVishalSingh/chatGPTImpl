package com.guixt.liquidui.android.handsfree.ai.luihandsfreewithopenai;

import java.util.List;

public class ChatCompletionRequest {
    private String model;
    private List<Message> messages;
    private double temperature;

    public void setModel(String model) {
        this.model = model;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public ChatCompletionRequest(String model, List<Message> messages, double temperature) {
        this.model = model;
        this.messages = messages;
        this.temperature = temperature;
    }
}