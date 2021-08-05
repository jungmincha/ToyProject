package com.example.backend.bbs;

import java.util.Map;

import com.example.backend.reply.ReplyEntity;
import com.example.backend.reply.ReplyService;

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
public class BoardController {//test3

    private final BoardService boardService;

    private final ReplyService replyService;

    @GetMapping("/board")//read boardList and paging
    public Map<String , Object> boardList(Pageable pageable){
                                        
        log.info("boardList");
        
        return boardService.boardList(pageable);

    }

    @GetMapping("/board/{bid}")//read content_view 리팩토링 완료
    public Map<String , Object> contentView(@PathVariable("bid") Long bid) {
        
        log.info("contentView");

        return boardService.contentView(bid);

    }

    @GetMapping("/board/edit/{bid}")//read modifyView 리팩토링 완료
    public Map<String , Object> modifyView(@PathVariable("bid") Long bid) {

        log.info("modifyView");

        return  boardService.modifyView(bid);

    }

    @PostMapping("/board/write")//create board 리팩토링 완료
    public Map<String , Object> write(@RequestBody Issue_boardEntity issue_boardEntity){//@RequestBody return type json

        log.info("write");

       return boardService.write(issue_boardEntity);

    }

    @DeleteMapping("/board/{bid}")//delete board
    public void delete(@PathVariable("bid")Long bid){

        log.info("delete");

        boardService.delete(bid);
        
    }

    @PutMapping("/board/edit/{bid}")//update board 리팩토링 완료
    public Map<String , Object> update(@PathVariable("bid")Long bid ,@RequestBody Issue_boardEntity issue_boardEntity){

        log.info("update");

        return boardService.update(bid , issue_boardEntity);

    }

    @GetMapping("/board/comments/{bid}")//read replyList 리팩토링 완료
    public Map<String, Object> replyList(@PathVariable("bid") Long bid) {

        log.info("reply");

       // List<ReplyEntity> replyList = new ArrayList<>();

       // boardService.replyList(bid);

        return replyService.replyList(bid);
        
    }

    @PostMapping("/board/comments/{bid}")//create reply 
    public Map<String, Object> reply(@PathVariable("bid") Long bid, @RequestBody ReplyEntity replyEntity){

        log.info("reply");

       return replyService.reply(replyEntity , bid);

    }

    @PutMapping("/board/comments/{bid}")//update reply
    public Map<String, Object>  replyUpdate(@PathVariable("bid") Long bid, @RequestBody ReplyEntity replyEntity){

        log.info("replyUpdate");

      return replyService.reply(replyEntity , bid);

    }

    @DeleteMapping("/board/comments/{rid}")//delete comments
    public void replyDelete(@PathVariable("rid") Long rid){

        log.info("replyDelete");

        replyService.deleteComments(rid);

    }
    
}



   