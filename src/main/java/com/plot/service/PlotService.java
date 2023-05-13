package com.plot.service;

import com.plot.common.dto.ConfiguraionResource;
import com.plot.common.dto.PlotResource;
import java.util.List;

public interface PlotService {

  List<PlotResource> getAllPlots();
  PlotResource editAndConfigurePlot(PlotResource plotResource) throws Exception;
  PlotResource addPlot(PlotResource plotResource);
  ConfiguraionResource configurePlot(ConfiguraionResource configuraionResource);

}
