package com.boardmaster.boardmasterapi.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Table(name = "gameinfo")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GameInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gameinfo_id")
    private Long id;
    @NotNull
    private String gameName;
    private int releaseYear;
    private float difficulty;
    private int rank;
    private int score;
    private String publisher;
    private String artwork;
    private String designer;
    private int maxPlayTime;
    private int minPlayTime;
    private int maxNumber;
    private int minNumber;
}
