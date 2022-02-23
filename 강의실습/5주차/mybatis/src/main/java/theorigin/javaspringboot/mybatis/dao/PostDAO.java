package theorigin.javaspringboot.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import theorigin.javaspringboot.mybatis.dto.PostDTO;
import theorigin.javaspringboot.mybatis.mapper.PostMapper;

import java.util.List;

@Repository
public class PostDAO {

    private final SqlSessionFactory sessionFactory;

    public PostDAO(@Autowired SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public int createPost(PostDTO dto) {
        try (SqlSession session = sessionFactory.openSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.createPost(dto);
        }
    }

    public PostDTO readPost(int id) {
        try (SqlSession session = sessionFactory.openSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPost(id);
        }
    }

    public List<PostDTO> readPostAll() {
        try (SqlSession session = sessionFactory.openSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.readPostAll();
        }
    }

    public int updatePost(PostDTO dto) {
        try (SqlSession session = sessionFactory.openSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.updatePost(dto);
        }
    }

    public int deletePost(int id) {
        try (SqlSession session = sessionFactory.openSession()) {
            PostMapper mapper = session.getMapper(PostMapper.class);
            return mapper.deletePost(id);
        }
    }
}
