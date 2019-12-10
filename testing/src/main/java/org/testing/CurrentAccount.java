package org.testing;
import java.util.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "CURRENT_ACCOUNT")
@PrimaryKeyJoinColumn(name = "ID")
public class CurrentAccount extends Account{
	private int intrest;
	
	public CurrentAccount( String name, String No, int in) {
		super(name,No);
		this.intrest = in;
		
	}
}
