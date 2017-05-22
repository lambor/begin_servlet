package app21a.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lambor on 17-5-20.
 */
public class Product implements Serializable {
    private static final long serialVersionUID = 748392358L;
    private String name;
    private String description;
    private Float price;
    private Date productionDate;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }
}
