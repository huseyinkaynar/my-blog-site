package com.blogsite.blog.controller;

import com.blogsite.blog.domain.constant.ControllerConstrant;
import com.blogsite.blog.domain.data.PostCommentDto;
import com.blogsite.blog.domain.data.ServiceResponseData;
import com.blogsite.blog.domain.enums.ProcessStatus;
import com.blogsite.blog.service.PostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hkaynar on 12.12.2021
 */
@RestController
@RequestMapping(ControllerConstrant.VERSION_V1 + ControllerConstrant.POST_COMMENTS)
public class PostCommentController {

    @Autowired
    private PostCommentService postCommentService;

    @GetMapping
    public ServiceResponseData getPostCommets() {
        var posts = postCommentService.getPostComments();
        var responseData = new ServiceResponseData();
        responseData.setData(posts);
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @GetMapping(ControllerConstrant.ID)
    public ServiceResponseData getPostCommet(@PathVariable long id) {
        var posts = postCommentService.getPostComment(id);
        var responseData = new ServiceResponseData();
        responseData.setData(posts);
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @PostMapping
    public ServiceResponseData savePostCommet(@RequestBody PostCommentDto postCommentDto) {
        postCommentService.save(postCommentDto);
        var responseData = new ServiceResponseData();
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @PutMapping(ControllerConstrant.ID)
    public ServiceResponseData updatePostCommet(@RequestBody PostCommentDto postCommentDto, @PathVariable long id) {
        postCommentService.update(postCommentDto, id);
        var responseData = new ServiceResponseData();
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @DeleteMapping(ControllerConstrant.ID)
    public ServiceResponseData deletePostCommet(@PathVariable long id) {
        postCommentService.delete(id);
        var responseData = new ServiceResponseData();
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }
}
