package com.example.first.Model.DTO.Request;

import com.example.first.Model.DAO.Member;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateMemberRequest {
    @NotNull
    private String loginId;
    @NotNull
    private String password;

    public Member toMember(){
        return Member.builder()
                .loginId(this.getLoginId())
                .password(this.getPassword())
                .build();
    }
}
