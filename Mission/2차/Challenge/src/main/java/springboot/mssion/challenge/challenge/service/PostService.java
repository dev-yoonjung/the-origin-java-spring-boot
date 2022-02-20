package springboot.mssion.challenge.challenge.service;

import springboot.mssion.challenge.challenge.common.exception.CreateException;
import springboot.mssion.challenge.challenge.model.dto.request.PostAPIRequest;
import springboot.mssion.challenge.challenge.model.dto.response.PostAPIResponse;

public interface PostService {

    PostAPIResponse create(PostAPIRequest requestPost) throws CreateException;

    PostAPIResponse readOne(Long id);

}
