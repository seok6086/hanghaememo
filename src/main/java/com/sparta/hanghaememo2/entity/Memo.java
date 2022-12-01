package com.sparta.hanghaememo2.entity;

import com.sparta.hanghaememo2.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

import jakarta.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Memo extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String password;



    public Memo(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title=requestDto.getTitle();
        this.password=requestDto.getPassword();


    }

    public void update(MemoRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title=requestDto.getTitle();
        this.password=requestDto.getPassword();
    }
}