package springboot.mission.basic.model.dto.request;

public class BoardAPIRequest {

    private Long id;

    private String name;

    public BoardAPIRequest() {
    }

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
