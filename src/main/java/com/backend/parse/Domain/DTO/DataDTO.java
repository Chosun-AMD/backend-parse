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
    private String fildId;      // mongodb에 저장 시 (자동 생성)
    private String fileName;    // 파일 명
    private Long fileSize;      // 파일 크기
    private String fileData;
    private Data uploadedAt;

    private String userId;
}
