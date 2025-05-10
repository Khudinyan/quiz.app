package com.example.quiz;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {

    // Метод для получения вопросов по столицам
    private static List<QuestionsList> capitalQuestions(String level) {
        final List<QuestionsList> questionsList = new ArrayList<>();

        questionsList.add(new QuestionsList("Какая столица у Австралии?", "а) Сидней", "б) Мельбурн", "в) Канберра", "г) Брисбен", "в) Канберра", ""));
        questionsList.add(new QuestionsList("Как называется столица Канады?", "а) Торонто", "б) Ванкувер", "в) Оттава", "г) Монреаль", "в) Оттава", ""));
        questionsList.add(new QuestionsList("Столица Бразилии — это:", "а) Рио-де-Жанейро", "б) Сан-Паулу", "в) Бразилия", "г) Салвадор", "в) Бразилия", ""));
        questionsList.add(new QuestionsList("Какой город является столицей Турции?", "а) Стамбул", "б) Анкара", "в) Измир", "г) Анталья", "б) Анкара", ""));
        questionsList.add(new QuestionsList("Какая столица у Южной Кореи?", "а) Пусан", "б) Сеул", "в) Инчхон", "г) Тэгу", "б) Сеул", ""));
        questionsList.add(new QuestionsList("Столица Египта — это:", "а) Александрия", "б) Каир", "в) Гиза", "г) Луксор", "б) Каир", ""));
        questionsList.add(new QuestionsList("Как называется столица ЮАР? (Официальная, административная)", "а) Кейптаун", "б) Претория", "в) Йоханнесбург", "г) Дурбан", "б) Претория", ""));
        questionsList.add(new QuestionsList("Какая столица у Аргентины?", "а) Кордова", "б) Росарио", "в) Буэнос-Айрес", "г) Мендоса", "в) Буэнос-Айрес", ""));
        questionsList.add(new QuestionsList("Как называется столица Новой Зеландии?", "а) Окленд", "б) Веллингтон", "в) Крайстчерч", "г) Данидин", "б) Веллингтон", ""));
        questionsList.add(new QuestionsList("Столица Малайзии — это:", "а) Куала-Лумпур", "б) Джорджтаун", "в) Ипох", "г) Кучинг", "а) Куала-Лумпур", ""));

        return questionsList;
    }

    // Метод для получения вопросов по флагам
    private static List<QuestionsList> flagsQuestions(String level) {
        final List<QuestionsList> questionsList = new ArrayList<>();

        questionsList.add(new QuestionsList("Флаг какой страны состоит из трех вертикальных полос: синей, белой и красной?", "а) Италия", "б) Россия", "в) Франция", "г) Нидерланды", "в) Франция", ""));
        questionsList.add(new QuestionsList("На флаге какой страны изображен красный круг на белом фоне?", "а) Китай", "б) Япония", "в) Южная Корея", "г) Вьетнам", "б) Япония", ""));
        questionsList.add(new QuestionsList("Какой флаг имеет черный, красный и желтый горизонтальные полосы?", "а) Бельгия", "б) Германия", "в) Украина", "г) Эфиопия", "б) Германия", ""));
        questionsList.add(new QuestionsList("Флаг какой страны называют \"Юнион Джек\"?", "а) США", "б) Австралия", "в) Великобритания", "г) Канада", "в) Великобритания", ""));
        questionsList.add(new QuestionsList("На флаге какой страны изображен кленовый лист?", "а) Швейцария", "б) Канада", "в) Норвегия", "г) Финляндия", "б) Канада", ""));
        questionsList.add(new QuestionsList("Какой флаг имеет пять желтых звезд на красном фоне?", "а) Северная Корея", "б) Вьетнам", "в) Китай", "г) Сингапур", "в) Китай", ""));
        questionsList.add(new QuestionsList("Флаг какой страны состоит из красного креста на белом фоне?", "а) Швеция", "б) Дания", "в) Швейцария", "г) Норвегия", "в) Швейцария", ""));
        questionsList.add(new QuestionsList("Какой флаг имеет зеленый фон с белым полумесяцем и звездой?", "а) Пакистан", "б) Турция", "в) Алжир", "г) Малайзия", "б) Турция", ""));
        questionsList.add(new QuestionsList("На флаге какой страны изображены четыре звезды и синий крест?", "а) Новая Зеландия", "б) Австралия", "в) Самоа", "г) Фиджи", "г) Фиджи", ""));
        questionsList.add(new QuestionsList("Флаг какой страны состоит из 14 горизонтальных красно-белых полос и синего квадрата с желтым полумесяцем и звездой?", "а) Индонезия", "б) Малайзия", "в) Сингапур", "г) Таиланд", "б) Малайзия", ""));

        return questionsList;
    }

    // Метод для получения вопросов по континентам
    private static List<QuestionsList> continentsQuestions(String level) {
        final List<QuestionsList> questionsList = new ArrayList<>();
        switch (level) {
            case "easy":
                questionsList.add(new QuestionsList("Какая страна известна своими пирамидами?", "а) Египет", "б) Индия", "в) Франция", "г) Япония", "а) Египет", ""));
                questionsList.add(new QuestionsList("Какой материк называется \"чёрным континентом\"?", "а) Азия", "б) Африка", "в) Америка", "г) Европа", "б) Африка", ""));
                questionsList.add(new QuestionsList("Какой океан самый большой по площади?", "а) Атлантический океан", "б) Индийский океан", "в) Тихий океан", "г) Северный Ледовитый океан", "в) Тихий океан", ""));
                questionsList.add(new QuestionsList("Какая страна является самой крупной по территории в Южной Америке?", "а) Бразилия", "б) Аргентина", "в) Чили", "г) Колумбия", "а) Бразилия", ""));
                questionsList.add(new QuestionsList("Какой континент называют \"страной контрастов\"?", "а) Австралия", "б) Южная Америка", "в) Азия", "г) Африка", "а) Австралия", ""));
                break;

            case "medium":
                questionsList.add(new QuestionsList("Какой океан находится между Африкой и Австралией?", "а) Атлантический океан", "б) Индийский океан", "в) Тихий океан", "г) Северный Ледовитый океан", "б) Индийский океан", ""));
                questionsList.add(new QuestionsList("Какой материк считается родиной пингвинов?", "а) Антарктида", "б) Южная Америка", "в) Африка", "г) Австралия", "а) Антарктида", ""));
                break;

            case "hard":
                questionsList.add(new QuestionsList("Какой континент является родиной крупнейших джунглей?", "а) Азия", "б) Южная Америка", "в) Африка", "г) Австралия", "б) Южная Америка", ""));
                questionsList.add(new QuestionsList("На каком континенте расположены самые высокие горы Земли?", "а) Европа", "б) Азия", "в) Южная Америка", "г) Африка", "б) Азия", ""));
                break;
        }
        return questionsList;
    }

    // Метод для получения вопросов по выбранной теме и уровню
    public static List<QuestionsList> getQuestions(String selectedTopicName, String level) {
        switch (selectedTopicName) {
            case "capital":
                return capitalQuestions(level);
            case "flags":
                return flagsQuestions(level);
            case "continents":
                return continentsQuestions(level);
        }
        return continentsQuestions(level);
    }
}
