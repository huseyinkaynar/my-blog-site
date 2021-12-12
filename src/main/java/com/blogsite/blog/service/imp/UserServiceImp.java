package com.blogsite.blog.service.imp;

import com.blogsite.blog.domain.data.UserDto;
import com.blogsite.blog.domain.model.UserModel;
import com.blogsite.blog.repository.UserDao;
import com.blogsite.blog.service.ModelService;
import com.blogsite.blog.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hkaynar on 11.12.2021
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ModelService modelService;

    @Override
    public List<UserDto> getUsers() {
        var users = userDao.findAll();
        var userDataList = List.of(modelMapper.map(users, UserDto[].class));
        return userDataList;
    }

    @Override
    public UserDto getUser(Long id) {
        var user = userDao.getUserModelById(id);
        var userData = modelMapper.map(user, UserDto.class);
        return userData;
    }

    @Override
    public void save(UserDto userDto) {
        var user = modelMapper.map(userDto, UserModel.class);
        modelService.save(user);
    }

    @Override
    public void update(UserDto userDto, Long id) {
        var user = userDao.getUserModelById(id);
        modelMapper.map(userDto, user);
        modelService.save(user);
    }

    @Override
    public void delete(Long id) {
        var user = userDao.getUserModelById(id);
        modelService.remove(user);
    }
}
