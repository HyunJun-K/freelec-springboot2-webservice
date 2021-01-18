package com.springboot.exam.domain;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;


    //MapperdSuperclass JPA Entity 클래스들이 상속할 경우 필드들도 칼럼으로 인식하게 한다
    //EntityListeners 클래스에 Auditing 기능을 포함시킴
    //CreatedDate Entity가 생성될때마다 자동으로 시간이 저장
    //LastModifiedDate 조회 한 Entitiy의 값이 변경할때 시간이 자동 저장


}

