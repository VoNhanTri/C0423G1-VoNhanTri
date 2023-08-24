package com.codegym.muon_sach.repository;

import com.codegym.muon_sach.model.BorrowDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowRepository extends JpaRepository<BorrowDetail, String> {
}
