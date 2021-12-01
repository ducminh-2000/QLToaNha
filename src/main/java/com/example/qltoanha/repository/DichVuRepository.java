package com.example.qltoanha.repository;

import com.example.qltoanha.models.DichVu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DichVuRepository extends CrudRepository<DichVu,Integer> {
}