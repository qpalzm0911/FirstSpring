package com.example.first.Model.DTO.Request;

import com.example.first.Model.DAO.Member;
import com.example.first.Model.DAO.Question;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateQuestionRequest {
    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private Long authorId;

    public Question toQuestion(){
        return Question.builder()
                .title(this.title)
                .content(this.content)
                .build();
    }
}
