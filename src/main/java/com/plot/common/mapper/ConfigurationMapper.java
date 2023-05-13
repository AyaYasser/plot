package com.plot.common.mapper;

import com.plot.common.dto.ConfiguraionResource;
import com.plot.repository.entity.ConfigurationEntity;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Aya Yasser
 */
@Mapper(imports = { UUID.class })
public interface ConfigurationMapper {
  ConfigurationMapper INSTANCE = Mappers.getMapper(ConfigurationMapper.class);

  ConfiguraionResource mapEntityToModel(ConfigurationEntity entity);
  ConfigurationEntity mapModelToEntity(ConfiguraionResource configuraionResource);

}
