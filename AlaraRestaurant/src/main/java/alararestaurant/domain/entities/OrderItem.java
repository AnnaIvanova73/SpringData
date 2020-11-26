package alararestaurant.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "order_items")
public class OrderItem extends BaseEntity {

    private Order order;
    private Item item;
    private int quantity;


    public OrderItem() {
    }

    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name = "item_id",nullable = false)
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Min(value = 1)
    @Column(nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
