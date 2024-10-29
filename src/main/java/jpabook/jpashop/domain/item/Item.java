package jpabook.jpashop.domain.item;

import jakarta.persistence.*;
import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    public void updateItem(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    //==비즈니스 로직==/

    /**
     * 재고 증가
     */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }
    /**
     * 재고 감소
     */
    public void removeStock(int quantity){
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }

    public void changeName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("상품 이름은 필수입니다.");
        }
        this.name = name;
    }
    public void changePrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("가격은 0 이상이어야 합니다.");
        }
        this.price = price;
    }

    public void changeStockQuantity(int stockQuantity) {
        if (stockQuantity < 0) {
            throw new IllegalArgumentException("재고 수량은 0 이상이어야 합니다.");
        }
        this.stockQuantity = stockQuantity;
    }
}
