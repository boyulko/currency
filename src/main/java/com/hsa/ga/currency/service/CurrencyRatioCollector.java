package com.hsa.ga.currency.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsa.ga.currency.dto.CurrencyExchangeDto;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyRatioCollector {

  @Value("${exchange.usd.url}")
  private String usdRatioUrl;

  public CurrencyExchangeDto collectCurrentUsdRatio() throws JsonProcessingException {
    RestTemplate restTemplate = new RestTemplate();
    var response
        = restTemplate.getForEntity(usdRatioUrl, String.class);
    var mapper = new ObjectMapper();
    var currencyExchangeDtos = Arrays.asList(mapper.readValue(response.getBody(), CurrencyExchangeDto[].class));
    return currencyExchangeDtos.stream().findAny().orElseThrow();
  }

}
