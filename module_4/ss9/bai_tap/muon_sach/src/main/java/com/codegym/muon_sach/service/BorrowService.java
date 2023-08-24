package com.codegym.muon_sach.service;

import com.codegym.muon_sach.model.BorrowDetail;
import com.codegym.muon_sach.repository.IBorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowService implements IBorrowService{
    @Autowired
    private IBorrowRepository iBorrowRepository;

    @Override
    public void save(BorrowDetail borrowDetail) {
        iBorrowRepository.save(borrowDetail);
    }
}
