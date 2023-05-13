package com.plot.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Aya Yasser
 */
@Getter
@AllArgsConstructor
public enum StatusEnum {
  SUCCESS(0),
  FAILED(1),
  NOT_STARTED(2)
    ;
    int status;
}
