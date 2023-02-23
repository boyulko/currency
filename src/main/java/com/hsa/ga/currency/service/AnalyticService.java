package com.hsa.ga.currency.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hsa.ga.currency.dto.EventDto;
import com.hsa.ga.currency.dto.EventRequestDto;
import com.hsa.ga.currency.event.CurrencyEventSender;
import java.util.Map;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalyticService {

  private final CurrencyRatioCollector ratioPuller;
  private final CurrencyEventSender eventSender;

  public void collectAndSendAnalytics() throws JsonProcessingException {
    var currencyExchangeDto = ratioPuller.collectCurrentUsdRatio();
    var requestDto = new EventRequestDto("555", // random value, does not affect logic
        Set.of(new EventDto("currency_rate",
            Map.of("ratio", currencyExchangeDto.getRate()
                , "valcode", currencyExchangeDto.getCc()))));
    eventSender.sendEvent(requestDto);

  }


}
