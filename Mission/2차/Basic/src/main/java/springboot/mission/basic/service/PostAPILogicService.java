package springboot.mission.basic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.mission.basic.common.exception.CreateException;
import springboot.mission.basic.common.exception.DeleteException;
import springboot.mission.basic.common.exception.UpdateException;
import springboot.mission.basic.model.dto.request.PostAPIRequest;
import springboot.mission.basic.model.dto.response.PostAPIResponse;
import springboot.mission.basic.model.entity.Board;
import springboot.mission.basic.model.entity.Post;
import springboot.mission.basic.repository.BoardRepository;
import springboot.mission.basic.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PostAPILogicService implements PostService {

    private static final Logger logger = LoggerFactory.getLogger(PostAPILogicService.class);
    private final PostRepository postRepository;
    private final BoardRepository boardRepository;

    public PostAPILogicService(@Autowired PostRepository postRepository,
                               @Autowired BoardRepository boardRepository) {
        this.postRepository = postRepository;
        this.boardRepository = boardRepository;
    }

    @Override
    public void create(PostAPIRequest requestPost) throws CreateException {
        Post post = new Post();
        post.setTitle(requestPost.getTitle());
        post.setContent(requestPost.getContent());
        post.setWriter(requestPost.getWriter());
        post.setPassword(requestPost.getPassword());
        Optional<Board> board = this.boardRepository.findById(requestPost.getBoardId());
        board.ifPresent(post::setBoard);
        Optional<Post> savedPost = this.postRepository.save(post);
        if (savedPost.isEmpty()) throw new CreateException("create failed");
    }

    @Override
    public List<PostAPIResponse> readAll() {
        List<PostAPIResponse> responsePost = new ArrayList<>();
        this.postRepository.findAll().forEach(post -> responsePost.add(response(post)));
        return responsePost;
    }

    @Override
    public List<PostAPIResponse> readInBoard(Long boardId) {
        List<PostAPIResponse> responsePost = new ArrayList<>();
        this.postRepository.findByBoardId(boardId).forEach(post -> {
            responsePost.add(response(post));
        });
        return responsePost;
    }

    @Override
    public PostAPIResponse readOne(Long id) {
        Optional<Post> post = this.postRepository.findById(id);
        return post.map(this::response).orElse(null);
    }

    @Override
    public void update(Long id, PostAPIRequest requestPost) throws UpdateException {
        Post post = new Post();
        post.setId(id);
        post.setTitle(requestPost.getTitle());
        post.setContent(requestPost.getContent());
        post.setWriter(requestPost.getWriter());
        post.setPassword(requestPost.getPassword());
        Optional<Board> board = this.boardRepository.findById(requestPost.getBoardId());
        board.ifPresent(post::setBoard);
        this.postRepository.update(id, post);
    }

    @Override
    public void delete(Long id, String password) throws DeleteException {
        Optional<Post> finedPost = this.postRepository.findById(id);
        if (finedPost.isPresent() && Objects.equals(finedPost.get().getPassword(), password)) {
            this.postRepository.delete(id);

        }
        else throw new DeleteException("delete failed because there was no post with this id or you write wrong password.");
    }

    @Override
    public void delete(Long id) {
        try {
            this.postRepository.delete(id);
        } catch(DeleteException e) {
            e.printStackTrace();
        }
    }

    private PostAPIResponse response(Post post) {
        return new PostAPIResponse(post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getWriter(),
                post.getPassword(),
                post.getBoard() != null ? post.getBoard().getId() : -1L);
    }
}
