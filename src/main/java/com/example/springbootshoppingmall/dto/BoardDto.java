package com.example.springbootshoppingmall.dto;

import com.example.springbootshoppingmall.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@AllArgsConstructor
@ToString
public class BoardDto {
    private int board_id;
    private String title;
    private String content;
    private Timestamp created_time;
    private String user_id;

    public BoardEntity toEntity() { return new BoardEntity(board_id, title, content, created_time, user_id); }
}