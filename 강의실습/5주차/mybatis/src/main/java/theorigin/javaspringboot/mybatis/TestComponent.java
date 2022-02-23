package theorigin.javaspringboot.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import theorigin.javaspringboot.mybatis.dao.BoardDAO;
import theorigin.javaspringboot.mybatis.dao.PostDAO;
import theorigin.javaspringboot.mybatis.dto.BoardDTO;
import theorigin.javaspringboot.mybatis.dto.PostDTO;

import java.util.List;

@Component
public class TestComponent {

    private final BoardDAO boardDAO;
    private final PostDAO postDAO;

    public TestComponent(@Autowired BoardDAO boardDAO, @Autowired PostDAO postDAO) {
        this.postDAO = postDAO;
        this.boardDAO = boardDAO;

        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setName("New Board");
        this.boardDAO.createBoard(boardDTO);
        System.out.println(boardDTO.getId());

        PostDTO newPost = new PostDTO();
        newPost.setTitle("From Mybatis");
        newPost.setContent("Use Database with Spring Boot!");
        newPost.setWriter("yoonjung");
        newPost.setBoard(1);
        this.postDAO.createPost(newPost);

        List<PostDTO> postDTOList = this.postDAO.readPostAll();
        System.out.println(postDTOList.get(postDTOList.size() - 1));

        PostDTO firstPOST = postDTOList.get(0);
        firstPOST.setContent("content updated From Mybatis!");
        postDAO.updatePost(firstPOST);

        System.out.println(this.postDAO.readPost(firstPOST.getId()));
    }
}
