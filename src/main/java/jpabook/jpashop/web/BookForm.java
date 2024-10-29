package jpabook.jpashop.web;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookForm {

    private Long id;

    @NotEmpty(message = "상품 이름은 필수입니다.")
    private String name;

    @Min(value = 0, message = "가격은 0 이상이어야 합니다.")
    private int price;

    @Min(value = 0, message = "재고 수량은 0 이상이어야 합니다.")
    private int stockQuantity;

    @NotEmpty(message = "저자는 필수입니다.")
    private String author;

    @NotEmpty(message = "ISBN은 필수입니다.")
    private String isbn;
}
