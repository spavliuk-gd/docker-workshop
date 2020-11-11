package com.dockerworkshop.fileservice;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

    private FileRepository repository;

    public FileController(AmazonS3 s3Client, FileRepository repository) {
        this.s3Client = s3Client;
        this.repository = repository;
    }

    public UserFile create(@RequestBody UserFile file) {
        return repository.save(file);
    }

    public UserFile find() {

    }
}
