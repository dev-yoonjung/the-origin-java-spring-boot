package theorigin.javaspringboot.community.model;

public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private Long userId;
    private Long boardId;

    public PostDTO() {
    }

    public PostDTO(Long id, String title, String content, Long userId, Long boardId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.boardId = boardId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId + '\'' +
                ", boardId=" + boardId +
                '}';
    }

}
