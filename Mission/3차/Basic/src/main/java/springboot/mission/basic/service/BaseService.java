package springboot.mission.basic.service;

import java.util.List;

public interface BaseService<Request, Response> {

    void create(Request dto);

    Response read(Long id);

    List<Response> readAll();

    void update(Long id, Request dto);

    void delete(Long id);
}
