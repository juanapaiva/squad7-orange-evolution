package com.api.orangeevolution.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.orangeevolution.entities.Content;

public interface ContentRepository extends JpaRepository<Content, Integer> {

}
