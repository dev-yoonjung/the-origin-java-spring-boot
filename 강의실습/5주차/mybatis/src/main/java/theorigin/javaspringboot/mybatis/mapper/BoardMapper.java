package theorigin.javaspringboot.mybatis.mapper;

import theorigin.javaspringboot.mybatis.dto.BoardDTO;

public interface BoardMapper {

    int createBoard(BoardDTO dto);

}
