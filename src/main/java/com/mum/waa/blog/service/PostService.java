package com.mum.waa.blog.service;

import org.springframework.data.domain.Page;

import com.mum.waa.blog.model.Post;
import com.mum.waa.blog.model.User;

import java.util.Optional;

public interface PostService {

    Optional<Post> findForId(Long id);

    Post save(Post post);

    /**
     * Finds a {@link Page) of {@link Post} of provided user ordered by date
     */
    Page<Post> findByUserOrderedByDatePageable(User user, int page);

    /**
     * Finds a {@link Page) of all {@link Post} ordered by date
     */
    Page<Post> findAllOrderedByDatePageable(int page);

    void delete(Post post);
}
