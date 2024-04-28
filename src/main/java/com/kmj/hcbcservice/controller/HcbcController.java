package com.kmj.hcbcservice.controller;

import com.kmj.hcbcservice.document.Book;
import com.kmj.hcbcservice.service.HcbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HcbcController {

    @Autowired
    private HcbcService hcbcService;

    @PostMapping("/book")
    public ResponseEntity<?> create(@RequestBody final Book book) {
        return ResponseEntity.ok(hcbcService.save(book));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> findById(@PathVariable final String id) {
        final var response = hcbcService.findById(id);
        if (response.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response.get());
    }
}
