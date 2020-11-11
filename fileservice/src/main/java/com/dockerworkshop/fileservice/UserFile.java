package com.dockerworkshop.fileservice;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.UUID;

@Data
@Entity
public class UserFile {

    @Id
    private UUID id;

    private String keyname;

    @Transient
    private MultipartFile file;

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
