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
public class GetMemberResponse {
    private Long memberId;
    private String loginId;

    public static GetMemberResponse of(Member member) {
        return GetMemberResponse.builder()
                .memberId(member.getMemberId())
                .loginId(member.getLoginId())
                .build();
    }
}
