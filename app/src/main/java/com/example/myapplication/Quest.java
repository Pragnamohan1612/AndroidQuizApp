package com.example.myapplication;

public class Quest {

    private String question2, button21, button22, button23, button24;
    private int correctAnsNo2;

    public Quest(String question2, String button21, String button22, String button23, String button24, int correctAnsNo2) {
        this.question2 = question2;
        this.button21 = button21;
        this.button22 = button22;
        this.button23 = button23;
        this.button24 = button24;
        this.correctAnsNo2 = correctAnsNo2;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getButton21() {
        return button21;
    }

    public void setButton21(String button21) {
        this.button21 = button21;
    }

    public String getButton22() {
        return button22;
    }

    public void setButton22(String button22) {
        this.button22 = button22;
    }

    public String getButton23() {
        return button23;
    }

    public void setButton23(String button23) {
        this.button23 = button23;
    }

    public String getButton24() {
        return button24;
    }

    public void setButton24(String button24) {
        this.button24 = button24;
    }

    public int getCorrectAnsNo2() {
        return correctAnsNo2;
    }

    public void setCorrectAnsNo2(int correctAnsNo2) {
        this.correctAnsNo2 = correctAnsNo2;
    }
}
