package jpabook.jpashop.domain;

import jpabook.jpashop.web.BookForm;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateItemDto {

    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

    public UpdateItemDto(BookForm form) {
        this.id = form.getId();
        this.name = form.getName();
        this.price = form.getPrice();
        this.stockQuantity = form.getStockQuantity();
    }
}
