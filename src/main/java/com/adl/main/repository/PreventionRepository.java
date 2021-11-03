package com.adl.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adl.main.model.PreventionModel;

@Repository
public interface PreventionRepository extends JpaRepository<PreventionModel, Integer>{

}
