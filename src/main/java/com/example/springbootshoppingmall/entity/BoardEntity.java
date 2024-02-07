package com.example.springbootshoppingmall.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name="board")
@AllArgsConstructor
@ToString
@Setter
@Getter
@Embeddable
@NoArgsConstructor
public class BoardEntity {
    @Id
    private int board_id;

    @Column
    private String title;
    @Column
    private String content;
    @Column
    private Timestamp created_time;
    @Column
    private String user_id;
}
