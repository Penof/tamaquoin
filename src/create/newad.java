package create;

public class newad {
    private String title;
    private String description;
    private Double price;

    private Integer categoryId;
    private Integer cityId;

    private Integer userId;

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
