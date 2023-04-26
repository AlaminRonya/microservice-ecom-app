package com.alamin.productservice.mapper;

import com.alamin.productservice.dto.response.ResponseAttachmentDTO;
import com.alamin.productservice.dto.response.ResponseProductDTO;
import com.alamin.productservice.model.Attachment;
import com.alamin.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ResponseAttachmentDTOMapper implements Function<Attachment, ResponseAttachmentDTO> {
    @Override
    public ResponseAttachmentDTO apply(Attachment attachment) {
        return new ResponseAttachmentDTO(attachment.getId(), attachment.getAttachmentName(), attachment.getAttachmentPath(), attachment.getAttachmentType());
    }
}
