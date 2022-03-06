package theorigin.javaspringboot.challenge.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "shop_post_role")
public class ShopPostRoleEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = ShopPostEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_post_id")
    private ShopPostEntity shopPostEntity;

    @ManyToOne(targetEntity = RoleEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;

    public ShopPostRoleEntity() {
    }

    public ShopPostRoleEntity(Long id, ShopPostEntity shopPostEntity, RoleEntity roleEntity) {
        this.id = id;
        this.shopPostEntity = shopPostEntity;
        this.roleEntity = roleEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShopPostEntity getShopPostEntity() {
        return shopPostEntity;
    }

    public void setShopPostEntity(ShopPostEntity shopPostEntity) {
        this.shopPostEntity = shopPostEntity;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    @Override
    public String toString() {
        return "ShopPostRoleEntity{" +
                "id=" + id +
                ", shopPostEntity=" + shopPostEntity +
                ", roleEntity=" + roleEntity +
                '}';
    }
}
