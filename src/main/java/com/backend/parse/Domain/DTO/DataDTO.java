package com.backend.parse.Domain.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Database에서 데이터를 파싱해 읽어들일 DTO입니다.
 * 우선은 임시로 작성했습니다.
 * @author : 황시준
 * @since : 1.0
 */
@Getter
@Setter
public class DataDTO implements Serializable {
    private String fildId;
    private String fileName;
    private Long fileSize;
    private String fileData;
    private Data uploadedAt;

    private String userId;
}
