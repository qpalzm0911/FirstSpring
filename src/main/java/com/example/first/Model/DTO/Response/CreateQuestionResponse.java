package com.example.first.Model.DTO.Response;

import com.example.first.Model.DAO.Question;
import com.example.first.Model.DTO.Request.CreateQuestionRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateQuestionResponse {
    private Long questionId;
    private String title;
    private String content;
    private GetMemberResponse author;
    public static CreateQuestionResponse of(Question question) {
        return CreateQuestionResponse.builder()
                .questionId(question.getQuestionId())
                .title(question.getTitle())
                .content(question.getContent())
                .author(GetMemberResponse.of(question.getAuthor()))
                .build();

    }
}
