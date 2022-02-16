package springboot.mission.basic.model.dto.request;

/**
 * 게시판 Request DTO
 * 이름에 대한 정보를 가지고 있다.
 *
 * <pre>
 *     <b>History:</b>
 *     yoonjung choi, 1.0, 2022. 02. 17. 최초작성
 * </pre>
 *
 * @author yoonjung choi
 * @version 1.0
 */
public class BoardAPIRequest {
    
    private Long id;
    
    private String name;

    // No args constructor
    public BoardAPIRequest() {
    }

    // All args constructor
    public BoardAPIRequest(Long id, String name) {
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
        return "BoardAPIRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
