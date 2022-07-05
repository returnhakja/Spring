package step06.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.ToString;



@Data
@Entity
@ToString(exclude = {"products"})
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;
	
	@Column(length = 20)
	private String name;
	
	private Integer age;

//	@OneToMany(mappedBy = "member")
	@OneToMany(mappedBy = "member", cascade = {CascadeType.REMOVE})
	private List<Order> memberproducts = new ArrayList<Order>();
	
	
	
	
}
