package springboot.mission.basic.model.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;
import springboot.mission.basic.model.dto.request.BoardAPIRequest;
import springboot.mission.basic.model.entity.BoardEntity;
import springboot.mission.basic.repository.BoardRepository;

import java.util.Iterator;
import java.util.Optional;

@Repository
public class BoardDAO {

    private static final Logger logger = LoggerFactory.getLogger(BoardDAO.class);
    private final BoardRepository boardRepository;

    public BoardDAO(@Autowired BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void createBoard(BoardAPIRequest dto) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setName(dto.getName());
        this.boardRepository.save(boardEntity);
    }

    public BoardEntity readBoard(Long id) {
        Optional<BoardEntity> boardEntity = this.boardRepository.findById(id);
        if (boardEntity.isEmpty()) throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        return boardEntity.get();
    }

    public Iterator<BoardEntity> readAllBoard() {
        return this.boardRepository.findAll().iterator();
    }

    public void updateBoard(Long id, BoardAPIRequest dto) {
        Optional<BoardEntity> targetEntity = this.boardRepository.findById(id);
        if (targetEntity.isEmpty()) throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        BoardEntity boardEntity = targetEntity.get();
        boardEntity.setName(dto.getName() == null ? boardEntity.getName() : dto.getName());
        this.boardRepository.save(boardEntity);
    }

    public void deleteBoard(Long id) {
        this.boardRepository.deleteById(id);
    }
}
