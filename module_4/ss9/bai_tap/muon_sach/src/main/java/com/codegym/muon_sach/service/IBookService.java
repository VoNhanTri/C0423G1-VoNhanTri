package com.codegym.muon_sach.service;

import com.codegym.muon_sach.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {

    Page<Book> findAll(Pageable pageable, String name);

    Book findById(int id);
}
