package com.example.backend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.transaction.Transactional;
import com.example.backend.domain.entity.Issue_boardEntity;
import com.example.backend.domain.entity.ReplyEntity;
import com.example.backend.domain.repository.IsBoardRepository;
import com.example.backend.domain.repository.ReplyRepository;
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
    public  Map<String , Object> boardList(Pageable pageable) {//read boardList

        log.info("transac-read");

        Map<String , Object> hashMap = new HashMap<>();

        Page<Issue_boardEntity> boardPagingList = isBoardRepository.findAll(pageable);

        hashMap.put("list", boardPagingList);

        return hashMap;

}

    @Transactional
    public Map<String , Object> write(Issue_boardEntity issue_board) {//write or update

        log.info("transac-post");
        
        Map<String , Object> postMap = new HashMap<>();

        Issue_boardEntity getPost =isBoardRepository.save(issue_board);
        postMap.put("code", "S");
        postMap.put("data", getPost);

        return postMap;
    }

    @Transactional
    public Map<String , Object> contentView(Long bid) {//read content_view

        log.info("transac-content-read");

        Map<String , Object> ctvMap = new HashMap<>();

            Optional<Issue_boardEntity> isBoardDetail = isBoardRepository.findById(bid);
            isBoardRepository.uphit(bid);

            ctvMap.put("data", isBoardDetail);

         return ctvMap;

    }

    @Transactional
    public Map<String, Object> modifyView(Long bid) {//read modify_view
      
        log.info("transac-modify-read");

        Map<String, Object> mdfMap = new HashMap<>();

        Optional<Issue_boardEntity> isBoardDetailModify = isBoardRepository.findById(bid);

        mdfMap.put("code", "S");
        mdfMap.put("data", isBoardDetailModify);

        return mdfMap;

    }

    @Transactional
    public void delete(Long bid) { //delete board or comments

        log.info("transac-delete");

        replyRepository.deleteBoard_id(bid);//board delete

        isBoardRepository.deleteById(bid);// delete board

    }

  
    public Map<String, Object> replyList(Long bid) {//read replyList

        log.info("transac-replyList");

        Map<String, Object> repMap = new HashMap<>();

       List<ReplyEntity> replyList = replyRepository.findByBoard_id(bid);

        //log.info(replyList);

       repMap.put("newReply", replyList);
       
        return repMap;
    }

    @Transactional
    public Map<String, Object> reply(ReplyEntity replyEntity , Long bid) {//create or update reply

        Map<String , Object> repMap = new HashMap<>();



        log.info("transac-reply");

        replyEntity.setBid(bid);

        ReplyEntity replySave = replyRepository.save(replyEntity);

        repMap.put("data", replySave);

        return repMap;

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
    public Map<String , Object> update(Long bid , Issue_boardEntity issue_boardEntity) {

        log.info("transac-update");

        Map<String, Object> updMap = new HashMap<>();

        issue_boardEntity.setBid(bid);
      
        Issue_boardEntity issue_board = isBoardRepository.save(issue_boardEntity);

        updMap.put("code", "S");

        updMap.put("data", issue_board);

        return updMap;

    }


    // @Transactional
    // public void update(IsBoardDto isBoardDto) {

    //     log.info("transac-modify");

    //     isBoardRepository.save(isBoardDto.toEntity()).getBid();
    // }

  


}
