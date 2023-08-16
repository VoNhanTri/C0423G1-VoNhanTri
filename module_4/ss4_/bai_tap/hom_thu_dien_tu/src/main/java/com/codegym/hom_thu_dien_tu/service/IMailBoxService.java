package com.codegym.hom_thu_dien_tu.service;

import com.codegym.hom_thu_dien_tu.model.MailBox;

import java.util.List;

public interface IMailBoxService {
    List<MailBox> findAll();
    void add(MailBox mailBox);
    MailBox findById(int id);

    void edit(int id,MailBox mailBox);
}
