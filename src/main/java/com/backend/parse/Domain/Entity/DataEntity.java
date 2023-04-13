package com.backend.parse.Domain.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Database Key를 지정합니다.
 * 우선은 임시 값입니다.
 * @author : 황시준
 * @since : 1.0
 */

/*
insert into entity(file_Id, file_Name, file_Size, file_Hash, is_Vuln) values('FILE-ID-001', 'FileName1', 1000, 'aaaaaaaaaaaaaaaa', 1);
insert into entity(file_Id, file_Name, file_Size, file_Hash, is_Vuln) values('FILE-ID-002', 'FileName2', 2000, 'bbbbbbbbbbbbbbbb', 1);
insert into entity(file_Id, file_Name, file_Size, file_Hash, is_Vuln) values('FILE-ID-003', 'FileName3', 3000, 'cccccccccccccccc', 0);
 */
@Data
@Entity
@Table(name="entity")
// 가지고 있는 객체나 정보를 전송하거나 Database에 저장할 때 마샬링 작업을 위해 직렬화 해주어야 한다.
public class DataEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length=150, unique = true)
    private String fileId;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private int fileSize;

    @Column(nullable = false)
    private String fileHash;

    @Column(nullable = false)
    private int isVuln;

    @Column(nullable = false, updatable = false, insertable=false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP") // 현재 시간을 넣는 방법
    private Date uploadedAt;
}
