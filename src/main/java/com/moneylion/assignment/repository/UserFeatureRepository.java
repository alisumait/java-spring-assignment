package com.moneylion.assignment.repository;

import com.moneylion.assignment.model.UserFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFeatureRepository extends JpaRepository<UserFeature, Long>{
    public UserFeature findByEmailAndFeatureName(String email, String featureName);
}