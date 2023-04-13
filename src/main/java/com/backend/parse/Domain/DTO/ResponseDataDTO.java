package com.backend.parse.Domain.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Database에서 데이터를 파싱해 값을 전달할 떄 쓰이는 DTO입니다.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDataDTO {
    private String fildId;
    private String fileName;
    private int fileSize;
    private String fileHash;
    private int isVuln;

    private Data uploadedAt;
}