package springboot.mission.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.mission.basic.model.dto.request.BoardAPIRequest;
import springboot.mission.basic.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController implements BaseController<BoardAPIRequest> {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
    private final BoardService boardService;

    public BoardController(@Autowired BoardService boardService) {
        this.boardService = boardService;
    }

    @Override
    public ResponseEntity<?> create(BoardAPIRequest dto) {
        this.boardService.create(dto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> read(Long id) {
        return ResponseEntity.ok(this.boardService.read(id));
    }

    @Override
    public ResponseEntity<?> readAll() {
        return ResponseEntity.ok(this.boardService.readAll());
    }

    @Override
    public ResponseEntity<?> update(Long id, BoardAPIRequest dto) {
        this.boardService.update(id, dto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        this.boardService.delete(id);
        return ResponseEntity.ok().build();
    }
}
