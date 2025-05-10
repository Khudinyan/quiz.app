package com.example.quiz;

public class QuestionsList {

    private String option1, option2, option3, option4, question, answer;
    private String userSelectedAnswer;
    private String explanation;
    private int imageResource = -1; // по умолчанию -1, если картинки нет

    // 🔹 Конструктор без картинки
    public QuestionsList(String question, String option1, String option2, String option3,
                         String option4, String answer, String userSelectedAnswer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
        this.userSelectedAnswer = userSelectedAnswer;
    }

    // 🔹 Новый конструктор с картинкой
    public QuestionsList(String question, String option1, String option2, String option3,
                         String option4, String answer, String userSelectedAnswer, int imageResource) {
        this(question, option1, option2, option3, option4, answer, userSelectedAnswer);
        this.imageResource = imageResource;
    }

    // 🔹 Геттеры
    public String getAnswer() {
        return answer;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getQuestion() {
        return question;
    }

    public String getUserSelectedAnswer() {
        return userSelectedAnswer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setUserSelectedAnswer(String userSelectedAnswer) {
        this.userSelectedAnswer = userSelectedAnswer;
    }

    public int getImageResource() {
        return imageResource;
    }

    // 🔹 Метод для проверки наличия изображения
    public boolean hasImage() {
        return imageResource != -1; // Если imageResource не равен -1, значит, изображение есть
    }
}
