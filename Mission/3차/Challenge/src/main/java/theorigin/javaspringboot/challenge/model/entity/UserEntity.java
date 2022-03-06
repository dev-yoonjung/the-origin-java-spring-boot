package theorigin.javaspringboot.challenge.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(targetEntity = AreaEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    private AreaEntity areaEntity;

    @OneToMany(targetEntity = UserRoleEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "userEntity")
    private Set<UserRoleEntity> userRole = new HashSet<>();

    @OneToMany(targetEntity = ShopReviewEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "userEntity")
    private List<ShopReviewEntity> shopReview = new ArrayList<>();

    public UserEntity() {
    }

    public UserEntity(Long id, String name, AreaEntity areaEntity, Set<UserRoleEntity> userRole, List<ShopReviewEntity> shopReview) {
        this.id = id;
        this.name = name;
        this.areaEntity = areaEntity;
        this.userRole = userRole;
        this.shopReview = shopReview;
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

    public AreaEntity getAreaEntity() {
        return areaEntity;
    }

    public void setAreaEntity(AreaEntity areaEntity) {
        this.areaEntity = areaEntity;
    }

    public Set<UserRoleEntity> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRoleEntity> userRole) {
        this.userRole = userRole;
    }

    public List<ShopReviewEntity> getShopReview() {
        return shopReview;
    }

    public void setShopReview(List<ShopReviewEntity> shopReview) {
        this.shopReview = shopReview;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", areaEntity=" + areaEntity +
                ", userRole=" + userRole +
                ", shopReview=" + shopReview +
                '}';
    }
}
