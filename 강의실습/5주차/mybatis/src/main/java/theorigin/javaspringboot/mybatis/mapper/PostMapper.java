package theorigin.javaspringboot.mybatis.mapper;

import theorigin.javaspringboot.mybatis.dto.PostDTO;

import java.util.List;

public interface PostMapper {

    int createPost(PostDTO dto);

    int createPostAll(List<PostDTO> dtoList);

    PostDTO readPost(int id);

    List<PostDTO> readPostAll();

    PostDTO readPostQuery(PostDTO dto);

    int updatePost(PostDTO dto);

    int deletePost(int id);

}
