package springboot.mission.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.mission.basic.common.exception.CreateException;
import springboot.mission.basic.common.exception.DeleteException;
import springboot.mission.basic.common.exception.UpdateException;
import springboot.mission.basic.model.dto.request.BoardAPIRequest;
import springboot.mission.basic.model.dto.response.BoardAPIResponse;
import springboot.mission.basic.service.BoardService;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
    private final BoardService boardService;

    public BoardController(@Autowired BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody BoardAPIRequest boardAPIRequest) {
        try {
            this.boardService.create(boardAPIRequest);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (CreateException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping()
    public ResponseEntity<List<BoardAPIResponse>> readAll() {
        return ResponseEntity.ok(this.boardService.readAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<BoardAPIResponse> readOne(@PathVariable Long id) {
        return ResponseEntity.ok(this.boardService.readOne(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BoardAPIRequest requestBoard) {
        try {
            this.boardService.update(id, requestBoard);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (UpdateException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            this.boardService.delete(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (DeleteException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

}
