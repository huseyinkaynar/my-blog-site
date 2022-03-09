package com.blogsite.blog.service.imp;

import com.blogsite.blog.domain.data.PostMetaDto;
import com.blogsite.blog.domain.model.PostMetaModel;
import com.blogsite.blog.domain.model.PostModel;
import com.blogsite.blog.repository.PostMetaDao;
import com.blogsite.blog.service.ModelService;
import com.blogsite.blog.service.PostMetaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hkaynar on 12.12.2021
 */
@Service
public class PostMetaServiceImpl implements PostMetaService {
    @Autowired
    private PostMetaDao postMetaDao;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ModelService modelService;

    @Override
    public List<PostMetaDto> getPostMetas() {
        var postMetas = postMetaDao.findAll();
        var postMetaDtoList = List.of(modelMapper.map(postMetas, PostMetaDto[].class));

        return postMetaDtoList;
    }

    @Override
    public PostMetaDto getPostMeta(Long id) {
        var postMeta = postMetaDao.getPostMetaModelById(id);
        var postDto = modelMapper.map(postMeta, PostMetaDto.class);
        return postDto;
    }

    @Override
    public void save(PostMetaDto postMetaDto) {
        var postMeta = modelMapper.map(postMetaDto, PostMetaModel.class);
        modelService.save(postMeta);
    }

    @Override
    public void update(PostMetaDto postMetaDto, Long id) {
        var postMeta = postMetaDao.getPostMetaModelById(id);
        postMeta.setPost(modelMapper.map(postMetaDto.getPost(), PostModel.class));
        modelMapper.map(postMetaDto, postMeta);
        modelService.save(postMeta);
    }

    @Override
    public void delete(Long id) {
        var postMeta = postMetaDao.getPostMetaModelById(id);
        modelService.remove(postMeta);
    }
}
