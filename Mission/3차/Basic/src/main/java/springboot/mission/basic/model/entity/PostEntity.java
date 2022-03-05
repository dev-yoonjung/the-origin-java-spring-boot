package springboot.mission.basic.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class PostEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne(targetEntity = BoardEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private BoardEntity boardEntity;

    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public PostEntity() {
    }

    public PostEntity(Long id, String title, String content, BoardEntity boardEntity, UserEntity userEntity) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.boardEntity = boardEntity;
        this.userEntity = userEntity;
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

    public BoardEntity getBoardEntity() {
        return boardEntity;
    }

    public void setBoardEntity(BoardEntity boardEntity) {
        this.boardEntity = boardEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public String toString() {
        return "PostEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", boardEntity=" + boardEntity +
                ", userEntity=" + userEntity +
                '}';
    }

}
