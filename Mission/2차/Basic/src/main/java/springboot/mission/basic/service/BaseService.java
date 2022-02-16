package springboot.mission.basic.service;

import springboot.mission.basic.common.exception.CreateException;
import springboot.mission.basic.common.exception.DeleteException;
import springboot.mission.basic.common.exception.UpdateException;

import java.util.List;

/**
 * Base service interface. This interface is based on CRUD.
 *
 * <pre>
 *     <b>History:</b>
 *     yoonjung choi, 1.0, 2022. 02. 17. 최초작성
 * </pre>
 *
 * @author yoonjung choi
 * @version 1.0
 */
public interface BaseService<RequestDTO, ResponseDTO> {

    void create(RequestDTO dto) throws CreateException;

    List<ResponseDTO> readAll();

    ResponseDTO readOne(Long id);

    void update(Long id, RequestDTO dto) throws UpdateException;

    void delete(Long id) throws DeleteException;
}
