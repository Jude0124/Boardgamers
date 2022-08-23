package com.boardmaster.boardmasterapi.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    @Column(nullable = false)
    private String userId;
    @Column(nullable = false)
    private String email;
    private String password;
    private String nickname;
    @Column(nullable = false)
    private String phone;
//    @OneToMany(mappedBy = "member")
//    private List<Article> articles = new ArrayList<>();

    @Builder
    public Member(Long id, String userId, String email, String password, String nickname, String phone) {
        this.id = id;
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.phone = phone;
    }
}
