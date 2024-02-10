package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //コンストラクタの自動生成
@AllArgsConstructor //全引数に対する初期値を引数にとるコンストラクタを自動生成
// ログイン情報を格納するためのクラス
public class LoginUser {
	private int user_Id; // ログインに使用するuser_id 主キー
	private String pass;
}