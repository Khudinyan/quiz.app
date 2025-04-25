package com.example.quiz;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {

    private static List<QuestionsList> capitalQuestions() {

        final List<QuestionsList> questionsList = new ArrayList<>();
        final QuestionsList question1 = new QuestionsList("Какая столица у Австралии?",
                "а) Сидней", "б) Мельбурн", "в) Канберра", "г) Брисбен",
                "в) Канберра", "");

        final QuestionsList question2 = new QuestionsList("Как называется столица Канады??",
                "а) Торонто", "б) Ванкувер", "в) Оттава", "г) Монреаль",
                "в) Оттава", "");

        final QuestionsList question3 = new QuestionsList("Столица Бразилии — это:",
                "а) Рио-де-Жанейро", "б) Сан-Паулу", "в) Бразилия", "г) Салвадор",
                "в) Бразилия", "");

        final QuestionsList question4 = new QuestionsList("Какой город является столицей Турции?",
                "а) Стамбул", "б) Анкара", "в) Измир", "г) Анталья",
                "б) Анкара", "");

        final QuestionsList question5 = new QuestionsList("Какая столица у Южной Кореи?",
                "а) Пусан", "б) Сеул", "в) Инчхон", "г) Тэгу",
                "б) Сеул", "");

        final QuestionsList question6 = new QuestionsList("Столица Египта — это:",
                "а) Александрия", "б) Каир", "в) Гиза", "г) Луксор",
                "б) Каир", "");

        final QuestionsList question7 = new QuestionsList("Как называется столица ЮАР? (Официальная, административная)",
                "а) Кейптаун", "б) Претория", "в) Йоханнесбург", "г) Дурбан",
                "б) Претория", "");

        final QuestionsList question8 = new QuestionsList("Какая столица у Аргентины?",
                "а) Кордова", "б) Росарио", "в) Буэнос-Айрес", "г) Мендоса",
                "в) Буэнос-Айрес", "");

        final QuestionsList question9 = new QuestionsList("Как называется столица Новой Зеландии?",
                "а) Окленд", "б) Веллингтон", "в) Крайстчерч", "г) Данидин",
                "б) Веллингтон", "");

        final QuestionsList question10 = new QuestionsList("Столица Малайзии — это:",
                "а) Куала-Лумпур", "б) Джорджтаун", "в) Ипох", "г) Кучинг",
                "а) Куала-Лумпур", "");

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);


        return questionsList;

    }


    private static List<QuestionsList> flagsQuestions() {
        final List<QuestionsList> questionsList = new ArrayList<>();

        // Removed extra spaces after answers
        final QuestionsList question1 = new QuestionsList("Флаг какой страны состоит из трех вертикальных полос: синей, белой и красной?",
                "а) Италия", "б) Россия", "в) Франция", "г) Нидерланды",
                "в) Франция", "");

        final QuestionsList question2 = new QuestionsList("На флаге какой страны изображен красный круг на белом фоне?",
                "а) Китай", "б) Япония", "в) Южная Корея", "г) Вьетнам",
                "б) Япония", "");  // Removed space after answer

        final QuestionsList question3 = new QuestionsList("Какой флаг имеет черный, красный и желтый горизонтальные полосы?",
                "а) Бельгия", "б) Германия", "в) Украина", "г) Эфиопия",
                "б) Германия", "");  // Removed space after answer

        final QuestionsList question4 = new QuestionsList("Флаг какой страны называют \"Юнион Джек\"?",
                "а) США", "б) Австралия", "в) Великобритания", "г) Канада",
                "в) Великобритания", "");  // Removed space after answer

        final QuestionsList question5 = new QuestionsList("На флаге какой страны изображен кленовый лист?",
                "а) Швейцария", "б) Канада", "в) Норвегия", "г) Финляндия",
                "б) Канада", "");  // Removed space after answer

        final QuestionsList question6 = new QuestionsList("Какой флаг имеет пять желтых звезд на красном фоне?",
                "а) Северная Корея", "б) Вьетнам", "в) Китай", "г) Сингапур",
                "в) Китай", "");  // Removed space after answer

        final QuestionsList question7 = new QuestionsList("Флаг какой страны состоит из красного креста на белом фоне?",
                "а) Швеция", "б) Дания", "в) Швейцария", "г) Норвегия",
                "в) Швейцария", "");  // Removed space after answer

        final QuestionsList question8 = new QuestionsList("Какой флаг имеет зеленый фон с белым полумесяцем и звездой?",
                "а) Пакистан", "б) Турция", "в) Алжир", "г) Малайзия",
                "б) Турция", "");  // Removed space after answer

        final QuestionsList question9 = new QuestionsList("На флаге какой страны изображены четыре звезды и синий крест?",
                "а) Новая Зеландия", "б) Австралия", "в) Самоа", "г) Фиджи",
                "г) Фиджи", "");  // Removed space after answer

        final QuestionsList question10 = new QuestionsList("Флаг какой страны состоит из 14 горизонтальных красно-белых полос и синего квадрата с желтым полумесяцем и звездой?",
                "а) Индонезия", "б) Малайзия", "в) Сингапур", "г) Таиланд",
                "б) Малайзия", "");  // Removed space after answer

        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);

        return questionsList;
    }

    private static List<QuestionsList> continentsQuestions() {
        final List<QuestionsList> questionsList = new ArrayList<>();

        questionsList.add(new QuestionsList(
                "Это флаг какой страны?",  // или "Угадайте страну по флагу:"
                "а) Германия", "б) Бельгия", "в) Франция", "г) Россия",
                "г) Россия", "",
                R.drawable.img_9  // <-- добавлен ресурс изображения
        ));

        questionsList.add(new QuestionsList(
                "Это флаг какой страны?",
                "а) Канада", "б) США", "в) Великобритания", "г) Австралия",
                "а) Канада", "",
                R.drawable.img_10  // ← имя файла изображения в drawable
        ));


        questionsList.add(new QuestionsList(
                "Это флаг какой страны?",
                "а) Китай", "б) Япония", "в) Южная Корея", "г) Вьетнам",
                "б) Япония", "",
                R.drawable.img_11  // ← имя изображения в drawable
        ));


        questionsList.add(new QuestionsList(
                "Это флаг какой страны?",
                "а) Испания", "б) Португалия", "в) Италия", "г) Франция",
                "в) Италия", "",
                R.drawable.img_12  // указываем id картинки
        ));


        questionsList.add(new QuestionsList(
                "Это флаг какой страны?",
                "а) Египет", "б) Турция", "в) Саудовская Аравия", "г) Иран",
                "б) Турция", "",
                R.drawable.img_13  // ID изображения флага Турции
        ));


        return questionsList;
    }


    public static List<QuestionsList> getQuestions(String selectedTopicName) {
        switch (selectedTopicName) {
            case "capital":
                return capitalQuestions();
            case "flags":
                return flagsQuestions();
            case "continents":  // 👈 добавлена новая тема
                return continentsQuestions();
        }
        return java.util.Collections.emptyList();
    }
}


