package com.plot.service.impl;

import com.plot.common.dto.ConfiguraionResource;
import com.plot.common.dto.PlotResource;
import com.plot.common.mapper.ConfigurationMapper;
import com.plot.common.mapper.PlotMapper;
import com.plot.repository.ConfigurationRepository;
import com.plot.repository.entity.PlotEntity;
import com.plot.service.PlotService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plot.repository.PlotRepository;

@Service
public class PlotServiceImpl implements PlotService {
  @Autowired PlotRepository          plotRepository;
  @Autowired ConfigurationRepository configurationRepository;

  @Override public List<PlotResource> getAllPlots() {
    return PlotMapper.INSTANCE.mapListEntityToListModel(plotRepository.findAll());
  }

  @Override public PlotResource editAndConfigurePlot(PlotResource plotResource) throws Exception {
    Optional<PlotEntity> plotEntities=plotRepository.findById(plotResource.getId());
    if(plotEntities.isPresent())
      return PlotMapper.INSTANCE.mapEntityToModel(plotRepository.save(PlotMapper.INSTANCE.mapModelToEntity(plotResource)));
    else
      throw new Exception("This plot Id is not added before");
  }

  @Override public PlotResource addPlot(PlotResource plotResource) {
    return PlotMapper.INSTANCE.mapEntityToModel(plotRepository.save(PlotMapper.INSTANCE.mapModelToEntity(plotResource)));
  }

  @Override public ConfiguraionResource configurePlot(ConfiguraionResource configuraionResource) {
    return ConfigurationMapper.INSTANCE.mapEntityToModel(configurationRepository.save(ConfigurationMapper.INSTANCE.mapModelToEntity(configuraionResource)));
  }

}
