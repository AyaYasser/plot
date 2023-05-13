package com.plot.common.dto;

import com.plot.repository.entity.ConfigurationEntity;
import io.swagger.annotations.ApiModelProperty;
import java.util.Set;
import java.util.UUID;
import lombok.Data;

/**
 * @author Aya Yasser
 */
@Data
public class PlotResource {

  @ApiModelProperty(notes = "Plot Id is required while editing only", example = "Cairo 2")
  private UUID id;

  @ApiModelProperty(notes = "Plot name", example = "Cairo 2")
  private String name;

  private Set<ConfiguraionResource> configurations;
}
