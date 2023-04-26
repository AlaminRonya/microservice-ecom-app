package com.alamin.productservice.dto.response;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public record ResponseProductDTO(
        Long id, String name, String description, BigDecimal price, Date deletedAt,
        Date createdAt, Date updatedAt, List<ResponseAttachmentDTO> attachmentDTO
) {
}
