package common;

import javax.swing.*;
import java.util.Map;

public class searchFields {

    private Integer categoryId;
    private Integer cityId;
    private String keyword;
    private String priceMin;
    private String priceMax;

    public searchFields(Integer categoryId, Integer cityId, String keyword, String priceMin, String search_priceMax) {
        this.categoryId = categoryId;
        this.cityId = cityId;
        this.keyword = keyword;
        this.priceMin = priceMin;
        this.priceMax = search_priceMax;
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
