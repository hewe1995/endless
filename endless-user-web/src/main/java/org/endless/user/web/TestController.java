package org.endless.user.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class TestController {

	@GetMapping("/test")
	public String getTest(ModelMap map, HttpSession session) {
		String name = "hewe";
		map.put("name", session.getAttribute("test"));
		return "test";
	}

	@GetMapping("/test1")
	public ResponseEntity getTest1() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("dsaf", "dfa");
		map.put("eee", "aaaa");
		return ResponseEntity.ok(map);
	}
}
