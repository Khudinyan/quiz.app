package com.example.quiz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder> {

    private final ArrayList<QuestionModel> questionList;
    private final ArrayList<String> userAnswers;

    public AnswerAdapter(ArrayList<QuestionModel> questionList, ArrayList<String> userAnswers) {
        this.questionList = questionList;
        this.userAnswers = userAnswers;
    }

    @NonNull
    @Override
    public AnswerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_item, parent, false);
        return new AnswerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnswerViewHolder holder, int position) {
        // Проверка, чтобы избежать IndexOutOfBoundsException
        if (questionList != null && userAnswers != null && questionList.size() > position && userAnswers.size() > position) {
            QuestionModel question = questionList.get(position);
            String userAnswer = userAnswers.get(position);
            String correctAnswer = question.getCorrectAnswer();

            // Устанавливаем текст вопросов и ответов
            holder.questionText.setText((position + 1) + ". " + question.getQuestion());
            holder.userAnswerText.setText("Ваш ответ: " + userAnswer);
            holder.correctAnswerText.setText("Правильный ответ: " + correctAnswer);
            holder.explanationText.setText("Объяснение: " + question.getExplanation());

            // Устанавливаем цвет текста для правильных и неправильных ответов
            if (userAnswer.equals(correctAnswer)) {
                holder.userAnswerText.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.green)); // Зеленый цвет
            } else {
                holder.userAnswerText.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.red)); // Красный цвет
            }
        }
    }

    @Override
    public int getItemCount() {
        return questionList != null ? questionList.size() : 0; // Предотвращаем возврат null
    }

    static class AnswerViewHolder extends RecyclerView.ViewHolder {
        TextView questionText, userAnswerText, correctAnswerText, explanationText;

        public AnswerViewHolder(@NonNull View itemView) {
            super(itemView);
            questionText = itemView.findViewById(R.id.questionText);
            userAnswerText = itemView.findViewById(R.id.userAnswerText);
            correctAnswerText = itemView.findViewById(R.id.correctAnswerText);
            explanationText = itemView.findViewById(R.id.explanationText);
        }
    }
}
