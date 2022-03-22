package com.eu.shopme.product;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    // productService constructor injection

    @GetMapping(value = { "", "/" })
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }
}

    @Bean
    CommandLineRunner runner(ProductService productService) {
        return args -> {
            productService.save(...);
            // more products
        }
