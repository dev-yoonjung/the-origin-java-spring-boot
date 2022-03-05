package springboot.mission.basic.model.dto.request;

public class UserAPIRequest {

    private Long id;

    private String name;

    private Long postId;

    public UserAPIRequest() {
    }

    public UserAPIRequest(Long id, String name, Long postId) {
        this.id = id;
        this.name = name;
        this.postId = postId;
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

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "UserAPIRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postId=" + postId +
                '}';
    }
}
