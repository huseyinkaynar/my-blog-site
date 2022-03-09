package com.blogsite.blog.service.imp;

import com.blogsite.blog.domain.data.PostDto;
import com.blogsite.blog.domain.model.PostModel;
import com.blogsite.blog.domain.model.UserModel;
import com.blogsite.blog.repository.PostDao;
import com.blogsite.blog.service.ModelService;
import com.blogsite.blog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hkaynar on 12.12.2021
 */
@Service
public class PostServiceImp implements PostService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ModelService modelService;

    @Override
    public List<PostDto> getPosts() {
        var posts = postDao.findAll();
        var postDtoList = List.of(modelMapper.map(posts, PostDto[].class));
        return postDtoList;
    }

    @Override
    public PostDto getPost(Long id) {
        var post = postDao.getPostModelById(id);
        var postDto = modelMapper.map(post, PostDto.class);
        return postDto;
    }

    @Override
    public void save(PostDto postDto) {
        var post = modelMapper.map(postDto, PostModel.class);
        modelService.save(post);
    }

    @Override
    public void update(PostDto postDto, Long id) {
        var post = postDao.getPostModelById(id);
        post.setUser(modelMapper.map(postDto.getUser(), UserModel.class));
        modelMapper.map(postDto, post);
        modelService.save(post);
    }

    @Override
    public void delete(Long id) {
        var post = postDao.getPostModelById(id);
        modelService.remove(post);
    }
}
