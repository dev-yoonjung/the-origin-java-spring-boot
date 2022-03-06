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

    @OneToMany(targetEntity = UserRoleEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "roleEntity")
    private Set<UserRoleEntity> userRole = new HashSet<>();

    @OneToMany(targetEntity = ShopRoleEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "roleEntity")
    private List<ShopRoleEntity> shopRole = new ArrayList<>();

    @OneToMany(targetEntity = ShopPostRoleEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "roleEntity")
    private List<ShopPostRoleEntity> shopPostRole = new ArrayList<>();

    public RoleEntity() {
    }

    public RoleEntity(Long id, String name, Set<UserRoleEntity> userRole, List<ShopRoleEntity> shopRole, List<ShopPostRoleEntity> shopPostRole) {
        this.id = id;
        this.name = name;
        this.userRole = userRole;
        this.shopRole = shopRole;
        this.shopPostRole = shopPostRole;
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

    public Set<UserRoleEntity> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRoleEntity> userRole) {
        this.userRole = userRole;
    }

    public List<ShopRoleEntity> getShopRole() {
        return shopRole;
    }

    public void setShopRole(List<ShopRoleEntity> shopRole) {
        this.shopRole = shopRole;
    }

    public List<ShopPostRoleEntity> getShopPostRole() {
        return shopPostRole;
    }

    public void setShopPostRole(List<ShopPostRoleEntity> shopPostRole) {
        this.shopPostRole = shopPostRole;
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userRole=" + userRole +
                ", shopRole=" + shopRole +
                ", shopPostRole=" + shopPostRole +
                '}';
    }
}
