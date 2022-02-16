package theorigin.javaspringboot.crud.post;

import java.util.List;

public interface PostRepository {
    boolean save(PostDTO postDTO);
    List<PostDTO> findAll();
    PostDTO findById(int id);
    boolean update(int id, PostDTO postDTO);
    boolean delete(int id);
}
