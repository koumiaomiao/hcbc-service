package com.kmj.hcbcservice.controller;

import com.kmj.hcbcservice.document.Book;
import com.kmj.hcbcservice.service.HcbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class HcbcController {

    @Autowired
    private HcbcService hcbcService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody final Book book) {
        return ResponseEntity.ok(hcbcService.save(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable final String id) {
        hcbcService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable final String id, @RequestBody final Book book) {
        Optional<Book> response = hcbcService.findById(id);
        if (response.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(hcbcService.update(book));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable final String id) {
        Optional<Book> response = hcbcService.findById(id);
        if (response.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response.get());
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<Book> response = hcbcService.findAll();
        return ResponseEntity.ok(response);
    }
}
