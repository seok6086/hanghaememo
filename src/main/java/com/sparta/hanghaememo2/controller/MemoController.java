package com.sparta.hanghaememo2.controller;

import com.sparta.hanghaememo2.dto.MemoRequestDto;
import com.sparta.hanghaememo2.entity.Memo;
import com.sparta.hanghaememo2.repository.MemoRepository;
import com.sparta.hanghaememo2.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {
    
    private final MemoService memoService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index"); //
    }

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){
        
        return memoService.createMemo(requestDto);


    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos(){
        return memoService.getMemos();
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        Memo memo = MemoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (memo.getPassword().equals(requestDto.getPassword())) {
            memoService.update(id, requestDto);
            return id;
        } else return 0L;
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        Memo memo = MemoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        if (memo.getPassword().equals(requestDto.getPassword())) {
            memoService.deleteMemo(id);
            return id;
        } else return 0L;
    }
}


