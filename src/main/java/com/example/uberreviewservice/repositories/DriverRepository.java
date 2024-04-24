package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>
{
  //Raw SQL Query
  @Query(nativeQuery = true,value = "SELECT * FROM Driver WHERE id = :id AND license_number = :licenseNumber")
  Optional<Driver> rawfindByIdAndLicenseNumber(Long id, String licenseNumber);

  //Hibernate Query
  @Query("SELECT d from Driver d WHERE d.id = :id AND d.licenseNumber = :ln")
  Optional<Driver> HibernateindByIdAndLicense(Long id, String ln);

  List<Driver> findAllByIdIn(List<Long>driverIds);
}
