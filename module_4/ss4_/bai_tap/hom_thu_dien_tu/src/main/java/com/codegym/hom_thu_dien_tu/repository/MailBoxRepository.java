package com.codegym.hom_thu_dien_tu.repository;

import com.codegym.hom_thu_dien_tu.model.MailBox;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MailBoxRepository implements IMailBoxRepository{
    private static List<MailBox> mailBoxList =new ArrayList<>();
    static {
        mailBoxList.add(new MailBox(1,"English","5","hashjdsa","ajkjs"));
        mailBoxList.add(new MailBox(2,"English","15","hashjdsa","ajkjs"));
        mailBoxList.add(new MailBox(3,"English","25","hashjdsa","ajkjs"));
    }
    public List<MailBox> findAll(){
        return mailBoxList;
    }
    public void add(MailBox mailBox){
        mailBoxList.add(mailBox);
    }

    public MailBox findById(int id){
        for (MailBox m: mailBoxList) {
            if (m.getId()==id){
                return m;
            }
        }
        return null;
    }

    @Override
    public void edit(int id,MailBox mailBox) {
        for (MailBox mb: mailBoxList) {
            if (mb.getId() == id) {
                mb.setLanguages(mailBox.getLanguages());
                mb.setSizePage(mailBox.getSizePage());
                mb.setSpams(mailBox.getSpams());
                mb.setSignature(mailBox.getSignature());
            }
        }
    }
}
