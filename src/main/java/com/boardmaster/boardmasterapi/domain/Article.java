package com.boardmaster.boardmasterapi.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "article")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;
    /**
     * 회원과 게시글은 일대다 단방향 관계(1:N)
     * 회원 1명은 여러개의 게시글을 작성 할 수 있다.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    private String title;
    @Enumerated(EnumType.STRING)
    private PartyType type; //ONLINE, OFFLINE
    private int member_count;
    private LocalDateTime meeting_time;
    private String content;
}
