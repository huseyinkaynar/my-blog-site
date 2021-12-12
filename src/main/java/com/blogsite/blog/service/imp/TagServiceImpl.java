package com.blogsite.blog.service.imp;

import com.blogsite.blog.domain.data.TagDto;
import com.blogsite.blog.domain.model.TagModel;
import com.blogsite.blog.repository.TagDao;
import com.blogsite.blog.service.ModelService;
import com.blogsite.blog.service.TagService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hkaynar on 12.12.2021
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ModelService modelService;

    @Override
    public List<TagDto> getTags() {
        var tags = tagDao.findAll();
        var tagDtoList = List.of(modelMapper.map(tags, TagDto[].class));
        return tagDtoList;
    }

    @Override
    public TagDto getTag(Long id) {
        var tag = tagDao.getTagModelById(id);
        var tagDto = modelMapper.map(tag, TagDto.class);
        return tagDto;
    }

    @Override
    public void save(TagDto tagDto) {
        var tag = modelMapper.map(tagDto, TagModel.class);
        modelService.save(tag);
    }

    @Override
    public void update(TagDto tagDto, Long id) {
        var tag = tagDao.getTagModelById(id);
        modelMapper.map(tagDto, tag);
        modelService.save(tag);
    }

    @Override
    public void delete(Long id) {
        var tag = tagDao.getTagModelById(id);
        modelService.remove(tag);
    }
}
