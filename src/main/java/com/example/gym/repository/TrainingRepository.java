package com.example.gym.repository;

import com.example.gym.model.training.TrainingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository <TrainingEntity, Long> {
}
