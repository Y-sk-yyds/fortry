package com.example.fortry.dto.response;

import com.example.fortry.dto.OrderInfoDTO;
import lombok.Data;

import java.util.List;

@Data
public class OrdersForShowDTO {
    List<OrderInfoDTO> orderInfoDTOS;
}
