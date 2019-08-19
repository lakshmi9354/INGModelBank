package com.ing.modelbank.Response;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString @NoArgsConstructor
public class PayeeResponse {
private int statusCode;
private String message;
private String statusMessage;
}
