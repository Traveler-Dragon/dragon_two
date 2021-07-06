package com.traveler.server.service;

import com.traveler.server.model.entity.FileExist;

import java.util.List;

public interface FileService {
    List<FileExist> selectAddressByActive(int active);
}
