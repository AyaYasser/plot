package com.plot.controller;

import com.plot.service.IrrigationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Aya Yasser
 */

@RestController
@RequestMapping("irrigate")
public class IrrigationController {
  @Autowired IrrigationService irrigationService;
  @ApiOperation(value = "list all plots ") @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Success") }) @PutMapping(value = "/{configId}") public void irrigate(@PathVariable
      UUID configId) {
    irrigationService.irrigate(configId,0);
  }
}
