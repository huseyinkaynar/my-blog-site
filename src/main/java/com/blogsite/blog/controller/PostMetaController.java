package com.blogsite.blog.controller;

import com.blogsite.blog.domain.constant.ControllerConstrant;
import com.blogsite.blog.domain.data.PostMetaDto;
import com.blogsite.blog.domain.data.ServiceResponseData;
import com.blogsite.blog.domain.enums.ProcessStatus;
import com.blogsite.blog.service.PostMetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hkaynar on 12.12.2021
 */
@RestController
@RequestMapping(ControllerConstrant.VERSION_V1 + ControllerConstrant.POST_METAS)
public class PostMetaController {

    @Autowired
    private PostMetaService postMetaService;

    @GetMapping
    public ServiceResponseData getPostMetas() {
        var posts = postMetaService.getPostMetas();
        var responseData = new ServiceResponseData();
        responseData.setData(posts);
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @GetMapping(ControllerConstrant.ID)
    public ServiceResponseData getPostMeta(@PathVariable long id) {
        var posts = postMetaService.getPostMeta(id);
        var responseData = new ServiceResponseData();
        responseData.setData(posts);
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @PostMapping
    public ServiceResponseData savePostMeta(@RequestBody PostMetaDto postMetaDto) {
        postMetaService.save(postMetaDto);
        var responseData = new ServiceResponseData();
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @PutMapping(ControllerConstrant.ID)
    public ServiceResponseData updatePostMeta(@RequestBody PostMetaDto postMetaDto, @PathVariable long id) {
        postMetaService.update(postMetaDto, id);
        var responseData = new ServiceResponseData();
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @DeleteMapping(ControllerConstrant.ID)
    public ServiceResponseData deletePostMeta(@PathVariable long id) {
        postMetaService.delete(id);
        var responseData = new ServiceResponseData();
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }
}
