package com.hsa.ga.currency.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Jacksonized
@JsonNaming(SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyExchangeDto {

  @JsonProperty("r030")
  private String r030;
  @JsonProperty("txt")
  private String txt;
  @JsonProperty("rate")
  private String rate;
  @JsonProperty("cc")
  private String cc;
  @JsonProperty("exchangedate")
  private String exchangeDate;

}
