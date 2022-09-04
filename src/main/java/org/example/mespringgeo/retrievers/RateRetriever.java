package org.example.mespringgeo.retrievers;

import org.example.mespringgeo.json.Rate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RateRetriever {

    private static final String URL = "https://api.apilayer.com/fixer/latest?apikey=1yfqEbNIuCR8K6SnhXczvpVmxt3R1B7U";

    @Cacheable("rates")
    public Rate getRate() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Rate> response = restTemplate.getForEntity(URL, Rate.class);
        return response.getBody();
    }
}
