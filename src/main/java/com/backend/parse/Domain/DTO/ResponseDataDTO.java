package com.backend.parse.Domain.DTO;

import com.backend.parse.Domain.Entity.DataEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

/**
 * Database에서 데이터를 파싱해 값을 전달할 떄 쓰이는 DTO입니다.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDataDTO {
    private String id;      // 파일 ID(자동 생성)
    private String fileId;  // 파일
    private String fileName;
    private int fileSize;
    private String fileHash;
    private boolean isVuln;
    private Date uploadedAt;

    public ResponseDataDTO() {}

    public ResponseDataDTO(DataEntity dataEntity) {
        this.id = dataEntity.getId();
        this.fileId = dataEntity.getFileId();
        this.fileName = dataEntity.getFileName();
        this.fileSize = dataEntity.getFileSize();
        this.fileHash = dataEntity.getFileHash();
        this.isVuln = dataEntity.isVuln();
        this.uploadedAt = dataEntity.getUploadedAt();
    }
}