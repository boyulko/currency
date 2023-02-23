package com.hsa.ga.currency.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsa.ga.currency.dto.EventRequestDto;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyEventSender {

  @Value("${ga.url}")
  private String gaUrl;

  public void sendEvent(EventRequestDto eventRequestDto) {
    var restTemplate = new RestTemplate();
    var headers = new HttpHeaders();
    headers.set("User-Agent", "application");
    headers.set("Content-Type", "application/json");
    var entity = new HttpEntity<>(eventRequestDto, headers);
    ResponseEntity<String> response = restTemplate.postForEntity(gaUrl, entity, String.class);
  }

}
