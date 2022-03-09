package com.blogsite.blog.controller;

import com.blogsite.blog.domain.constant.ControllerConstrant;
import com.blogsite.blog.domain.data.PostDto;
import com.blogsite.blog.domain.data.ServiceResponseData;
import com.blogsite.blog.domain.enums.ProcessStatus;
import com.blogsite.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hkaynar on 12.12.2021
 */
@RestController
@RequestMapping(ControllerConstrant.VERSION_V1 + ControllerConstrant.POSTS)
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ServiceResponseData getPosts() {
        var posts = postService.getPosts();
        var responseData = new ServiceResponseData();
        responseData.setData(posts);
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @GetMapping(ControllerConstrant.ID)
    public ServiceResponseData getPost(@PathVariable long id) {
        var posts = postService.getPost(id);
        var responseData = new ServiceResponseData();
        responseData.setData(posts);
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @PostMapping
    public ServiceResponseData savePost(@RequestBody PostDto postDto) {
        postService.save(postDto);
        var responseData = new ServiceResponseData();
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @PutMapping(ControllerConstrant.ID)
    public ServiceResponseData updatePost(@RequestBody PostDto postDto, @PathVariable long id) {
        postService.update(postDto, id);
        var responseData = new ServiceResponseData();
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @DeleteMapping(ControllerConstrant.ID)
    public ServiceResponseData deletePost(@PathVariable long id) {
        postService.delete(id);
        var responseData = new ServiceResponseData();
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }
}
