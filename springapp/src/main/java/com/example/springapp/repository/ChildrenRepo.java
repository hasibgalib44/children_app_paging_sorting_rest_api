package com.example.springapp.repository;
import com.example.springapp.model.Children;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ChildrenRepo extends JpaRepository<Children,Integer>{
    
}
