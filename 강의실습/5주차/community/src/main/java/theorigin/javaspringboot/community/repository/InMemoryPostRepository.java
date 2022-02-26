package theorigin.javaspringboot.community.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import theorigin.javaspringboot.community.model.BoardDTO;
import theorigin.javaspringboot.community.model.PostDTO;
import java.util.*;

@Repository
public class InMemoryPostRepository implements PostRepository{

    private final BoardRepository boardRepository;

    private final Map<Long, PostDTO> memory = new HashMap<>();
    private Long lastIndex = 0L;

    public InMemoryPostRepository(@Autowired BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public PostDTO create(Long boardId, PostDTO dto) {
        BoardDTO boardDTO = this.boardRepository.read(boardId);
        if (boardDTO == null) return null;
        dto.setBoardId(boardId);
        lastIndex++;
        dto.setId(lastIndex);
        memory.put(lastIndex, dto);
        return dto;
    }

    @Override
    public PostDTO read(Long boardId, Long postId) {
        PostDTO postDTO = memory.getOrDefault(postId, null);
        if (postDTO == null) return null;
        else if (!Objects.equals(postDTO.getBoardId(), boardId)) return null;
        return postDTO;
    }

    @Override
    public Collection<PostDTO> readAll(Long boardId) {
        if (boardRepository.read(boardId) == null) return null;
        Collection<PostDTO> postList = new ArrayList<>();
        memory.forEach((postId, postDTO) -> {
            if (Objects.equals(postDTO.getBoardId(), boardId))
                postList.add(postDTO);
        });
        return postList;
    }

    @Override
    public boolean update(Long boardId, Long postId, PostDTO dto) {
        PostDTO targetPost = memory.getOrDefault(postId, null);
        if (targetPost == null) return false;
        else if (!Objects.equals(targetPost.getBoardId(), boardId)) return false;
        else if (!Objects.equals(targetPost.getPassword(), dto.getPassword())) return false;
        targetPost.setTitle(dto.getTitle() == null ? targetPost.getTitle() : dto.getTitle());
        targetPost.setContent(dto.getContent() == null ? targetPost.getContent() : dto.getContent());
        return true;
    }

    @Override
    public boolean delete(Long boardId, Long postId, String password) {
        PostDTO targetPost = memory.getOrDefault(postId, null);
        if (targetPost == null) return false;
        else if (!Objects.equals(targetPost.getBoardId(), boardId)) return false;
        else if (!Objects.equals(targetPost.getPassword(), password)) return false;
        memory.remove(postId);
        return true;
    }
}
