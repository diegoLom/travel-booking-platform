package com.losolved.booking.services.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("flight")
public class FlightFeignClient {

}
