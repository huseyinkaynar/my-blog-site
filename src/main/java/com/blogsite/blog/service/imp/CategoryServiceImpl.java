package com.blogsite.blog.service.imp;

import com.blogsite.blog.domain.data.CategoryDto;
import com.blogsite.blog.domain.model.CategoryModel;
import com.blogsite.blog.repository.CategoryDao;
import com.blogsite.blog.service.CategoryService;
import com.blogsite.blog.service.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hkaynar on 12.12.2021
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ModelService modelService;

    @Override
    public List<CategoryDto> getCategories() {
        var categories = categoryDao.findAll();
        var categoryDtoList = List.of(modelMapper.map(categories, CategoryDto[].class));
        return categoryDtoList;
    }

    @Override
    public CategoryDto getCategory(Long id) {
        var category = categoryDao.getCategoryModelById(id);
        var categoryDto = modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }

    @Override
    public void save(CategoryDto categoryDto) {
        var category = modelMapper.map(categoryDto, CategoryModel.class);
        modelService.save(category);
    }

    @Override
    public void update(CategoryDto categoryDto, Long id) {
        var category = categoryDao.getCategoryModelById(id);
        modelMapper.map(categoryDto, category);
        modelService.save(category);
    }

    @Override
    public void delete(Long id) {
        var category = categoryDao.getCategoryModelById(id);
        modelService.remove(category);

    }
}
