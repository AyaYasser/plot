package com.plot.scheduler;

import com.plot.common.StatusEnum;
import com.plot.repository.ConfigurationRepository;
import com.plot.repository.entity.ConfigurationEntity;
import com.plot.service.IrrigationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Aya Yasser
 */
@Service
public class Scheduler {
  private static int MAX_RETRIES=5;
  @Autowired IrrigationService irrigationService;
  @Autowired ConfigurationRepository configurationRepository;
  @Scheduled(fixedRate = 1000)
  public void retry() {
      List<ConfigurationEntity> configurationEntityList=configurationRepository.findByStatusAndRetriesLessThan(StatusEnum.FAILED.getStatus(), MAX_RETRIES);
      configurationEntityList.forEach(e->{
        irrigationService.irrigate(e.getId(),e.getRetries()+1);
      });
  }
  @Scheduled(fixedRate = 1000)
  public void alert() {
    List<ConfigurationEntity> configurationEntityList=configurationRepository.findByStatusAndRetries(StatusEnum.FAILED.getStatus(), MAX_RETRIES);
    configurationEntityList.forEach(e->{
      irrigationService.irrigate(e.getId(),e.getRetries()+1);
    });
  }
}
