package com.smiling.buddah.service;

import com.smiling.buddah.entity.Blog;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BlogService {
    Blog createBlog(Blog blog);
    Blog getBlogById(Long id);
    List<Blog> getAllBlogs();
}
