package com.boardmaster.boardmasterapi.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <a href="https://www.inflearn.com/questions/16570">참고</a>
 *<p>
 * 영속성 컨텍스트는 엔티티의 PK를 사용해서 엔티티를 관리하는데,
 * JPA를 구현한 하이버네이트 입장에서 지금 PK가 아닌 다른 기준(UNIQUE 필드)으로 데이터를 한번 조회하고,
 * 그 결과에 있는 PK를 다시 찾은 다음에 영속성 컨텍스트에 관리해야 합니다. 이 속에서는 엔티티를 생성하고 관리하는 복잡한 라이프사이클도 있구요.
 * 이 복잡한 과정을 풀어내기 위해 하이버네이트 구현체는 객체를 임시로 직렬화(Serializable)해서 메모리에 올려두는 작업을 하는 것 같습니다.
 * 결국 자바의 직렬화 기능을 사용하려면 해당 클래스에 Serializable 마커 인터페이스를 구현해야 합니다.
 * (출처 -인프런 김영한님 답글)
 * </p>
 */
@Entity
@Getter
@Table(name = "participant")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Participant implements Serializable {

    @Id
    @ManyToOne(targetEntity = Article.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article articles;

    @Id
    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @CreatedDate
    private LocalDateTime createTime;
}
