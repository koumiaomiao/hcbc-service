package com.kmj.hcbcservice.service;

import com.kmj.hcbcservice.document.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertSame;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HcbcServiceTest {

    @Autowired
    private HcbcService hcbcService;

    private Book book;
    private Book createdBook;

    @BeforeEach
    public void setUp() {
        book = new Book("1", "title1", "author1", "1998", "123456");
        createdBook = hcbcService.save(book);
    }

    @Test
    public void should_get_the_book_when_create_a_book() {
        assertSame(createdBook, book);
    }

    @Test
    public void should_get_the_book_when_find_book_by_id() {
        hcbcService.findById(book.getId()).ifPresent(value -> {
            assertThat(value.getTitle()).isEqualTo(book.getTitle());
        });
    }

    @Test
    public void should_get_latest_book_when_update_book_info() {
        Book anotherBook = new Book("1", "titlex", "authorx", "1998", "123456");
        Book updatedBook = hcbcService.update(anotherBook);
        assertThat(updatedBook.getTitle()).isEqualTo(anotherBook.getTitle());
    }

    @Test
    public void should_not_find_book_when_delete_a_book() {
        hcbcService.deleteById(book.getId());
        assertThat(hcbcService.findById(book.getId())).isEmpty();
    }
}
