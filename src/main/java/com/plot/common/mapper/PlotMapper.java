package com.plot.common.mapper;

import com.plot.common.dto.PlotResource;
import com.plot.repository.entity.PlotEntity;
import java.util.List;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Aya Yasser
 */

@Mapper(imports = { UUID.class })
public interface PlotMapper {
  PlotMapper INSTANCE = Mappers.getMapper(PlotMapper.class);

  PlotEntity mapModelToEntity(PlotResource plotResource);
  PlotResource mapEntityToModel(PlotEntity plotEntity);

  List<PlotResource> mapListEntityToListModel(List<PlotEntity> plotEntities);

}
