package springboot.mission.basic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.mission.basic.model.dao.BoardDAO;
import springboot.mission.basic.model.dto.request.BoardAPIRequest;
import springboot.mission.basic.model.dto.response.BoardAPIResponse;
import springboot.mission.basic.model.entity.BoardEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BoardAPILogicService implements BoardService {

    private static final Logger logger = LoggerFactory.getLogger(BoardAPILogicService.class);
    private final BoardDAO boardDAO;

    public BoardAPILogicService(@Autowired BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Override
    public void create(BoardAPIRequest dto) {
        this.boardDAO.createBoard(dto);
    }

    @Override
    public BoardAPIResponse read(Long id) {
        return response(this.boardDAO.readBoard(id));
    }

    @Override
    public List<BoardAPIResponse> readAll() {
        Iterator<BoardEntity> iterator = this.boardDAO.readAllBoard();
        List<BoardAPIResponse> boardList = new ArrayList<>();

        while (iterator.hasNext()) {
            BoardEntity boardEntity = iterator.next();
            boardList.add(response(boardEntity));
        }

        return boardList;
    }

    @Override
    public void update(Long id, BoardAPIRequest dto) {
        this.boardDAO.updateBoard(id, dto);
    }

    @Override
    public void delete(Long id) {
        this.boardDAO.deleteBoard(id);
    }

    private BoardAPIResponse response(BoardEntity boardEntity) {
        return new BoardAPIResponse(boardEntity.getId(),
                                    boardEntity.getName(),
                                    boardEntity.getCreatedAt(),
                                    boardEntity.getUpdatedAt());
    }

}
