package com.ing.modelbank.entity;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter @Setter @ToString @NoArgsConstructor
public class Payee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

private int	payeeId;
	private String payeeName;
	private int payeeAccountNumber;
	private int payeeMobileNo;
private String	payeeEmailId;
	private String payeeAccountType;
	private Date date;
	private int accountId;
}
