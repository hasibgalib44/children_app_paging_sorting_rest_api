package com.example.springapp.service;
import com.example.springapp.model.Children;
import com.example.springapp.repository.ChildrenRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ChildrenService {
   @Autowired
   private ChildrenRepo chr;

    public void saveChildren(Children c)
    {
       chr.save(c);
    }
    public List<Children> getChildrenSortedByField(String field)
    {
      return chr.findAll(Sort.by(Sort.Direction.ASC,field));
    }


    public List<Children> getChildrenOffsetWithPageSize(String field)
    {
      return chr.findAll(RequestPage.Of(offset,pagesize))
    }
    
}
