package theorigin.javaspringboot.challenge.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "area")
public class AreaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String province;

    private String city;

    private String town;

    private Long latitude;

    private Long hardness;

    @OneToMany(targetEntity = UserEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "areaEntity")
    private List<UserEntity> userEntityList = new ArrayList<>();

    @OneToMany(targetEntity = ShopEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "areaEntity")
    private List<ShopEntity> shopEntityList = new ArrayList<>();

    public AreaEntity() {
    }

    public AreaEntity(Long id, String province, String city, String town, Long latitude, Long hardness, List<UserEntity> userEntityList, List<ShopEntity> shopEntityList) {
        this.id = id;
        this.province = province;
        this.city = city;
        this.town = town;
        this.latitude = latitude;
        this.hardness = hardness;
        this.userEntityList = userEntityList;
        this.shopEntityList = shopEntityList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getHardness() {
        return hardness;
    }

    public void setHardness(Long hardness) {
        this.hardness = hardness;
    }

    public List<UserEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }

    public List<ShopEntity> getShopEntityList() {
        return shopEntityList;
    }

    public void setShopEntityList(List<ShopEntity> shopEntityList) {
        this.shopEntityList = shopEntityList;
    }

    @Override
    public String toString() {
        return "AreaEntity{" +
                "id=" + id +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", town='" + town + '\'' +
                ", latitude=" + latitude +
                ", hardness=" + hardness +
                ", userEntityList=" + userEntityList +
                ", shopEntityList=" + shopEntityList +
                '}';
    }

}
