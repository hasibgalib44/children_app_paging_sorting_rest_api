package com.example.springapp.repository;
import com.example.springapp.model.Children;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildrenRepo extends JpaRepository<Children,Integer>{
    
}
