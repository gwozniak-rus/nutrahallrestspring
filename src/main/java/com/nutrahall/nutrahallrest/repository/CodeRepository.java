package com.nutrahall.nutrahallrest.repository;


import com.nutrahall.nutrahallrest.data.Code;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends CrudRepository<Code, Integer> {
}
