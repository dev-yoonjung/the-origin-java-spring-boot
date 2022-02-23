package theorigin.javaspringboot.mybatis.dto;

public class PostDTO {

    private int id;

    private String title;

    private String content;

    private String writer;

    private int board;

    public PostDTO() {
    }

    public PostDTO(int id, String title, String content, String writer, int board) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.board = board;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getBoard() {
        return board;
    }

    public void setBoard(int board) {
        this.board = board;
    }

    @Override
    public String toString() {
        return "PostDAO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", board=" + board +
                '}';
    }
}
