package com.example.springbootshoppingmall.repository;

import com.example.springbootshoppingmall.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends CrudRepository<BoardEntity, Integer> {
}
