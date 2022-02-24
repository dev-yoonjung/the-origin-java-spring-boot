package theorigin.javaspringboot.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import theorigin.javaspringboot.jpa.entity.BoardEntity;
import theorigin.javaspringboot.jpa.entity.PostEntity;
import theorigin.javaspringboot.jpa.repository.BoardRepository;
import theorigin.javaspringboot.jpa.repository.PostRepository;

@Component
public class TestComponent {

    public TestComponent(@Autowired BoardRepository boardRepository, @Autowired PostRepository postRepository) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setName("new board");
        BoardEntity newBoardEntity = boardRepository.save(boardEntity);

        PostEntity postEntity = new PostEntity();
        postEntity.setTitle("hello ORM");
        postEntity.setContent("This Entity is created by hibernate!");
        postEntity.setWriter("yoonjung");
        postEntity.setBoardEntity(newBoardEntity);
        PostEntity newPostEntity = postRepository.save(postEntity);

        System.out.println(postRepository.findAllByWriter("yoonjung").size());
    }
}
