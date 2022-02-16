package springboot.mission.basic.model.entity;

/**
 * 게시글 Entity
 * 제목, 본문, 작성자, 비밀번호에 대한 정보를 가지고 있다.
 * 게시글 : 게시판 = N : 1 의 관계를 가지고 있다.
 *
 * <pre>
 *     <b>History:</b>
 *     yoonjung choi, 1.0, 2022. 02. 17. 최초작성
 * </pre>
 *
 * @author yoonjung choi
 * @version 1.0
 */
public class Post {

    // primary key, not null, auto increment
    private Long id;

    private String title;

    private String content;

    private String writer;

    private String password;

    // Many to one
    private Board board;

    public Post() {
    }

    public Post(Long id, String title, String content, String writer, String password, Board board) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.password = password;
        this.board = board;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", password='" + password + '\'' +
                ", board=" + board +
                '}';
    }

}
