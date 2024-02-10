package com.example.demo.entity;

import com.example.demo.model.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data // getter, setter	の自動生成
@Entity
@Table(name = "mutters")
public class Mutter{
	
	@Id
	private int id;
	
	// 外部キー
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private Users user;
	
	
	@Column(name = "name")
	private String name; // ユーザー名
	//入力値が条件外だった際に表示する文字列を「message」に格納する
//	@NotBlank(message="入力してくださいよ！！")
	private String text; // つぶやき内容
	
//	public Mutter() {}
//	public Mutter(String name, String text) {
//		this.name = name;
//		this.text = text;
//	}
	
//	public Mutter(int mutter_Id, String name, String text) {
//		this.mutter_Id = mutter_Id;
//		this.name = name;
//		this.text = text;
//	}
	
//	public int getMutter_Id() {return mutter_Id;}
//	public String getName() {return name;}
//	public String getText() {return text;}
	
}


