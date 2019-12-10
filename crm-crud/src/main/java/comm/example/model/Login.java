package comm.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name = "login")

public class Login {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		int id;
		@Column(name="uname")
		private String uName;
		@Column(name = "upass")
		private String uPass;
}
