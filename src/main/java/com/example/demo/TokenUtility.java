package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class TokenUtility {

  @Lazy
  @Autowired
  Paypal paypal;

  @PostConstruct
  public void init() {
    HttpClient client = HttpClient.newHttpClient();
    try {
      HttpResponse<String> result = client
          .send(HttpRequest.newBuilder().uri(URI.create("http://www.google.com")).build(),
                HttpResponse.BodyHandlers
                    .ofString());

      System.out.println("TokenUtility init with status code=" + result.statusCode());
      paypal.init();
    } catch (IOException e) {
      // To  handle
    } catch (InterruptedException e) {
      // To  handle
    }
  }
}
