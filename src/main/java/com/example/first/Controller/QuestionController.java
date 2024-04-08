package com.example.first.Controller;

import com.example.first.Exception.ResourceNotFoundException;
import com.example.first.Model.DAO.Member;
import com.example.first.Model.DAO.Question;
import com.example.first.Model.DTO.Request.CreateMemberRequest;
import com.example.first.Model.DTO.Request.CreateQuestionRequest;
import com.example.first.Model.DTO.Response.CreateQuestionResponse;
import com.example.first.Repository.MemberRepository;
import com.example.first.Repository.QuestionRepositary;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/questions")
@Validated
public class QuestionController {
    @Autowired
    private QuestionRepositary questionRepositary;
    @Autowired
    private MemberRepository memberRepository;

    @PostMapping
    public CreateQuestionResponse createQuestion(
            @RequestBody @Valid CreateQuestionRequest request
    ){
        Optional<Member> findMeberOpt = memberRepository.findById(request.getAuthorId());

        if (findMeberOpt.isEmpty()){
            throw new ResourceNotFoundException("Member is not Found id : " + request.getAuthorId());
        }

        Member findMember = findMeberOpt.get();
        Question newQuestion = request.toQuestion();
        newQuestion.setAuthor(findMember);

        return CreateQuestionResponse.of(
                questionRepositary.save(newQuestion));
    }
}
