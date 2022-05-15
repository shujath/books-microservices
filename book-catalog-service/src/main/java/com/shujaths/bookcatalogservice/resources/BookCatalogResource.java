package com.shujaths.bookcatalogservice.resources;

import com.shujaths.bookcatalogservice.models.Book;
import com.shujaths.bookcatalogservice.models.CatalogItem;
import com.shujaths.bookcatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResource {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        List<Rating> ratings = Arrays.asList(
                new Rating("123", 4),
                new Rating("456", 6)
        );

       return ratings.stream().map(rating -> {
            Book book = restTemplate.getForObject("http://localhost:8082/books/"+rating.getBookId(), Book.class);
//            Book book = webClientBuilder.build()
//                    .get()
//                    .uri("http://localhost:8082/books/"+rating.getBookId())
//                    .retrieve()
//                    .bodyToMono(Book.class)
//                    .block();
            return new CatalogItem(book.getName(), "desc", rating.getRating());
        }).collect(Collectors.toList());
    }
}
