package theorigin.javaspringboot.community.service;

import theorigin.javaspringboot.community.model.BoardDTO;
import java.util.Collection;

public interface BoardService {
    BoardDTO create(BoardDTO dto);

    BoardDTO read(Long id);

    Collection<BoardDTO> readAll();

    boolean update(Long id, BoardDTO dto);

    boolean delete(Long id);
}
