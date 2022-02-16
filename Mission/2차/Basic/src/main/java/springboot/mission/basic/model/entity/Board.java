package springboot.mission.basic.model.entity;

import java.util.List;

/**
 * 게시판 Entity
 * 이름에 대한 정보를 가지고 있다.
 * 게시판 : 게시글 = 1 : N 의 관계를 가지고 있다.
 *
 * <pre>
 *     <b>History:</b>
 *     yoonjung choi, 1.0, 2022. 02. 17. 최초작성
 * </pre>
 *
 * @author yoonjung choi
 * @version 1.0
 */
public class Board {

    // primary key, not null, auto increment
    private Long id;

    private String name;

    // One to many
    // private List<Post> posts;

    // No args constructor
    public Board() {
    }

    // All args constructor
    public Board(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

}
