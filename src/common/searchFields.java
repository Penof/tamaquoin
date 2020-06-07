package common;

import javax.swing.*;
import java.util.Map;

public class searchFields {

    private Integer categoryId;
    private Integer cityId;
    private String keyword;
    private Double priceMin;
    private Double priceMax;

    public searchFields(Integer categoryId, Integer cityId, String keyword, Double priceMin, Double search_priceMax) {
        this.categoryId = categoryId;
        this.cityId = cityId;
        this.keyword = keyword;
        this.priceMin = priceMin;
        this.priceMax = search_priceMax;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public String getKeyword() {
        return keyword;
    }

    public Double getPriceMin() {
        return priceMin;
    }

    public Double getPriceMax() {
        return priceMax;
    }

    @Override
    public String toString() {
        return "searchFields{" +
                "category='" + categoryId + '\'' +
                ", city='" + cityId + '\'' +
                ", keyword='" + keyword + '\'' +
                ", priceMin='" + priceMin + '\'' +
                ", priceMax='" + priceMax + '\'' +
                '}';
    }
}
