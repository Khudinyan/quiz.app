package com.example.quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizManager {

    private static QuestionLevel selectedDifficulty; // Переменная для хранения выбранного уровня сложности

    // Метод для установки выбранного уровня сложности
    public static void setSelectedDifficulty(QuestionLevel difficulty) {
        selectedDifficulty = difficulty;
    }

    // Метод для получения вопросов в зависимости от выбранной темы и сложности
    public static List<QuestionModel> getQuestions(String selectedTopicName) {
        if (selectedDifficulty == null) {
            throw new IllegalStateException("Уровень сложности не установлен.");
        }

        switch (selectedTopicName) {
            case "capital":
                return capitalQuestions(selectedDifficulty);
            case "flags":
                return flagsQuestions(selectedDifficulty);
            case "continents":
                return continentsQuestions(selectedDifficulty);
            default:
                throw new IllegalArgumentException("Неизвестная тема: " + selectedTopicName);
        }
    }

    // Пример методов для получения вопросов (вам нужно их реализовать)
    private static List<QuestionModel> capitalQuestions(QuestionLevel difficulty) {
        List<QuestionModel> questionsList = new ArrayList<>();
        switch (difficulty) {
            case EASY:
                questionsList.add(new QuestionModel("Какая столица Франции?", "Париж", List.of("Париж", "Берлин", "Мадрид", "Рим")));
                questionsList.add(new QuestionModel("Какая столица Японии?", "Токио", List.of("Сеул", "Пекин", "Токио", "Бангкок")));
                break;
            case MEDIUM:
                questionsList.add(new QuestionModel("Какая столица Австралии?", "Канберра", List.of("Сидней", "Мельбурн", "Брисбен", "Канберра")));
                questionsList.add(new QuestionModel("Какая столица Канады?", "Оттава", List.of("Торонто", "Ванкувер", "Оттава", "Монреаль")));
                break;
            case HARD:
                questionsList.add(new QuestionModel("Какая столица Казахстана?", "Нур-Султан", List.of("Алма-Ата", "Астана", "Нур-Султан", "Бишкек")));
                questionsList.add(new QuestionModel("Какая столица Бутана?", "Тхимпху", List.of("Паро", "Тхимпху", "Фунтшелинг", "Гелепху")));
                break;
        }
        return questionsList;
    }

    private static List<QuestionModel> flagsQuestions(QuestionLevel difficulty) {
        List<QuestionModel> questionsList = new ArrayList<>();
        switch (difficulty) {
            case EASY:
                questionsList.add(new QuestionModel("Какого цвета флаг Германии?", "Черный, Красный, Золотой", List.of("Черный, Красный, Золотой", "Красный, Белый, Синий", "Зеленый, Желтый, Синий", "Красный, Зеленый, Желтый")));
                break;
            case MEDIUM:
                questionsList.add(new QuestionModel("У какой страны на флаге есть красный круг в центре?", "Япония", List.of("Китай", "Япония", "Южная Корея", "Индия")));
                break;
            case HARD:
                questionsList.add(new QuestionModel("У какой страны на флаге есть красный крест?", "Швейцария", List.of("Швейцария", "Англия", "Дания", "Норвегия")));
                break;
        }
        return questionsList;
    }

    private static List<QuestionModel> continentsQuestions(QuestionLevel difficulty) {
        List<QuestionModel> questionsList = new ArrayList<>();
        switch (difficulty) {
            case EASY:
                questionsList.add(new QuestionModel("На каком континенте находится Австралия?", "Океания", List.of("Азия", "Африка", "Океания", "Европа")));
                break;
            case MEDIUM:
                questionsList.add(new QuestionModel("На каком континенте находится Египет?", "Африка", List.of("Африка", "Азия", "Европа", "Южная Америка")));
                break;
            case HARD:
                questionsList.add(new QuestionModel("На каком континенте наименьшее количество стран?", "Антарктида", List.of("Антарктида", "Австралия", "Азия", "Европа")));
                break;
        }
        return questionsList;
    }
}
