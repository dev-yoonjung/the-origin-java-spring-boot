package theorigin.javaspringboot.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import theorigin.javaspringboot.mybatis.dto.BoardDTO;
import theorigin.javaspringboot.mybatis.mapper.BoardMapper;

@Repository
public class BoardDAO {

    private final SqlSessionFactory sessionFactory;

    public BoardDAO(@Autowired SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int createBoard(BoardDTO dto) {
        try (SqlSession session = sessionFactory.openSession()) {
            BoardMapper mapper = session.getMapper(BoardMapper.class);
            return mapper.createBoard(dto);
        }
    }
}
