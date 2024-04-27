package com.kmj.hcbcservice.repository;

import com.kmj.hcbcservice.document.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HcbcRepository extends MongoRepository<Book, String> {
}
