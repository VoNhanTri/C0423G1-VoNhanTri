package com.codegym.muon_sach.repository;

import com.codegym.muon_sach.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findBookByNameContaining(Pageable pageable,String name);
}
