package com.thoughtclan.ProjectAllocationMVC.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thoughtclan.ProjectAllocationMVC.entity.ProjAllocationForm;

@Repository
public interface ProjAllocationFormRepository extends CrudRepository<ProjAllocationForm,Long>{

}
