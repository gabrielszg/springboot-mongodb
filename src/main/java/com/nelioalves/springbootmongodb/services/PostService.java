package com.nelioalves.springbootmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.springbootmongodb.domain.Post;
import com.nelioalves.springbootmongodb.repositories.PostRepository;
import com.nelioalves.springbootmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));  
	}
	
	public List<Post> findByTitle(String text) {
		return postRepository.findByTitle(text);
	}
	
}
