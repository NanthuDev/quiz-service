package com.nkspring.quiz_service.model;

import lombok.Data;

@Data
public class QuizDto {
    String categoryName;
    Integer numOfQ;
    String title;
}
