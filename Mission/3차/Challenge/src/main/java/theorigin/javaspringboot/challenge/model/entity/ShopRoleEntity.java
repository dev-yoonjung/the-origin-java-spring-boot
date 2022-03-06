package theorigin.javaspringboot.challenge.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "shop_role")
public class ShopRoleEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = ShopEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private ShopEntity shopEntity;

    @ManyToOne(targetEntity = RoleEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;

    public ShopRoleEntity() {
    }

    public ShopRoleEntity(Long id, ShopEntity shopEntity, RoleEntity roleEntity) {
        this.id = id;
        this.shopEntity = shopEntity;
        this.roleEntity = roleEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShopEntity getShopEntity() {
        return shopEntity;
    }

    public void setShopEntity(ShopEntity shopEntity) {
        this.shopEntity = shopEntity;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    @Override
    public String toString() {
        return "ShopRoleEntity{" +
                "id=" + id +
                ", shopEntity=" + shopEntity +
                ", roleEntity=" + roleEntity +
                '}';
    }
}
