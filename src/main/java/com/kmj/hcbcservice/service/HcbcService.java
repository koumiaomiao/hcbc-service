package com.kmj.hcbcservice.service;

import com.kmj.hcbcservice.document.Book;
import com.kmj.hcbcservice.repository.HcbcRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class HcbcService {

    @Autowired
    private HcbcRepository hcbcRepository;

    public Book save(Book book) {
        return hcbcRepository.save(book);
    }

    public Optional<Book> findById(String id) {
        return hcbcRepository.findById(id);
    }

    public Book update(Book book) {
        return hcbcRepository.save(book);
    }
}
