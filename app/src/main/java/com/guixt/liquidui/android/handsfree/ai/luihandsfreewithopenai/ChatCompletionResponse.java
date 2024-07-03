package com.guixt.liquidui.android.handsfree.ai.luihandsfreewithopenai;

import java.util.List;

public class ChatCompletionResponse {
    private String id;
    private String object;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    private long created;
    private String model;
    private List<Choice> choices;
    private Usage usage;

    public ChatCompletionResponse(String id, String object, long created, String model, List<Choice> choices, Usage usage) {
        this.id = id;
        this.object = object;
        this.created = created;
        this.model = model;
        this.choices = choices;
        this.usage = usage;
    }

   /* public static class Choice {
        private int index;
        private Message message;
        private String finish_reason;

        public Choice(int index, Message message, String finish_reason) {
            this.index = index;
            this.message = message;
            this.finish_reason = finish_reason;
        }
// Getters and setters

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }

        public String getFinish_reason() {
            return finish_reason;
        }

        public void setFinish_reason(String finish_reason) {
            this.finish_reason = finish_reason;
        }
    }*/
}