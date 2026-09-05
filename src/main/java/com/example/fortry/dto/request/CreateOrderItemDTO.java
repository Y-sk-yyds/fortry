package com.example.fortry.dto.request;

import com.example.fortry.dto.OrderItemInfoDTO;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderItemDTO {
    private Long userId;
    private List<OrderItemInfoDTO> orderItemInfoDTOS;
}
