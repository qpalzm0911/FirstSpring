package com.example.first.Model.DAO;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor//기본생성자
@Builder
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    @Column(nullable = false, length = 1000)
    private String loginId;

    @Column(nullable = false, length = 1000)
    private String password;

    @OneToMany(mappedBy = "author")
    private List<Question> question;

}
