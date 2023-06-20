package com.example.rentcarapi.repository;

import com.example.rentcarapi.models.RentalCarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface RentalCarRepository extends JpaRepository<RentalCarEntity, UUID> {
 }