package springboot.mission.basic.service;

import springboot.mission.basic.common.exception.DeleteException;
import springboot.mission.basic.model.dto.request.PostAPIRequest;
import springboot.mission.basic.model.dto.response.PostAPIResponse;

import java.util.List;

public interface PostService extends BaseService<PostAPIRequest, PostAPIResponse> {

    List<PostAPIResponse> readInBoard(Long boardId);

    void delete(Long id, String password) throws DeleteException;
}
