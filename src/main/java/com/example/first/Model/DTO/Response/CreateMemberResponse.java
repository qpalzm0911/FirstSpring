package com.example.first.Model.DTO.Response;

import com.example.first.Model.DAO.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateMemberResponse {
    private Long memberId;
    private String loginId;

    public static CreateMemberResponse of(Member member) {
        return CreateMemberResponse.builder()
                .memberId(member.getMemberId())
                .loginId(member.getLoginId())
                .build();
    }
}
