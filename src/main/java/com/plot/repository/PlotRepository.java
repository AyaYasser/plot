package com.plot.repository;

import com.plot.repository.entity.PlotEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PlotRepository extends JpaRepository<PlotEntity, UUID> {

}
