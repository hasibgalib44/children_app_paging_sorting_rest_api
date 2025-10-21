package com.example.springapp.service;
import com.example.springapp.model.Children;
import com.example.springapp.repository.ChildrenRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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


    public Page<Children> getChildrenOffsetWithPageSize(int offset,int pagesize)
    {
      return chr.findAll(PageRequest.of(offset,pagesize));
    }


    public Page<Children> getChildrenOffsetWithPageSizeSortedByField(
        int offset,int pagesize,String field)
    {
        PageRequest pageRequest = PageRequest.of(offset, pagesize, 
        Sort.by(Sort.Direction.ASC, field));
        return chr.findAll(pageRequest);
    }
    
}
