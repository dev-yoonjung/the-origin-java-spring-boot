package theorigin.javaspringboot.challenge.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(mappedBy = "role")
    private ShopEntity shop;

    @OneToMany(targetEntity = ShopPostEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "roleEntity")
    private List<ShopPostEntity> shopPost = new ArrayList<>();

    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public RoleEntity() {
    }

    public RoleEntity(Long id, String name, ShopEntity shop, List<ShopPostEntity> shopPost, UserEntity userEntity) {
        this.id = id;
        this.name = name;
        this.shop = shop;
        this.shopPost = shopPost;
        this.userEntity = userEntity;
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

    public ShopEntity getShop() {
        return shop;
    }

    public void setShop(ShopEntity shop) {
        this.shop = shop;
    }

    public List<ShopPostEntity> getShopPost() {
        return shopPost;
    }

    public void setShopPost(List<ShopPostEntity> shopPost) {
        this.shopPost = shopPost;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shop=" + shop +
                ", shopPost=" + shopPost +
                ", userEntity=" + userEntity +
                '}';
    }
}
