package com.codegym.muon_sach.service;

import com.codegym.muon_sach.model.Book;
import com.codegym.muon_sach.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable, String name) {
        return iBookRepository.findBookByNameContaining(pageable, name);
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id).get();
    }
}
