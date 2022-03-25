package com.eu.shopme.ecommerce;

import com.eu.shopme.ecommerce.controller.OrderController;
import com.eu.shopme.ecommerce.controller.ProductController;
import com.eu.shopme.ecommerce.dto.OrderProductDto;
import com.eu.shopme.ecommerce.model.Order;
import com.eu.shopme.ecommerce.model.Product;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { EcommerceApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EcommerceApplicationIntegrationTest {

    @Autowired private TestRestTemplate restTemplate;

    @LocalServerPort private int port;

    @Autowired private ProductController productController;

    @Autowired private OrderController orderController;

    @Test
    public void contextLoads() {
        Assertions
                .assertThat(productController)
                .isNotNull();
        Assertions
                .assertThat(orderController)
                .isNotNull();
    }

    @Test
    public void givenGetProductsApiCall_whenProductListRetrieved_thenSizeMatchAndListContainsProductNames() {
        ResponseEntity<Iterable<Product>> responseEntity = restTemplate.exchange("http://localhost:" + port + "/api/products", HttpMethod.GET, null, new ParameterizedTypeReference<Iterable<Product>>() {
        });
        Iterable<Product> products = responseEntity.getBody();
        Assertions
                .assertThat(products)
                .hasSize(7);

        assertThat(products, hasItem(hasProperty("name", is("Smartphone MOTOROLA Moto G9 Plus"))));
        assertThat(products, hasItem(hasProperty("name", is("Secretaria Elétrica VINSETTO 920-071V90BK Preto"))));
        assertThat(products, hasItem(hasProperty("name", is("Cadeira Gaming REGALOS MIGUEL Pro Vermelho e Preto"))));
        assertThat(products, hasItem(hasProperty("name", is("Smartphone NOKIA 9 Pureview"))));
        assertThat(products, hasItem(hasProperty("name", is("Auriculares Bluetooth True Wireless JBL T 225"))));
        assertThat(products, hasItem(hasProperty("name", is("Smartwatch ULEFONE GPS Preto e Verde"))));
        assertThat(products, hasItem(hasProperty("name", is("Passadeira de Corrida PRIXTON Run Fit"))));
    }

    @Test
    public void givenGetOrdersApiCall_whenProductListRetrieved_thenSizeMatchAndListContainsProductNames() {
        ResponseEntity<Iterable<Order>> responseEntity = restTemplate.exchange("http://localhost:" + port + "/api/orders", HttpMethod.GET, null, new ParameterizedTypeReference<Iterable<Order>>() {
        });

        Iterable<Order> orders = responseEntity.getBody();
        Assertions
                .assertThat(orders)
                .hasSize(0);
    }

    @Test
    public void givenPostOrder_whenBodyRequestMatcherJson_thenResponseContainsEqualObjectProperties() {
        final ResponseEntity<Order> postResponse = restTemplate.postForEntity("http://localhost:" + port + "/api/orders", prepareOrderForm(), Order.class);
        Order order = postResponse.getBody();
        Assertions
                .assertThat(postResponse.getStatusCode())
                .isEqualByComparingTo(HttpStatus.CREATED);

        assertThat(order, hasProperty("status", is("PAID")));
        assertThat(order.getOrderProducts(), hasItem(hasProperty("quantity", is(2))));
    }

    private OrderController.OrderForm prepareOrderForm() {
        OrderController.OrderForm orderForm = new OrderController.OrderForm();
        OrderProductDto productDto = new OrderProductDto();
        productDto.setProduct(new Product(1L, "Smartphone MOTOROLA Moto G9 Plus", 203.00, "https://www.worten.pt/i/7eac30f7672bd1f4dc46c2eada57e43053c3c640.jpg"));
        productDto.setQuantity(2);
        orderForm.setProductOrders(Collections.singletonList(productDto));

        return orderForm;
    }
}
