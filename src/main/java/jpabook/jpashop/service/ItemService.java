package jpabook.jpashop.service;

import jpabook.jpashop.Repository.ItemRepository;
import jpabook.jpashop.domain.UpdateItemDto;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.web.BookForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(BookForm form) {
        Book book = Book.createBook(
                form.getName(),
                form.getPrice(),
                form.getStockQuantity(),
                form.getAuthor(),
                form.getIsbn()
        );
        itemRepository.save(book);
    }
    @Transactional
    public void updateItem(UpdateItemDto itemDto) {
        Item findItem = itemRepository.findOne(itemDto.getId());
        findItem.updateItem(itemDto.getName(), itemDto.getPrice(), itemDto.getStockQuantity());
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
