package com.plot.repository.entity;

import java.util.Set;
import java.util.UUID;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author Aya Yasser
 */

@Table(name = "PLOT")
@Entity
@Data
@NoArgsConstructor
public class PlotEntity {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", columnDefinition = "VARCHAR(255)")
  private UUID id;

  @Column(name = "NAME", columnDefinition = "VARCHAR(255)", nullable = false)
  private String name;

  @OneToMany(targetEntity = ConfigurationEntity.class,cascade = CascadeType.ALL)
  @JoinColumn(name = "PLOT_ID", referencedColumnName = "id")
  private Set<ConfigurationEntity> configurations;

}
