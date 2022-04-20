package com.chargebee.cbgwalerts.repository;


import com.chargebee.cbgwalerts.entity.DynamicScheduler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DynamicSchedulerRepository extends JpaRepository<DynamicScheduler, Long> {

}
