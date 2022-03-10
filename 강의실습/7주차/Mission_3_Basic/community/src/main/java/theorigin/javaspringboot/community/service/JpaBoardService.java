package theorigin.javaspringboot.community.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import theorigin.javaspringboot.community.jpa.entity.BoardEntity;
import theorigin.javaspringboot.community.model.BoardDTO;
import theorigin.javaspringboot.community.repository.BoardRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class JpaBoardService implements BoardService {

    private static final Logger logger = LoggerFactory.getLogger(JpaBoardService.class);
    private final BoardRepository boardRepository;

    public JpaBoardService(@Autowired BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public BoardDTO create(BoardDTO dto) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setName(dto.getName());
        boardEntity = this.boardRepository.save(boardEntity);
        return new BoardDTO(
                boardEntity.getId(),
                boardEntity.getName()
        );
    }

    @Override
    public BoardDTO read(Long id) {
        Optional<BoardEntity> boardEntityOptional = this.boardRepository.findById(id);
        if (boardEntityOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        BoardEntity boardEntity = boardEntityOptional.get();
        return new BoardDTO(
                boardEntity.getId(),
                boardEntity.getName()
        );
    }

    @Override
    public Collection<BoardDTO> readAll() {
        List<BoardDTO> boardDTOList = new ArrayList<>();
        this.boardRepository.findAll().forEach(boardEntity -> boardDTOList.add(new BoardDTO(
                boardEntity.getId(),
                boardEntity.getName()
        )));
        return boardDTOList;
    }

    @Override
    public boolean update(Long id, BoardDTO dto) {
        Optional<BoardEntity> boardEntityOptional = this.boardRepository.findById(id);
        if (boardEntityOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        BoardEntity boardEntity = boardEntityOptional.get();
        boardEntity.setName(
                dto.getName() == null ? boardEntity.getName() : dto.getName()
        );
        this.boardRepository.save(boardEntity);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        Optional<BoardEntity> boardEntityOptional = this.boardRepository.findById(id);
        if (boardEntityOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        BoardEntity boardEntity =  boardEntityOptional.get();
        this.boardRepository.delete(boardEntity);
        return true;
    }
}
