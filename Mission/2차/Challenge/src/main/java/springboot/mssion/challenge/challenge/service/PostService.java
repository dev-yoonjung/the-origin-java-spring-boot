package springboot.mssion.challenge.challenge.service;

import springboot.mssion.challenge.challenge.common.exception.CreateException;
import springboot.mssion.challenge.challenge.common.exception.DeleteException;
import springboot.mssion.challenge.challenge.common.exception.UpdateException;
import springboot.mssion.challenge.challenge.model.dto.request.PostAPIRequest;
import springboot.mssion.challenge.challenge.model.dto.response.PostAPIResponse;

import java.util.List;

public interface PostService {

    void create(PostAPIRequest requestPost) throws CreateException;

    List<PostAPIResponse> readAll();

    PostAPIResponse readOne(Long id);

    void update(Long id, PostAPIRequest requestPost) throws UpdateException;

    void delete(Long id) throws DeleteException;
}
