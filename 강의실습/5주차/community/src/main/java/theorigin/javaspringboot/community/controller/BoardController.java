package theorigin.javaspringboot.community.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import theorigin.javaspringboot.community.model.BoardDTO;
import theorigin.javaspringboot.community.repository.BoardRepository;
import java.util.Collection;


@RestController
@RequestMapping("/board")
public class BoardController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
    private final BoardRepository boardRepository;

    public BoardController(@Autowired BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @PostMapping("")
    public ResponseEntity<BoardDTO> createBoard(@RequestBody BoardDTO dto) {
        return ResponseEntity.ok(boardRepository.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardDTO> readBoard(@PathVariable("id") Long id) {
        BoardDTO dto = boardRepository.read(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @GetMapping("")
    public ResponseEntity<Collection<BoardDTO>> readBoardAll() {
        return ResponseEntity.ok(this.boardRepository.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable("id") Long id, @RequestBody BoardDTO dto) {
        if (!boardRepository.update(id, dto)) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable("id") Long id) {
        if (!boardRepository.delete(id)) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
