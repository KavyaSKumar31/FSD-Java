package comm.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import org.hibernate.annotations.Immutable;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="customer")
@Immutable
public class Customer {
	@Id
	@Column(name="auto_id")
	private int auto_id;
	@NotNull
	private String type=null;
	@NotNull
	@Max(value=9000)
	private int id=-1;
	@NotNull
	private String name=null;
	public Customer(String name, int id,String type) {
		this.id = id;
		this.name = name;
		this.type= type;
	}
	

}

