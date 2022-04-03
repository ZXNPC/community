package com.example.community.dto;

import lombok.Data;

/**
 * 20220330
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
