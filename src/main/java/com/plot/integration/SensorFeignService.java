package com.plot.integration;

import java.util.UUID;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Aya Yasser
 */
@FeignClient(name="Sensor", url="http://localhost:9090")
public interface SensorFeignService {
  @GetMapping(value="/irrigate/${configId}")
  void irrigate(@PathVariable UUID configId);

}

