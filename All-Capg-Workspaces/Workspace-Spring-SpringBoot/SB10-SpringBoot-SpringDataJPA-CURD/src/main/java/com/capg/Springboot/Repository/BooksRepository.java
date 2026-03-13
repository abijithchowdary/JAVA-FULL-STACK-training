package com.capg.Springboot.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capg.Springboot.Entity.Books;



@Repository
public interface BooksRepository extends CrudRepository<Books,Integer> {

}
