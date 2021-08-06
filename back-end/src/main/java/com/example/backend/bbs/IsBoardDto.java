package com.example.backend.bbs;

import java.time.LocalDateTime;
import lombok.Data;


@Data
public class IsBoardDto {

    private Long bid;

    private String btitle;

    private String bname;

    private String bcontent;

    private LocalDateTime bdate;

    private int bhit;
    

    
}