package com.blogsite.blog.service.imp;

import com.blogsite.blog.domain.model.ItemModel;
import com.blogsite.blog.repository.ModelDao;
import com.blogsite.blog.service.ModelService;
import com.blogsite.blog.service.exception.model.ModelRemoveException;
import com.blogsite.blog.service.exception.model.ModelSaveException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @author hkaynar on 12.12.2021
 */
@Service
@Slf4j
@Transactional
public class ModelServiceImp implements ModelService {
    @Autowired
    private ModelDao modelDao;
    @Autowired
    private  EntityManager entityManager;

    public String getValidatorMessageWhenSave(Exception e) {
        String message = e.getMessage();
        if (e instanceof TransactionSystemException
                && ((TransactionSystemException) e).getRootCause() instanceof ConstraintViolationException) {
            ConstraintViolationException modelValidatorEx =
                    ((ConstraintViolationException) ((TransactionSystemException) e).getRootCause());
            Set<ConstraintViolation<?>> constraintViolations = modelValidatorEx.getConstraintViolations();
            message = constraintViolations.iterator().hasNext()
                    ? constraintViolations.iterator().next().getMessage() : message;
        }
        return message;
    }

    @Override
    public <T extends ItemModel> T save(T t) {
        try {
            var model = modelDao.save(t);
            //set modified fields
            model.setModifiedAttributes(t.getModifiedAttributes());
            return model;

        } catch (Exception e) {
            String errorMessage = getValidatorMessageWhenSave(e);
            log.error("Error while saving model.Error message : {}", errorMessage);
            throw new ModelSaveException("Model Saving Exception.... " + errorMessage);
        }
    }

    @Override
    public <T extends ItemModel> Iterable<T> saveAll(Iterable<T> t) {
        try {
            var models = modelDao.saveAll(t);
            //set modified fields
            models.stream().forEach(m -> m.setModifiedAttributes(t.iterator().next().getModifiedAttributes()));

            return models;
        } catch (Exception e) {
            String errorMessage = getValidatorMessageWhenSave(e);
            log.error("Error while saving model.Error message : {}", errorMessage);
            throw new ModelSaveException("Model Saving Exception...." + errorMessage);
        }
    }

    @Override
    public <T extends ItemModel> Iterable<T> saveAll(T... t) {
        try {
            var items = Arrays.asList(t);
            var models = modelDao.saveAll(Arrays.asList(t));
            //set modified fields
            IntStream.range(0, models.size()).forEach(i -> {
                models.get(i).setModifiedAttributes(items.get(i).getModifiedAttributes());
            });

            return models;

        } catch (Exception e) {
            String errorMessage = getValidatorMessageWhenSave(e);
            log.error("Error while saving model.Error message : {}", errorMessage);
            throw new ModelSaveException("Model Saving Exception...." + errorMessage);
        }
    }

    @Override
    public <T extends ItemModel> void remove(T t) {
        try {

            modelDao.delete(t);

        } catch (Exception e) {
            log.error("Error while removing model.Error message : {}", ExceptionUtils.getMessage(e));
            throw new ModelRemoveException("Model Remove Exception.... " + e.getMessage());
        }
    }

    @Override
    public <T extends ItemModel> void removeAll(Iterable<T> t) {
        try {
            modelDao.deleteAll(t);
        } catch (Exception e) {
            log.error("Error while removing all model.Error message : {}", ExceptionUtils.getMessage(e));
            throw new ModelRemoveException("Model Remove Exception.... " + e.getMessage());
        }
    }

    @Override
    public <T extends ItemModel> T create(Class<T> tClass) {
        try {
            return tClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new ClassCastException();
        }
    }

    @Override
    public <T extends ItemModel> T refresh(T t) {
        entityManager.refresh(t);
        return t;
    }
}
