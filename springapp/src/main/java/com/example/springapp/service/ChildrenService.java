package com.example.springapp.service;
import com.example.springapp.model.Children;
import com.example.springapp.repository.ChildrenRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildrenService {
   @Autowired
   private ChildrenRepo chr;

    public void saveChildren(Children c)
    {
       chr.save(c);
    }
    public List<Children> getChildrenSortedByField(String Field)
    {
        
    }
    
}
