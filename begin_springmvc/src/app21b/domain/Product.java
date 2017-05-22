package app21b.domain;


import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;



/**
 * Created by lambor on 17-5-22.
 */
public class Product implements Serializable {
    private static final long serialVersionUID = 78L;

    @Size(min = 1,max = 10)
    private String name;

    private String description;
    private Float price;

    @Past
    private Date prouctionDate;

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

    public Date getProuctionDate() {
        return prouctionDate;
    }

    public void setProuctionDate(Date prouctionDate) {
        this.prouctionDate = prouctionDate;
    }
}
