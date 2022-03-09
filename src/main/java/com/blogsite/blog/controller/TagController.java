package com.blogsite.blog.controller;

import com.blogsite.blog.domain.constant.ControllerConstrant;
import com.blogsite.blog.domain.data.ServiceResponseData;
import com.blogsite.blog.domain.data.TagDto;
import com.blogsite.blog.domain.enums.ProcessStatus;
import com.blogsite.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hkaynar on 12.12.2021
 */
@RestController
@RequestMapping(ControllerConstrant.VERSION_V1 + ControllerConstrant.TAGS)
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public ServiceResponseData getTags() {
        var posts = tagService.getTags();
        var responseData = new ServiceResponseData();
        responseData.setData(posts);
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @GetMapping(ControllerConstrant.ID)
    public ServiceResponseData getTag(@PathVariable long id) {
        var posts = tagService.getTag(id);
        var responseData = new ServiceResponseData();
        responseData.setData(posts);
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @PostMapping
    public ServiceResponseData saveTag(@RequestBody TagDto tagDto) {
        tagService.save(tagDto);
        var responseData = new ServiceResponseData();
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @PutMapping(ControllerConstrant.ID)
    public ServiceResponseData updateTag(@RequestBody TagDto tagDto, @PathVariable long id) {
        tagService.update(tagDto, id);
        var responseData = new ServiceResponseData();
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @DeleteMapping(ControllerConstrant.ID)
    public ServiceResponseData deleteTag(@PathVariable long id) {
        tagService.delete(id);
        var responseData = new ServiceResponseData();
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }
}
