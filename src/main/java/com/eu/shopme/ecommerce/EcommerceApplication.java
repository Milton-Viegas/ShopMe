package com.eu.shopme.ecommerce;

import com.eu.shopme.ecommerce.model.Product;
import com.eu.shopme.ecommerce.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductService productService) {
        return args -> {
            productService.save(new Product(1L, "Smartphone MOTOROLA Moto G9 Plus", 203.00, "https://www.worten.pt/i/7eac30f7672bd1f4dc46c2eada57e43053c3c640.jpg"));
            productService.save(new Product(2L, "Secretaria Elétrica VINSETTO 920-071V90BK Preto", 406.99, "https://www.worten.pt/i/bc743a808a9770a590a7dd2de01bd18f3f7bcaf7.jpg"));
            productService.save(new Product(3L, "Cadeira Gaming REGALOS MIGUEL Pro Vermelho e Preto", 82.40, "https://www.worten.pt/i/5bd58039490a790c7ea89226a7a869329998d3c2.jpg"));
            productService.save(new Product(4L, "Smartphone NOKIA 9 Pureview", 599.99, "https://www.worten.pt/i/d09d2fd25ea4a73a300635da70c5255604336785.jpg"));
            productService.save(new Product(5L, "Auriculares Bluetooth True Wireless JBL T 225", 69.99, "https://www.worten.pt/i/255a9f170c46d6139b88598918dfb4e4de3d329e.jpg"));
            productService.save(new Product(6L, "Smartwatch ULEFONE GPS Preto e Verde", 39.99, "https://www.worten.pt/i/f748f2100c7ef6de82cee46f5cba195f9758647c.jpg"));
            productService.save(new Product(7L, "Passadeira de Corrida PRIXTON Run Fit", 279.95, "https://www.worten.pt/i/451fb0fa804ed40ba2f068971ff9fc47d612e402.jpg"));
        };
    }
}
