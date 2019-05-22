package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WhiskyRepository extends JpaRepository<Whisky, Long>, WhiskyRepositoryCustom {
    List<Whisky> findWhiskiesByYear(int Year);

    List<Whisky> findWhiskiesByDistilleryAndAge(String distillery, int age);

    List<Whisky> findWhiskiesByRegion(String region);
}
