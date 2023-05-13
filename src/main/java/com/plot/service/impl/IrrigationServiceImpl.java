package com.plot.service.impl;

import com.plot.common.StatusEnum;
import com.plot.integration.SensorFeignService;
import com.plot.repository.ConfigurationRepository;
import com.plot.service.IrrigationService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Aya Yasser
 */
@Service
public class IrrigationServiceImpl implements IrrigationService {
  @Autowired SensorFeignService      sensorFeignService;
  @Autowired ConfigurationRepository configurationRepository;
  @Override public void irrigate(UUID configId,int retries) {
      try{
        sensorFeignService.irrigate(configId);
        configurationRepository.updateStatus(StatusEnum.SUCCESS.getStatus(),retries,configId);
      }catch (Exception e){
        configurationRepository.updateStatus(StatusEnum.FAILED.getStatus(),retries,configId);
      }

  }
}
