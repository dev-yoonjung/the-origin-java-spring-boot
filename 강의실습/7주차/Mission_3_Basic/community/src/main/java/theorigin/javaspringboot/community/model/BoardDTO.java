package theorigin.javaspringboot.community.model;

public class BoardDTO {
    private Long id;
    private String name;

    public BoardDTO() {
    }

    public BoardDTO(Long id, String name) {
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
        return "BoardDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
