package com.plot.common.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import lombok.Data;

/**
 * @author Aya Yasser
 */
@Data
public class ConfiguraionResource {

  @ApiModelProperty(notes = "Id for the configuration")
  private UUID id;

  @ApiModelProperty(notes = "Time slot per minute", example = "1")
  private int timeslot;

  @ApiModelProperty(notes = "Amount of water Litre", example = "2")
  private int water;

  @ApiModelProperty(notes = "Status", example = "SUCCESS")
  private String status;

  private UUID plotId;

}
