package com.boardmaster.boardmasterapi.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import java.io.Serializable;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantId implements Serializable {
    //@JoinColumn(name = "article_id")
    private Article article;
    //@JoinColumn(name = "member_id")
    private Member member;
}
