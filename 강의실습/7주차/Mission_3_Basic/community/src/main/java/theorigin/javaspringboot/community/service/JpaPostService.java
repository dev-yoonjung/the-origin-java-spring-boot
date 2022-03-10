package theorigin.javaspringboot.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import theorigin.javaspringboot.community.jpa.entity.BoardEntity;
import theorigin.javaspringboot.community.jpa.entity.PostEntity;
import theorigin.javaspringboot.community.jpa.entity.UserEntity;
import theorigin.javaspringboot.community.model.PostDTO;
import theorigin.javaspringboot.community.repository.BoardRepository;
import theorigin.javaspringboot.community.repository.PostRepository;
import theorigin.javaspringboot.community.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class JpaPostService implements PostService {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public JpaPostService(@Autowired PostRepository postRepository,
                          @Autowired BoardRepository boardRepository,
                          @Autowired UserRepository userRepository) {
        this.postRepository = postRepository;
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PostDTO create(Long boardId, PostDTO dto) {
        if (!this.boardRepository.existsById(boardId)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        if (!this.userRepository.existsById(dto.getUserId())) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        BoardEntity boardEntity = this.boardRepository.findById(boardId).get();
        UserEntity userEntity = this.userRepository.findById(dto.getUserId()).get();
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(dto.getTitle());
        postEntity.setContent(dto.getContent());
        postEntity.setUserEntity(userEntity);
        postEntity.setBoardEntity(boardEntity);
        postEntity = this.postRepository.save(postEntity);

        return new PostDTO(
                postEntity.getId(),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getUserEntity().getId(),
                postEntity.getBoardEntity().getId()
        );
    }

    @Override
    public PostDTO read(Long boardId, Long postId) {
        if (!this.postRepository.existsById(postId)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        PostEntity postEntity = this.postRepository.findById(postId).get();
        if (!postEntity.getBoardEntity().getId().equals(boardId))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return new PostDTO(
                postEntity.getId(),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getUserEntity().getId(),
                postEntity.getBoardEntity().getId()
        );
    }

    @Override
    public Collection<PostDTO> readAll(Long boardId) {
        Optional<BoardEntity> boardEntityOptional = this.boardRepository.findById(boardId);
        if (boardEntityOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        BoardEntity boardEntity = boardEntityOptional.get();
        List<PostDTO> postDTOList =  new ArrayList<>();
        boardEntity.getPostEntityList().forEach(postEntity -> postDTOList.add(
                new PostDTO(
                        postEntity.getId(),
                        postEntity.getTitle(),
                        postEntity.getContent(),
                        postEntity.getUserEntity().getId(),
                        postEntity.getBoardEntity().getId()
                )
        ));
        return postDTOList;
    }

    @Override
    public boolean update(Long boardId, Long postId, PostDTO dto) {
        if (!this.postRepository.existsById(postId)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        PostEntity postEntity = this.postRepository.findById(postId).get();
        if (!postEntity.getBoardEntity().getId().equals(boardId))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        if (!postEntity.getUserEntity().getId().equals(dto.getUserId()))
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);

        postEntity.setTitle(dto.getTitle() == null ? postEntity.getTitle() : dto.getTitle());
        postEntity.setContent(dto.getContent() == null ? postEntity.getContent() : dto.getContent());
        this.postRepository.save(postEntity);
        return true;
    }

    @Override
    public boolean delete(Long boardId, Long postId, String password) {
        if (!this.postRepository.existsById(postId)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        PostEntity postEntity = this.postRepository.findById(postId).get();
        if (!postEntity.getBoardEntity().getId().equals(boardId))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        this.postRepository.deleteById(postId);
        return true;
    }
}
