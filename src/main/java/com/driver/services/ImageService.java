package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Image image = new Image();
        image.setDimensions(dimensions);
        image.setDescription(description);

        Blog blog = blogRepository2.findById(blogId).get();
        image.setBlog(blog);

        List<Image> imageList = blog.getImageList();
        imageList.add(image);

        blogRepository2.save(blog);
        return image;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Blog blog = blogRepository2.findById(id).get();
        int countImages = 0;
        for(Image image : blog.getImageList()) {
            if(image.getDimensions().equals(screenDimensions)) {
                countImages++;
            }
        }
        return countImages;
    }
}
