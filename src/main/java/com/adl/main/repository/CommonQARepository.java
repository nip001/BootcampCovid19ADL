package com.adl.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adl.main.model.CommonQAModel;

@Repository
public interface CommonQARepository extends JpaRepository<CommonQAModel, Integer>{

}
