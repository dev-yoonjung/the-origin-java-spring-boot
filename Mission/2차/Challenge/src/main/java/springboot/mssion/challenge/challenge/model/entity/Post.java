package springboot.mssion.challenge.challenge.model.entity;

/**
 * 게시글 Entity
 * 제목, 본문에 대한 정보를 가지고 있다.
 *
 * <pre>
 *     <b>History:</b>
 *     yoonjung choi, 1.0, 2022. 02. 18. 최초작성
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

    // No args constructor
    public Post() {
    }

    // All args constructor
    public Post(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
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

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
