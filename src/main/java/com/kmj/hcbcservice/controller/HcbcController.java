package com.kmj.hcbcservice.controller;

import com.kmj.hcbcservice.document.Book;
import com.kmj.hcbcservice.service.HcbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class HcbcController {

    @Autowired
    private HcbcService hcbcService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody final Book book) {
        return ResponseEntity.ok(hcbcService.save(book));
    }
}
