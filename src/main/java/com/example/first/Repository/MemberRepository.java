package com.example.first.Repository;

import com.example.first.Model.DAO.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
//레포지토리 선언방법
