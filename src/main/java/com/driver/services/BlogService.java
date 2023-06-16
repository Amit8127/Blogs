package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setPubDate(new Date());
        blog = blogRepository1.save(blog);

        Optional<User> userOpt = userRepository1.findById(userId);
        User user = userOpt.get();

        List<Blog> blogs = new ArrayList<>();
        blogs.add(blog);
        user.setBlogList(blogs);

        userRepository1.save(user);
        return blog;
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        Optional<Blog> blogOpt = blogRepository1.findById(blogId);
        Blog blog = blogOpt.get();

        blog.getImageList().clear();
        blogRepository1.delete(blog);
    }
}
