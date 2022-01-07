package com.traveler.server.model.dto;

import lombok.Data;

@Data
public class InfoCentParam {
    private String enterpriseSign;
    private String charset;
    private String signType;
    private String timestamp;
    private String nonce;
    private String version;
    private String sign;
    private String bizContent;
}
