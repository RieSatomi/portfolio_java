package com.example.demo.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


//新規登録する際のデータを格納するエンティティ

@Data // getter, setter	の自動生成
@Entity
@Table(name = "users")

public class Users {
	@Id
//	@NotBlank(message="user_idを入力してください")
	private int id;
	
	@Column
	@NotBlank(message="パスワードを入力してください")
	@Pattern(regexp="[a-zA-Z0-9]*",message="パスワードは半角英数字で入力してください")
	@Length(min=4,message="パスワードは4文字以上入力してください")
	private String password;
	
	@Column
	@NotBlank(message="xxx@example.comの形式で入力してください")
	private String mail;
	
	@Column
	@NotBlank(message="名前を入力してください")
	private String name;
	
	@Column
	@Range(min=0,max=130,message="年齢は0から130の間で入力してください")
	private int age;
}