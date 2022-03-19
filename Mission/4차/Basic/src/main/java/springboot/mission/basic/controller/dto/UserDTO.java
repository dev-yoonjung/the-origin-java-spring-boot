package springboot.mission.basic.controller.dto;

import springboot.mission.basic.entity.UserEntity;

public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private Long areaId;
    private Boolean isShopOwner;

    public UserDTO() {
    }

    public UserDTO(UserEntity userEntity){
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.password = userEntity.getPassword();
        this.areaId = userEntity.getResidence().getId();
        this.isShopOwner = userEntity.getShopOwner();
    }

    public UserDTO(Long id, String username, String password, Long areaId, Boolean isShopOwner) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.areaId = areaId;
        this.isShopOwner = isShopOwner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Boolean getIsShopOwner() {
        return isShopOwner;
    }

    public void setIsShopOwner(Boolean shopOwner) {
        isShopOwner = shopOwner;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", areaId=" + areaId +
                ", isShopOwner=" + isShopOwner +
                '}';
    }
}
