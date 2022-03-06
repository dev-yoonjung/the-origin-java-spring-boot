package theorigin.javaspringboot.challenge.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shop_post")
public class ShopPostEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @OneToMany(targetEntity = ShopPostRoleEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "shopPostEntity")
    private List<ShopPostRoleEntity> shopPostRole = new ArrayList<>();

    @ManyToOne(targetEntity = ShopEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private ShopEntity shopEntity;

    public ShopPostEntity() {
    }

    public ShopPostEntity(Long id, String title, String content, List<ShopPostRoleEntity> shopPostRole, ShopEntity shopEntity) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.shopPostRole = shopPostRole;
        this.shopEntity = shopEntity;
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

    public List<ShopPostRoleEntity> getShopPostRole() {
        return shopPostRole;
    }

    public void setShopPostRole(List<ShopPostRoleEntity> shopPostRole) {
        this.shopPostRole = shopPostRole;
    }

    public ShopEntity getShopEntity() {
        return shopEntity;
    }

    public void setShopEntity(ShopEntity shopEntity) {
        this.shopEntity = shopEntity;
    }

    @Override
    public String toString() {
        return "ShopPostEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", shopPostRole=" + shopPostRole +
                ", shopEntity=" + shopEntity +
                '}';
    }
}
