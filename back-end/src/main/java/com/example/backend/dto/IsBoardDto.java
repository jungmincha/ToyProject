package com.example.backend.dto;

import java.time.LocalDateTime;

import com.example.backend.domain.entity.Issue_board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString @NoArgsConstructor
public class IsBoardDto {

    private Long bid;
    private String btitle;
    private String bname;
    private String bcontent;
    private LocalDateTime bdate;
    private int bhit;
    
public Issue_board toEntity(){
    
    Issue_board build = Issue_board.builder()
                    .bid(bid)
                    .bcontent(bcontent)
                    .bname(bname)
                    .btitle(btitle)
                    .build();
                    
           return build;

}

@Builder
public IsBoardDto(Long bid, String btitle, String bname, String bcontent, LocalDateTime bdate, int bhit) {
    this.bid = bid;
    this.btitle = btitle;
    this.bname = bname;
    this.bcontent = bcontent;
    this.bdate = bdate;
    this.bhit = bhit;
    
    }

}