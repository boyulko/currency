package com.hsa.ga.currency.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hsa.ga.currency.service.AnalyticService;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CurrencyRatioEventScheduler {

  private final AnalyticService analyticService;

  @Scheduled(fixedDelay = 10, initialDelay = 0, timeUnit = TimeUnit.MINUTES)
  public void run() throws JsonProcessingException {
    log.info("Execution started at {}", Instant.now().toString());
    analyticService.collectAndSendAnalytics();
  }

}
