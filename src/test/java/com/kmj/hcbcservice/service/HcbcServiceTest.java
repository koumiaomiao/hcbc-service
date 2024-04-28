package com.kmj.hcbcservice.service;

import com.kmj.hcbcservice.document.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertSame;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HcbcServiceTest {

    @Autowired
    private HcbcService hcbcService;

    private Book book;

    @Test
    public void should_get_the_book_when_create_a_book() {
        book = new Book(1, "title1", "author1", "1998", "123456");
        Book createdBook = hcbcService.save(book);
        assertSame(createdBook, book);
    }
}
