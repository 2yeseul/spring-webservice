package com.example.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webservice.domain.posts.PostsRepository;
import com.example.webservice.dto.posts.PostsMainResponseDto;
import com.example.webservice.dto.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
	private PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }
	
	@Transactional(readOnly = true)
	public List<PostsMainResponseDto> findAllDesc(){
		return postsRepository.findAllDesc()
				.map(PostsMainResponseDto::new)
				.collect(Collectors.toList());
	}
}
