package com.bookclient.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bookclient.model.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
    private RestTemplate restTemplate;
	
    @Autowired
    private DiscoveryClient discoveryClient;

    
    public List<Book> getAll() {
    	
    	List<Book> books = new ArrayList<Book>();

        List<ServiceInstance> instances = discoveryClient.getInstances("Book-Service");
        if (instances != null && !instances.isEmpty()) {
            ServiceInstance serviceInstance = instances.get(0);
            String url = serviceInstance.getUri().toString();
            url = url + "/books";
            books = restTemplate.getForObject(url, List.class);         
        }
        
        return books;
        
    }

}
