package com.codegym.model;

public class Email {
    private String language;
    private int sizePage;
    private boolean spam;
    private String text;

    public Email() {
    }

    public Email(String language, int sizePage, boolean spam, String text) {
        this.language = language;
        this.sizePage = sizePage;
        this.spam = spam;
        this.text = text;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSizePage() {
        return sizePage;
    }

    public void setSizePage(int sizePage) {
        this.sizePage = sizePage;
    }

    public boolean isSpam() {
        return spam;
    }

    public void setSpam(boolean spam) {
        this.spam = spam;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
