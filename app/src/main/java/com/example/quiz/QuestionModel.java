package com.example.quiz;

import java.io.Serializable;
import java.util.List;

public class QuestionModel implements Serializable {
    private String question;
    private String correctAnswer;
    private List<String> options;
    private String explanation;

    // Конструктор с полями
    public QuestionModel(String question, String correctAnswer, List<String> options, String explanation) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.options = options;
        this.explanation = explanation;
    }

    // Конструктор без объяснений
    public QuestionModel(String question, String correctAnswer, List<String> options) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.options = options;
        this.explanation = ""; // Если объяснение не задано
    }

    // Геттеры
    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getExplanation() {
        return explanation;
    }

    // Сеттеры
    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Override
    public String toString() {
        return "Question: " + question + "\n" +
                "Correct Answer: " + correctAnswer + "\n" +
                "Options: " + options.toString() + "\n" +
                "Explanation: " + explanation;
    }
}
