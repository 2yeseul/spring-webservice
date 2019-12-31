package com.example.webservice.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.webservice.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/* 
 * Posts 클래스는 실제 DB 테이블과 매칭되는 클래스 (보통 Entity 클래스라고 함)
 * DB 데이터 작업 시 실제 query를 날리는 것 보다는 이 Entity 클래스를 수정해서 작업
 * 
 * */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Posts extends BaseTimeEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 500, nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String author;
	
	@Builder
	public Posts(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

}
