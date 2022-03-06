package theorigin.javaspringboot.challenge.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "shop")
public class ShopEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(targetEntity = ShopRoleEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "shopEntity")
    private List<ShopRoleEntity> shopRole = new ArrayList<>();

    @OneToMany(targetEntity = CategoryEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "shopEntity")
    private List<CategoryEntity> category = new ArrayList<>();

    @OneToMany(targetEntity = ShopPostEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "shopEntity")
    private List<ShopPostEntity> shopPost = new ArrayList<>();

    @OneToMany(targetEntity = ShopReviewEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "shopEntity")
    private List<ShopReviewEntity> shopReview = new ArrayList<>();

    @ManyToOne(targetEntity = AreaEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    private AreaEntity areaEntity;

    public ShopEntity() {
    }

    public ShopEntity(Long id, String name, List<ShopRoleEntity> shopRole, List<CategoryEntity> category, List<ShopPostEntity> shopPost, List<ShopReviewEntity> shopReview, AreaEntity areaEntity) {
        this.id = id;
        this.name = name;
        this.shopRole = shopRole;
        this.category = category;
        this.shopPost = shopPost;
        this.shopReview = shopReview;
        this.areaEntity = areaEntity;
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

    public List<ShopRoleEntity> getShopRole() {
        return shopRole;
    }

    public void setShopRole(List<ShopRoleEntity> shopRole) {
        this.shopRole = shopRole;
    }

    public List<CategoryEntity> getCategory() {
        return category;
    }

    public void setCategory(List<CategoryEntity> category) {
        this.category = category;
    }

    public List<ShopPostEntity> getShopPost() {
        return shopPost;
    }

    public void setShopPost(List<ShopPostEntity> shopPost) {
        this.shopPost = shopPost;
    }

    public List<ShopReviewEntity> getShopReview() {
        return shopReview;
    }

    public void setShopReview(List<ShopReviewEntity> shopReview) {
        this.shopReview = shopReview;
    }

    public AreaEntity getAreaEntity() {
        return areaEntity;
    }

    public void setAreaEntity(AreaEntity areaEntity) {
        this.areaEntity = areaEntity;
    }

    @Override
    public String toString() {
        return "ShopEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shopRole=" + shopRole +
                ", category=" + category +
                ", shopPost=" + shopPost +
                ", shopReview=" + shopReview +
                ", areaEntity=" + areaEntity +
                '}';
    }
}
