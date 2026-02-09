package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import net.engineeringdigest.journalApp.cache.AppCache;
import net.engineeringdigest.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apikey;

    @Autowired
    private RestTemplate restTemplate;                            // This helps to handle the http commands and response

    @Autowired
    private AppCache appCache;

    @Autowired
    private RedisService redisService;

    public WeatherResponse getWeather(String city){
        WeatherResponse weatherResponse = redisService.get("weather_of_" + city, WeatherResponse.class);
        // Here the actual api will be called only if weatherResponse from redis is null means that the data is not in redis
        // or it is expired otherwise if it is not null the weatherResponse from redis will be return
        // It will decrease the api calls if called by many users frequently reducing the cost
        if (weatherResponse != null){
            return weatherResponse;
        }
        else{
            String finalAPI = appCache.app_Cache.get("weather_api").replace("<apiKey>",apikey).replace("<city>",city);
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET,null, WeatherResponse.class);
            WeatherResponse body = response.getBody();
            if (body != null){
                redisService.set("weather_of_" + city, body,300l);
            }
            return body;
        }

//        HttpHeaders httpHeaders = new HttpHeaders();                                         // This is for Post Call
//        httpHeaders.set("key", "value");
//        User user = User.builder().username("Vipul").password("Vipul").build();
//        HttpEntity<User> httpEntity = new HttpEntity<>(user, httpHeaders);
//
//        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.POST, httpEntity, WeatherResponse.class);

    }
}
