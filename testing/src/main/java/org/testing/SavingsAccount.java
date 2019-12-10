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
@Table(name="SAVINGS_ACCOUNT")   
@PrimaryKeyJoinColumn(name = "ID")
public class SavingsAccount extends Account{
	private int minimumbalance;
	
	public SavingsAccount( String name, String No, int min) {
		super(name,No);
		this.minimumbalance = min;
		
	}
}
