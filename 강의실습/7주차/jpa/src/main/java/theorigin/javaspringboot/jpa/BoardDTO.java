package theorigin.javaspringboot.jpa;

public class BoardDTO {

    private String name;

    public BoardDTO() {
    }

    public BoardDTO(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
