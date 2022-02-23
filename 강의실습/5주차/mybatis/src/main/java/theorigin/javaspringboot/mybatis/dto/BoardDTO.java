package theorigin.javaspringboot.mybatis.dto;

public class BoardDTO {

    private int id;

    private String name;

    public BoardDTO() {
    }

    public BoardDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
