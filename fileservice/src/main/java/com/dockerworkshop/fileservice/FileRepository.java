package com.dockerworkshop.fileservice;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface FileRepository extends CrudRepository<UserFile, UUID> {
}
