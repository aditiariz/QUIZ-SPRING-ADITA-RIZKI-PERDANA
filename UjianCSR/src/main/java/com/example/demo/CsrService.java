package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class CsrService {
 
    @Autowired
    private CsrRepository repo;
     
    public List<Tblprogramcsr> listAll() {
        return repo.findAll();
    }
     
    public void save(Tblprogramcsr tblprogramcsr) {
        repo.save(tblprogramcsr);
    }
     
    public Tblprogramcsr get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}
