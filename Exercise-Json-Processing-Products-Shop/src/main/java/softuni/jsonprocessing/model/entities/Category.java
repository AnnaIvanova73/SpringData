package softuni.jsonprocessing.model.entities;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {


    private String name;

    private Set<Product> products;

    public Category() {
    }

    @Column(name = "name")
    @Length(min = 3, max = 15)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "products_categories",joinColumns = @JoinColumn(name = "categories_id"),
    inverseJoinColumns = @JoinColumn(name = "products_id"))
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
