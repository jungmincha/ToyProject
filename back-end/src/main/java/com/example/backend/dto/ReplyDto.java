package com.example.backend.dto;

import java.time.LocalDateTime;
import com.example.backend.domain.entity.Reply;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString @NoArgsConstructor
public class ReplyDto {

    private Long rid;
    private String rname;
    private String rcontent;
    private LocalDateTime rdate;
    private Long bid;//외래키
  
    public Reply toEntity(){

        Reply build = Reply.builder()
                    .rid(rid)
                    .rcontent(rcontent)
                    .rname(rname)
                    .bid(bid)
                    .build();

              return build;

    }

    @Builder
    public ReplyDto(Long rid, String rname, String rcontent, LocalDateTime rdate , Long bid) {
        this.rid = rid;
        this.rname = rname;
        this.rcontent = rcontent;
        this.rdate = rdate;
        this.bid = bid;
    
    }   
    
}
