package com.example.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import com.example.backend.domain.entity.Issue_board;
import com.example.backend.domain.entity.Reply;
import com.example.backend.domain.repository.IsBoardRepository;
import com.example.backend.domain.repository.ReplyRepository;
import com.example.backend.dto.IsBoardDto;
import com.example.backend.dto.ReplyDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class BoardService {

    private final IsBoardRepository isBoardRepository;

    private final ReplyRepository replyRepository;

    @Transactional
    public Page<Issue_board> boardList(Pageable pageable) {//read boardList

        log.info("transac-read");

        Page<Issue_board> boardPagingList = isBoardRepository.findAll(pageable);

        return boardPagingList;

}

    @Transactional
    public void write(IsBoardDto isBoardDto) {//write or update

        log.info("transac-post");
        
        isBoardRepository.save(isBoardDto.toEntity()).getBid();
    }

    @Transactional
    public IsBoardDto contentView(Long bid) {//read content_view

        log.info("transac-content-read");

        Optional<Issue_board> issue_boardWrapper = isBoardRepository.findById(bid);

        Issue_board issue_board = issue_boardWrapper.get();

        IsBoardDto isBoardDto = IsBoardDto.builder()
                         .bid(issue_board.getBid())
                         .btitle(issue_board.getBtitle())
                         .bname(issue_board.getBname())
                         .bcontent(issue_board.getBcontent())
                         .bdate(issue_board.getBdate())
                         .bhit(issue_board.getBhit())
                         .build();

                     return isBoardDto;

    }

    @Transactional
    public IsBoardDto modifyView(Long bid) {//read modify_view
      
        log.info("transac-modify-read");

        Optional<Issue_board> issue_boardWrapper = isBoardRepository.findById(bid);

        Issue_board issue_board = issue_boardWrapper.get();

        IsBoardDto isBoardDto = IsBoardDto.builder()
                         .bid(issue_board.getBid())
                         .btitle(issue_board.getBtitle())
                         .bname(issue_board.getBname())
                         .bcontent(issue_board.getBcontent())
                         .bdate(issue_board.getBdate())
                         .bhit(issue_board.getBhit())
                         .build();

                     return isBoardDto;

    }

    @Transactional
    public void delete(Long bid) { //delete board or comments

        log.info("transac-delete");

        replyRepository.deleteBoard_id(bid);//board delete

        isBoardRepository.deleteById(bid);// delete board

    }

    @Transactional
    public List<ReplyDto> replyList(Long bid) {//read replyList

        log.info("transac-replyList");

        List<Reply> boards = replyRepository.findByBoard_id(bid);
        List<ReplyDto> replyDtoList = new ArrayList<>();        

        for(Reply reply : boards){
            ReplyDto boardDto = ReplyDto.builder()
                            .rid(reply.getRid())
                            .rcontent(reply.getRcontent())
                            .rname(reply.getRname())
                            .rdate(reply.getRdate())
                            .bid(reply.getBid())
                            .build();
                            replyDtoList.add(boardDto);

        }

        return replyDtoList;
    }

    @Transactional
    public void reply(ReplyDto replyDto , Long bid) {//create or update reply

        log.info("transac-reply");

        replyDto.setBid(bid);

        replyRepository.save(replyDto.toEntity());

    }

    @Transactional
    public void deleteComments(Long rid) {//delete comments

        log.info("transac-deleteComments");

        replyRepository.deleteById(rid);

    }

    @Transactional
    public void bhit(Long bid) {// up hit

        log.info("transac-uphit");

        isBoardRepository.uphit(bid);
    }

    @Transactional
    public void update(Long bid , IsBoardDto isBoardDto) {

        log.info("transac-update");

        isBoardDto.setBid(bid);
      
        isBoardRepository.save(isBoardDto.toEntity());

    }


    // @Transactional
    // public void update(IsBoardDto isBoardDto) {

    //     log.info("transac-modify");

    //     isBoardRepository.save(isBoardDto.toEntity()).getBid();
    // }

  


}
