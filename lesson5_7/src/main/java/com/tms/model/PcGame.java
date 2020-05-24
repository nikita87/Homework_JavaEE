package com.tms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PcGame {

    private Integer id;
    private String title;
    private String genre;
    private String publisher;

}
