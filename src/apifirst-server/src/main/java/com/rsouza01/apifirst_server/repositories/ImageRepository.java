package com.rsouza01.apifirst_server.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsouza01.apifirst_server.domain.Image;

public interface ImageRepository extends JpaRepository<Image, UUID> {
}