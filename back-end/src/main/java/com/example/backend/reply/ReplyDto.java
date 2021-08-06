package com.example.backend.reply;

import java.time.LocalDateTime;
import lombok.Data;


@Data
public class ReplyDto {

    private Long rid;

    private String rname;

    private String rcontent;

    private LocalDateTime rdate;

    private Long bid;//외래키
  
    
}
