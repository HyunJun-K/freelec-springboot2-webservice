package com.springboot.exam.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity //Entity ( 테이블과 링크될 클래스 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭)
public class Posts {

    //JAP 사용하기
    //Entity Calss


    @Id // 해당 테이블의 PK ID는 왠만하면 Long 타입의 Auto_increment를 추천함
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙 GenerationType.IDENTITY 옵션을 추가해야지만 increment가됨
    private Long id;

    @Column(length=500, nullable = false)
    //테이블 컬럼을 나타대며 굳이 선언하지 않아도 해당 클래스 필드의 컬럼이 됨
    //기본 사이즈는 255, type을 변경하고 싶을떄
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private  String content;

    private  String author;


    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;

    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}



