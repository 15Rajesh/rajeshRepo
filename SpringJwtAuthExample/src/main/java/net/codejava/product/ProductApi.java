package net.codejava.product;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductApi {

	@Autowired private ProductRepository repo;
	
	@PostMapping(value = "/save")
	public ResponseEntity<Product> create(@RequestBody @Valid Product product) {
		System.out.println("ENTERED SAVE METHOD");
		Product savedProduct = repo.save(product);
		URI productURI = URI.create("/save");
		System.out.println("This is my uri :" + productURI);
		return ResponseEntity.created(productURI).body(savedProduct);
		
	}
	
	@GetMapping
	public List<Product> list() {
		return repo.findAll();
	}
}
