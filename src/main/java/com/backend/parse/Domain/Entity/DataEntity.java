package com.backend.parse.Domain.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Collectiin을 지정합니다.
 * 우선은 임시 값입니다.
 * @author : 황시준
 * @since : 1.0
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="amd-db")
// 가지고 있는 객체나 정보를 전송하거나 Database에 저장할 때 마샬링 작업을 위해 직렬화 해주어야 한다.
public class DataEntity implements Serializable {
    @Id
    private String id;
    private String fileId;
    private String fileName;
    private int fileSize;
    private String fileHash;
    private boolean isVuln;
    private Date uploadedAt;

    public DataEntity(String id, String fileId, String fileName, int fileSize, String fileHash, boolean isVuln, String uploadedAtStr) throws ParseException {
        this.id = id;
        this.fileId = fileId;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileHash = fileHash;
        this.isVuln = isVuln;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.uploadedAt = dateFormat.parse(uploadedAtStr);
    }
}
