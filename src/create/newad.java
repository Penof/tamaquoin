package create;

import entities.CritereEntity;

import java.util.List;

public class newad {
    private String title;
    private String description;
    private Double price;

    private Integer categoryId;
    private Integer cityId;

    private Integer userId;

    private List<CritereEntity> critereEntityList;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public List<CritereEntity> getCritereEntityList() {
        return critereEntityList;
    }

    public void setCritereEntityList(List<CritereEntity> critereEntityList) {
        this.critereEntityList = critereEntityList;
    }

    @Override
    public String toString() {
        return "newad{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", categoryId=" + categoryId +
                ", cityId=" + cityId +
                ", userId=" + userId +
                '}';
    }
}
