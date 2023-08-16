package com.codegym.hom_thu_dien_tu.service;

import com.codegym.hom_thu_dien_tu.model.MailBox;
import com.codegym.hom_thu_dien_tu.repository.IMailBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailBoxService implements IMailBoxService {
    @Autowired
    private  IMailBoxRepository mailBoxRepository;

    @Override
    public List<MailBox> findAll() {

        return mailBoxRepository.findAll();
    }

    @Override
    public void add(MailBox mailBox) {
        mailBoxRepository.add(mailBox);
    }

    @Override
    public MailBox findById(int id) {
        return mailBoxRepository.findById(id);
    }

    @Override
    public void edit(int id,MailBox mailBox) {
        mailBoxRepository.edit(id,mailBox);
    }
}
