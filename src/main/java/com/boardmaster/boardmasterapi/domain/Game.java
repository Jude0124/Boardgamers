package com.boardmaster.boardmasterapi.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "game")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long id;
    /**
     * 게임과 게시글은 다대일 관계(N:1)
     * 1개의 게시글에는 여러개의 게임이 존재
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "articles_id")
    private Article articles;
    private String gameName;
}
