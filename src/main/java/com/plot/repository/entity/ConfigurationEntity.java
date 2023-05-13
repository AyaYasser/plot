package com.plot.repository.entity;

import java.util.UUID;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author Aya Yasser
 */
@Table(name = "CONFIGURATION")
@Entity
@Data
@NoArgsConstructor
public class ConfigurationEntity {
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id", columnDefinition = "VARCHAR(255)")
  private UUID id;

  @Column(name = "TIME_SLOT", columnDefinition = "int", nullable = false)
  private int timeSlot;

  @Column(name = "WATER", columnDefinition = "int", nullable = false)
  private int water;

  @Column(name = "PLOT_ID",columnDefinition = "VARCHAR(255)", nullable = false)
  private UUID plotId;

  @Column(name = "STATUS",columnDefinition = "int", nullable = false)
  private int status=2;

  @Column(name = "NO_RETRIES",columnDefinition = "int", nullable = false)
  private int retries=0;

}
