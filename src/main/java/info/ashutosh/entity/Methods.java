package info.ashutosh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "methods")
public class Methods {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "method_id", nullable = false)
	private Long methodId;

	@Column(name = "nethod_name", nullable = false)
	@Enumerated(EnumType.STRING)
	private Method methodName;

	@Column(name = "method_code", nullable = false)
	private int methodCode;

	public Methods(Method methodName, Method methodCode) {
		super();
		this.methodName = methodName;
		this.methodCode = methodCode.methodValue;
	}

}
