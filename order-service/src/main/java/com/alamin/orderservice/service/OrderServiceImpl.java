package com.alamin.orderservice.service;

import com.alamin.orderservice.dto.InventoryResponse;
import com.alamin.orderservice.dto.RequestOrderDTO;
import com.alamin.orderservice.dto.RequestOrderLineItemDTO;
import com.alamin.orderservice.interfaces.OrderService;
import com.alamin.orderservice.model.Order;
import com.alamin.orderservice.model.OrderLineItems;
import com.alamin.orderservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final WebClient webClient;
    @Override
    public void placeOrder(RequestOrderDTO dto) {
        System.out.println("=======>"+dto);
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        final List<OrderLineItems> orderLineItems = dto.orderLineItemDTOS().stream().map(this::mapToDto).toList();

        order.setOrderLineItemsList(orderLineItems);

        List<String> skuCodes = order.getOrderLineItemsList().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();

        // TODO: 4/25/2023 webclient

        final InventoryResponse[] inventoryResponsesArray = webClient.get()
                .uri("http://localhost:8082/inventory", uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        assert inventoryResponsesArray != null;
        if (inventoryResponsesArray.length == orderLineItems.size()){
            orderRepository.save(order);
        }else {
            throw new IllegalArgumentException("Product is not available");
        }



//        final boolean allProductInStock = Arrays.stream(inventoryResponsesArray)
//                .allMatch(InventoryResponse::isInStock);
//        if (allProductInStock){
//            orderRepository.save(order);
//        }else {
//            throw new IllegalArgumentException("Product is not available");
//        }

    }

    private OrderLineItems mapToDto(RequestOrderLineItemDTO item) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(item.price());
        orderLineItems.setSkuCode(item.skuCode());
        orderLineItems.setQuantity(item.quantity());
        return orderLineItems;
    }
}
