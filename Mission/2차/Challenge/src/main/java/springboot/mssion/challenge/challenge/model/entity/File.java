package springboot.mssion.challenge.challenge.model.entity;

/**
 * 파일(이미지) Entity
 * 이름, 저장 경로, 파일 타입, 크기에 대한 정보를 가지고 있다.
 *
 * <pre>
 *     <b>History:</b>
 *     yoonjung choi, 1.0, 2022. 02. 18. 최초작성
 * </pre>
 *
 * @author yoonjung choi
 * @version 1.0
 */
public class File {

    // primary key, not null, auto increment
    private Long id;

    String name;

    String savedName;

    String path;

    String type;

    Long size;

    // No args constructor
    public File() {
    }

    // All args constructor
    public File(Long id, String name, String savedName, String path, String type, Long size) {
        this.id = id;
        this.name = name;
        this.savedName = savedName;
        this.path = path;
        this.type = type;
        this.size = size;
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

    public String getSavedName() {
        return savedName;
    }

    public void setSavedName(String savedName) {
        this.savedName = savedName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", savedName='" + savedName + '\'' +
                ", path='" + path + '\'' +
                ", type='" + type + '\'' +
                ", size=" + size +
                '}';
    }

}
