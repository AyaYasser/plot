package com.plot.controller;

import com.plot.common.dto.ConfiguraionResource;
import com.plot.common.dto.PlotResource;
import com.plot.service.PlotService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Aya Yasser
 */

@RestController
@RequestMapping(value = "/plot")
public class PlotController {
  @Autowired
  PlotService plotService;
  @ApiOperation(value = "Add plot ") @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully added") }) @PostMapping(value = "/add") public ResponseEntity<PlotResource> add(
      @RequestBody @Valid PlotResource plotResource) {
    PlotResource plotResourceResult = plotService.addPlot(plotResource);
    return new ResponseEntity<PlotResource>(plotResourceResult, HttpStatus.OK);
  }
  @ApiOperation(value = "Configure plot ") @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully configured") }) @PostMapping(value = "/configure") public ResponseEntity<ConfiguraionResource> configure(
      @RequestBody @Valid ConfiguraionResource configuraionResource ) {
    ConfiguraionResource configuraionResourceResult = plotService.configurePlot(configuraionResource);
    return new ResponseEntity<ConfiguraionResource>(configuraionResourceResult, HttpStatus.OK);
  }

  @ApiOperation(value = "Edit plot ") @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully registered"),
      @ApiResponse(code = 404, message = "This plot is not added before") }) @PutMapping(value = "/edit") public ResponseEntity<PlotResource> edit(
      @RequestBody @Valid PlotResource plotResource) {
    PlotResource plotResourceResult = null;
    try {
      plotResourceResult = plotService.editAndConfigurePlot(plotResource);
      return new ResponseEntity<PlotResource>(plotResourceResult, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<PlotResource>(plotResourceResult, HttpStatus.NOT_FOUND);
    }
  }
  @ApiOperation(value = "list all plots ") @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully registered") }) @GetMapping(value = "/list") public ResponseEntity<List<PlotResource>> list() {
    List<PlotResource> plotResourceResult = plotService.getAllPlots();
    return new ResponseEntity<List<PlotResource>>(plotResourceResult, HttpStatus.OK);
  }
}
