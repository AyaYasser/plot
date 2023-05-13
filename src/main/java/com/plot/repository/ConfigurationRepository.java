package com.plot.repository;

import com.plot.repository.entity.ConfigurationEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Aya Yasser
 */
@Transactional
public interface ConfigurationRepository extends JpaRepository<ConfigurationEntity, UUID> {
  @Modifying
  @Query("update ConfigurationEntity c set c.status = :status , c.retries = :retries where c.id = :id")
  void updateStatus(@Param("status") int status, @Param("retries") int retries,@Param("id") UUID id);

  List<ConfigurationEntity> findByStatusAndRetriesLessThan(int status,int retries);
  List<ConfigurationEntity> findByStatusAndRetries(int status,int retries);



}
