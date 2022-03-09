package com.blogsite.blog.controller;

import com.blogsite.blog.domain.constant.ControllerConstrant;
import com.blogsite.blog.domain.data.CategoryDto;
import com.blogsite.blog.domain.data.ServiceResponseData;
import com.blogsite.blog.domain.enums.ProcessStatus;
import com.blogsite.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hkaynar on 12.12.2021
 */
@RestController
@RequestMapping(ControllerConstrant.VERSION_V1 + ControllerConstrant.CATEGORIES)
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ServiceResponseData getCategories() {
        var posts = categoryService.getCategories();
        var responseData = new ServiceResponseData();
        responseData.setData(posts);
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @GetMapping(ControllerConstrant.ID)
    public ServiceResponseData getCategory(@PathVariable long id) {
        var posts = categoryService.getCategory(id);
        var responseData = new ServiceResponseData();
        responseData.setData(posts);
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @PostMapping
    public ServiceResponseData saveCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.save(categoryDto);
        var responseData = new ServiceResponseData();
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @PutMapping(ControllerConstrant.ID)
    public ServiceResponseData updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable long id) {
        categoryService.update(categoryDto, id);
        var responseData = new ServiceResponseData();
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }

    @DeleteMapping(ControllerConstrant.ID)
    public ServiceResponseData deleteCategory(@PathVariable long id) {
        categoryService.delete(id);
        var responseData = new ServiceResponseData();
        responseData.setStatus(ProcessStatus.SUCCESS);
        return responseData;
    }
}
