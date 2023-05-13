package com.plot.service;

import java.util.UUID;

/**
 * @author Aya Yasser
 */
public interface IrrigationService {
  void irrigate(UUID configId,int retries);

}
