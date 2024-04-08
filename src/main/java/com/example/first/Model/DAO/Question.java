package com.example.first.Model.DAO;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor//기본생성자
@Builder
@ToString
@Entity
@Getter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(nullable = false, length = 50)
    private String title;
    @Column(nullable = false, length = 1000)
    private String content;

    @ManyToOne
    @JoinColumn
    private Member author;

    public void setAuthor(Member member){
        this.author = member;
        member.getQuestion().add(this);
    }
}
