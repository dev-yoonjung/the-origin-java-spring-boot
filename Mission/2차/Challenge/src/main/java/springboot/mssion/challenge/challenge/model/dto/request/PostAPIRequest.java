package springboot.mssion.challenge.challenge.model.dto.request;

/**
 * 게시글 Request DTO
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
public class PostAPIRequest {

    private Long id;

    private String title;

    private String content;

    // No args constructor
    public PostAPIRequest() {
    }

    // All args constructor
    public PostAPIRequest(Long id, String title, String content) {
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
        return "PostAPIRequest{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
