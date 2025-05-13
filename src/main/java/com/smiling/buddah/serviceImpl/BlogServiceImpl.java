package com.smiling.buddah.serviceImpl;

import com.smiling.buddah.entity.Blog;
import com.smiling.buddah.repository.BlogRepository;
import com.smiling.buddah.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    private  BlogRepository blogRepository;

    public void setBlogRepository(BlogRepository blogRepository) {
        this.blogRepository=blogRepository;
    }
    @Override
    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }
}
