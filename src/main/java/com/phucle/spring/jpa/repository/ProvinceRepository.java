package com.phucle.spring.jpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucle.spring.jpa.entity.Province;
@Repository("provinceRepository")
public interface ProvinceRepository extends JpaRepository<Province, Integer> {
}
