package com.iba.library.dto.req.emailsender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class SimpleMailReq {

    private String recipient;

    private String subject;

    private String mailBody;

}
