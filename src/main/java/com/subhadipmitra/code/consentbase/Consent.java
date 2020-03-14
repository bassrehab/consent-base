package com.subhadipmitra.code.consentbase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consent {
    private String instanceId;
    private String customerTokenizedId;
    private String customerType; //ETB, Anonymous
    private String consentTime;
    private String nistBeacon;
    private String channel;
    private String validityFromDate;
    private String validityToDate;
    private String scope; //Analytics, Marketing, Re-targetting
    private String meta;
}