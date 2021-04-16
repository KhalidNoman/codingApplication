package com.example.codingapplication;

public class questionData {
    private String question;
    private String code;
    private String[] choices;
    private int answer;

    public questionData(String question, String code, String[] choices, int answer) {
        this.question = question;
        this.code = code;
        this.choices = choices;
        this.answer = answer;
    }

    public questionData() {
        this.question = "";
        this.code = "";
        this.choices = new String[]{"", "", "", ""};
        this.answer = 0;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
