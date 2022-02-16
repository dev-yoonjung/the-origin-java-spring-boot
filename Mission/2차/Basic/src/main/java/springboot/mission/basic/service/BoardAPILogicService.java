package springboot.mission.basic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.mission.basic.common.exception.CreateException;
import springboot.mission.basic.common.exception.DeleteException;
import springboot.mission.basic.common.exception.UpdateException;
import springboot.mission.basic.model.dto.request.BoardAPIRequest;
import springboot.mission.basic.model.dto.response.BoardAPIResponse;
import springboot.mission.basic.model.entity.Board;
import springboot.mission.basic.repository.BoardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardAPILogicService implements BoardService {

    private static final Logger logger = LoggerFactory.getLogger(BoardAPILogicService.class);
    private final BoardRepository boardRepository;

    public BoardAPILogicService(@Autowired BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public void create(BoardAPIRequest requestBoard) throws CreateException {
        Board board = new Board();
        board.setName(requestBoard.getName());
        Optional<Board> savedBoard = this.boardRepository.save(board);
        if (savedBoard.isEmpty()) throw new CreateException("create failed");
    }

    @Override
    public List<BoardAPIResponse> readAll() {
        List<BoardAPIResponse> responseBoard = new ArrayList<>();
        this.boardRepository.findAll().forEach(board -> responseBoard.add(response(board)));
        return responseBoard;
    }

    @Override
    public BoardAPIResponse readOne(Long id) {
        Optional<Board> board = this.boardRepository.findById(id);
        return board.map(this::response).orElse(null);
    }

    @Override
    public void update(Long id, BoardAPIRequest requestBoard) throws UpdateException {
        Board board = new Board();
        board.setId(id);
        board.setName(requestBoard.getName());
        Optional<Board> updatedBoard = this.boardRepository.update(id, board);
        if (updatedBoard.isEmpty()) throw new UpdateException("update failed");
    }

    @Override
    public void delete(Long id) throws DeleteException {
        this.boardRepository.delete(id);
    }

    private BoardAPIResponse response(Board board) {
        return new BoardAPIResponse(board.getId(), board.getName());
    }

}
