package com.mum.waa.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mum.waa.blog.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
