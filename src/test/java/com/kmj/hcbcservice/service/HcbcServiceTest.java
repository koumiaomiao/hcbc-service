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

    @BeforeEach
    public void setUp() {
        book = new Book("1", "title1", "author1", "1998", "123456");
    }

    @Test
    public void should_get_the_book_when_create_a_book() {
        Book createdBook = hcbcService.save(book);
        assertSame(createdBook, book);
    }

    @Test
    public void should_get_the_book_when_find_book_by_id() {
        hcbcService.findById(String.valueOf(book.getId())).ifPresent(value -> {
            assertThat(value.getTitle()).isEqualTo(book.getTitle());
        });
    }
}
