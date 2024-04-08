package com.example.first.Controller;

import com.example.first.Exception.ResourceNotFoundException;
import com.example.first.Model.DAO.Member;
import com.example.first.Model.DTO.Request.CreateMemberRequest;
import com.example.first.Model.DTO.Response.CreateMemberResponse;
import com.example.first.Model.DTO.Response.GetMemberResponse;
import com.example.first.Repository.MemberRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/members")
@Validated
public class MeberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/{memberId}")
    public GetMemberResponse getUserById(
            @PathVariable Long memberId
    ) throws ReflectiveOperationException {
        // 1. memberId에 해당하는 Member 객체 찾아오기
        Optional<Member> findMeberOpt = memberRepository.findById(memberId);

        // 2. 해당하는 Member가 없다면?
        if (findMeberOpt.isEmpty()){
            throw new ResourceNotFoundException("Member is not Found id : " + memberId);
        }
        // 3. 해당하는 Member의 정보를 출력하기
        return GetMemberResponse.of(findMeberOpt.get());

    }

    @PostMapping
    public CreateMemberResponse createMember(
            @RequestBody @Valid CreateMemberRequest request
    ){

        return CreateMemberResponse.of(
                memberRepository.save(request.toMember())
        );
    }
}
