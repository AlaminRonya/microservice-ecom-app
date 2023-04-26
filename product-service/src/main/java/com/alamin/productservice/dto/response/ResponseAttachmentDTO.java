package com.alamin.productservice.dto.response;

import jakarta.persistence.Column;

public record ResponseAttachmentDTO(
        Long id,String attachmentName,String attachmentPath,String attachmentType
) {
}
