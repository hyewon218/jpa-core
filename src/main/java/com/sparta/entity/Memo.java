package com.sparta.entity;

import jakarta.persistence.*;

// Entity class랑 테이블이랑 맵핑
// 1. 테이블이 없는 상태에서 이 정보로 테이블을 만들 때
// 2. 이미 테이블은 만들어져 있고 그 테이블을 Entity 랑 맵핑할 때 - 조심해야 함!!! 어떤 옵션이 걸려있고 어떤 전략이 constraint가 걸려있는지 분석하기
@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Table(name = "memo") // 매핑할 테이블의 이름을 지정
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 어떻게 테이블이 다시 만들어지는지
    private Long id;

    // nullable: null 허용 여부
    // unique: 중복 허용 여부 (false 일때 중복 허용)
    // 데이터베이스의 username과 private String username; 이 필드를 맵핑하겠다.
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    // length: 컬럼 길이 지정
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;
}