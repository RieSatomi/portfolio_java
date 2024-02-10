package com.example.demo.controller;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Mutter;
import com.example.demo.model.FileManagement;
import com.example.demo.model.Users;
import com.example.demo.service.FileManagementService;
import com.example.demo.service.MutterService;
import com.example.demo.service.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	// UsersServiceインターフェースをDI
	@Autowired
	UsersService usersService;
	
	@Autowired
	HttpSession session;
	
    @Autowired
    FileManagementService fileManagementService;
	
    @Autowired
    MutterService mutterService;
    
	@GetMapping("welcome")
	public String welcomeView() {
		System.out.println("g.welcome");
		return "welcome";
	}
	
	@GetMapping("show")
	public String showView() {
//		session.removeAttribute("registerUser");
		session.invalidate(); // セッションスコープに入っているものすべてを削除
		return "index";
	}
	
	@PostMapping("show")
	public String postShowView(@Validated Users user,BindingResult bindingResult, Model model) {
		System.out.println("p.show");
		if(bindingResult.hasErrors()) {
			return "register";
		}
		
		usersService.saveAccount(user);
		return "index";
	}
	
	
	@PostMapping("login")
	public String loginView(@RequestParam("id") int id, @RequestParam("password") String pass, Model model) {
		System.out.println("p.login");
		Users user = usersService.findAccount(id,pass);
		if (user == null) {
			return "index";
		}
		session.setAttribute("user", user);
		model.addAttribute("user", user);
		return "redirect:login";
	}
	
	
	@GetMapping("logout")
	public String logoutView(Model model) {
		System.out.println("g.logout");
		Users user = (Users) session.getAttribute("user");
		
		model.addAttribute("user", user);
		if(user == null) {
			return "redirect:show";
		}
		return "logout";
	}
	
	// 新規登録画面への遷移
	@GetMapping("register")
	public String registerView(Model model) {
		System.out.println("g.register");
		Users usr = new Users();
		model.addAttribute("user", usr);
		return "register";
	}
	
	// プロフィールページを表示する仮パス
	@GetMapping("profile")
	public String profileView() {
		System.out.println("g.profile");
		return "profile";
	}
	
	// コンテンツ画面を表示する仮パス
//	@GetMapping("contents")
//	public String contentsView() {
//		return "contents";
//	}
//	
	// ユーザー登録情報の確認画面　users.html
	@GetMapping("users")
	public String usersView(Model model) {
		System.out.println("g.users");
		Users user = (Users) session.getAttribute("user");
		model.addAttribute("user", user);
		return "users";
	}
	
	
	// 退会画面への遷移とデータの取得
	@GetMapping("remove")
	public String removeView(Model model) {
	System.out.println("g.remove");
	Users removeUser = (Users) session.getAttribute("user");
		model.addAttribute("user", removeUser);
		return "remove";
	}
		
	@GetMapping("removeOK")
	public String removeOKView() {
	System.out.println("g.removeOK");
	Users user = (Users) session.getAttribute("user");
		boolean result = usersService.deleteAccount(user.getId());
		if(result == true) {
			return "removeOK";
		}else {
			return "remove";
		}	
	}
		
	// 退会ページから戻るを押したときに表示されるlogin成功ページへ
	@GetMapping("login")
	public String loginOKView(Model model) {
	System.out.println("g.login");
	Users user = (Users) session.getAttribute("user");
	
	// DBのcontents2を全取得
	List<FileManagement> files = fileManagementService.fileManagementListByUser(user.getId());
	
	// contents２の中の1つめの画像だけを全レコード分取り出してbase64エンコードしたもの
	List<String> base64Images = files.stream()
            .map(img -> Base64.getEncoder().encodeToString(img.getFileData()))
            .collect(Collectors.toList());
		if(user == null) {
			return "redirect:show";
		}
		model.addAttribute("user", user);
		model.addAttribute("files", files);
		model.addAttribute("base64Images", base64Images);
		return "loginOK";
	}
	
	
	

	// コンテンツページにどこつぶ機能を表示
	@GetMapping("contents")
	public String contentsView(@RequestParam(name="id", required = false) Integer id, Model model) {
		System.out.println("g.contents" + id);
		Users user = (Users) session.getAttribute("user");
		List<Mutter> mutterResult = mutterService.findAllMutters();
		
		// GETパラメータでもらったIDを元に、contensテーブルから対象のレコードを取得
		FileManagement data = fileManagementService.getImage(id);
		
		// contentsのデータのうち、base64エンコードが必要な2つのデータを処理
		String image64_01 = Base64.getEncoder().encodeToString(data.getFileData());
		String image64_02 = Base64.getEncoder().encodeToString(data.getFileData2());
		
		model.addAttribute("data", data); // HTMLにデータを渡す
		model.addAttribute("mutter", mutterResult);
		model.addAttribute("user", user);
		model.addAttribute("image64_01", image64_01);
		model.addAttribute("image64_02", image64_02);
		
		return "contents";
	}
	
	// どこつぶ画面でつぶやくメソッド、投稿ボタンを押したときにつぶやきを再取得して表示する。リストを再取得している
	@PostMapping("contents")
	public String dokotubuPost(Model model, @RequestParam  String text, FileManagement fileManagement, @RequestParam(name="id", required = false) Integer id) {
		System.out.println(text);
		Users user = (Users)session.getAttribute("user");
		List<Mutter> mutterResult = mutterService.findAllMutters();
//		model.addAttribute("mutter", mutterResult);
		int i = 0;
		if(mutterResult != null) {
			for(Mutter mutter : mutterResult) {
				i = mutter.getId()+1;
			}
		}
		System.out.println(user);
		Mutter mutter = new Mutter();
		mutter.setName(user.getName());
		mutter.setText(text);
		mutter.setUser(user);
		mutter.setId(i);
		mutterService.saveMutter(mutter);
		
//		List<Mutter> mutters = mutterService.findAllMutters(); // リストを再取得
//		mutterResult = mutterService.findAllMutters();
//		nextval('mutters_mutter_id_seq'::regclass)
		
//		model.addAttribute("user", user);
//		model.addAttribute("mutter", mutterResult);
//		model.addAttribute("mutter", mutters); // 再取得したリストをmodelに格納
		
		
		return "redirect:contents?id=" + id;
		
//		if(mutterResult == true) {
//			return "contents";
//		}else {
//			return "redirect:show";
//			
//		}
	}
}