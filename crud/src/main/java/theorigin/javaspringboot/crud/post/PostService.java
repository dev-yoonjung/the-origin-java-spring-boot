package theorigin.javaspringboot.crud.post;

import java.util.List;

public interface PostService {
    void createPost(PostDTO postDTO);
    List<PostDTO> readPostAll();
    PostDTO readPost(int id);
    void updatePost(int id, PostDTO postDTO);
    void deletePost(int id);
}
