package com.example.backend.controller;

import java.util.List;
import com.example.backend.domain.entity.Issue_board;
import com.example.backend.dto.IsBoardDto;
import com.example.backend.dto.ReplyDto;
import com.example.backend.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BoardController {//test2

    private final BoardService boardService;

    @GetMapping("/board")//read boardList and paging
    public Page<Issue_board> boardList(Pageable pageable){
                                        
        log.info("boardList");

        Page<Issue_board> isboard = boardService.boardList(pageable);
        
        return isboard;

    }

    @GetMapping("/board/{bid}")//read content_view
    public IsBoardDto contentView(@PathVariable("bid") Long bid) {

        log.info("contentView");

        boardService.bhit(bid);

        IsBoardDto isBoardDto = boardService.contentView(bid);

        return isBoardDto;

    }

    @GetMapping("/board/edit/{bid}")//read modifyView
    public IsBoardDto modifyView(@PathVariable("bid") Long bid) {

        log.info("modifyView");

        IsBoardDto isBoardDto = boardService.contentView(bid);

        return isBoardDto;

    }

    @PostMapping("/board/write")//create board 
    public void write(@RequestBody IsBoardDto isBoardDto){//@RequestBody return type json

        log.info("write");

        boardService.write(isBoardDto);

    }

    @DeleteMapping("/board/{bid}")//delete board
    public void delete(@PathVariable("bid")Long bid){

        log.info("delete");

        boardService.delete(bid);
        
    }

    @PutMapping("/board/edit/{bid}")//update board
    public void update(@PathVariable("bid")Long bid ,@RequestBody IsBoardDto isBoardDto){

        log.info("update");

        boardService.update(bid , isBoardDto);

    }

    @GetMapping("/board/comments/{bid}")//read replyList
    public List<ReplyDto> replyList(@PathVariable("bid") Long bid) {

        log.info("reply");

        List<ReplyDto> replyDto = boardService.replyList(bid);

        return replyDto;
        
    }

    @PostMapping("/board/comments/{bid}")//create reply
    public void reply(@PathVariable("bid") Long bid, @RequestBody ReplyDto replyDto){

        log.info("reply");

        boardService.reply(replyDto , bid);

    }

    @PutMapping("/board/comments/{bid}")//update reply
    public void replyUpdate(@PathVariable("bid") Long bid, @RequestBody ReplyDto replyDto){

        log.info("replyUpdate");

        boardService.reply(replyDto , bid);

    }

    @DeleteMapping("/board/comments/{rid}")//delete comments
    public void replyDelete(@PathVariable("rid") Long rid){

        log.info("replyDelete");

        boardService.deleteComments(rid);

    }
    
}



   