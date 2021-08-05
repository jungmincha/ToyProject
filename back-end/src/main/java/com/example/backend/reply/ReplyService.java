package com.example.backend.reply;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.transaction.Transactional;

import com.example.backend.bbs.IsBoardRepository;
import com.example.backend.reply.ReplyEntity;
import com.example.backend.reply.ReplyRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;

    
  
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

}
