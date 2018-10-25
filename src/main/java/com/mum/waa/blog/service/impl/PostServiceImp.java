package com.mum.waa.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mum.waa.blog.model.Post;
import com.mum.waa.blog.model.User;
import com.mum.waa.blog.repository.PostRepository;
import com.mum.waa.blog.service.PostService;

import java.util.Optional;

@Service
@Transactional
public class PostServiceImp implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImp(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Optional<Post> findForId(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Page<Post> findByUserOrderedByDatePageable(User user, int page) {
        return postRepository.findByUserOrderByCreateDateDesc(user, new PageRequest(subtractPageByOne(page), 5));
    }

    @Override
    public Page<Post> findAllOrderedByDatePageable(int page) {
        return postRepository.findAllByOrderByCreateDateDesc(new PageRequest(subtractPageByOne(page), 5));
    }

    @Override
    public void delete(Post post) {
        postRepository.delete(post);
    }

    private int subtractPageByOne(int page){
        return (page < 1) ? 0 : page - 1;
    }
}
