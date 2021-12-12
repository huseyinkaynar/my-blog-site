package com.blogsite.blog.service.imp;

import com.blogsite.blog.domain.data.PostCommentDto;
import com.blogsite.blog.domain.model.PostCommentModel;
import com.blogsite.blog.repository.PostCommentDao;
import com.blogsite.blog.service.ModelService;
import com.blogsite.blog.service.PostCommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hkaynar on 12.12.2021
 */
@Service
public class PostCommentServiceImpl implements PostCommentService {
    @Autowired
    private PostCommentDao postCommentDao;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ModelService modelService;

    @Override
    public List<PostCommentDto> getPostComments() {
        var postComments = postCommentDao.findAll();
        var postCommentDtoList = List.of(modelMapper.map(postComments, PostCommentDto[].class));

        return postCommentDtoList;
    }

    @Override
    public PostCommentDto getPostComment(Long id) {
        var postComment = postCommentDao.getPostCommentModelById(id);
        var postCommentDto = modelMapper.map(postComment, PostCommentDto.class);

        return postCommentDto;
    }

    @Override
    public void save(PostCommentDto postCommentDto) {
        var postComment = modelMapper.map(postCommentDto, PostCommentModel.class);
        modelService.save(postComment);
    }

    @Override
    public void update(PostCommentDto postCommentDto, Long id) {
        var postComment = postCommentDao.getPostCommentModelById(id);
        modelMapper.map(postCommentDto, postComment);
        modelService.save(postComment);
    }

    @Override
    public void delete(Long id) {
        var postComment = postCommentDao.getPostCommentModelById(id);
        modelService.remove(postComment);
    }
}
