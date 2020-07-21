package org.launchcode.skillstracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class SkillsTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkillsTrackerApplication.class, args);
	}

}

@Controller
public class SkillsController {

	@GetMapping
	@ResponseBody
	public String skillsTracker(){
		String html =
				"<html>" +
						"<body>" +
						"<h1>Skills Tracker</h1>" +
						"<h2>Skills to learn</h2>" +
						"<ol>" +
						"<li>Java</li>" +
						"<li>Javascript</li>" +
						"<li>Typescript</li>" +
						"</ol>" +
						"</body>" +
						"</html>";
		return html;
	}

	@GetMapping("form")
	@ResponseBody
	public String skillsTrackerForm(){
		String html =
				"<html>" +
						"<body>" +
						"<h1>Skills Tracker</h1>" +
						"<h2>Skills to learn</h2>" +
						"<form method = 'post' action = '/success'>" +
						"<label>Enter your name: <input type = 'text' name = 'username' /></label><hr>" +
						"<label>Choose a skill:"
						+ "<select name='firstSkill'>"
						+  "<option value='Java'>Java</option>"
						+  "<option value='Javascript'>Javascript</option>"
						+  "<option value='Typescript'>Typescript</option>"
						+ "</select></label><br>" +
						"<label>Choose a skill:"
						+ "<select name='secondSkill'>"
						+  "<option value='Java'>Java</option>"
						+  "<option value='Javascript'>Javascript</option>"
						+  "<option value='Typescript'>Typescript</option>"
						+ "</select></label><br>" +
						"<label>Choose a skill:"
						+ "<select name='thirdSkill'>"
						+  "<option value='Java'>Java</option>"
						+  "<option value='Javascript'>Javascript</option>"
						+  "<option value='Typescript'>Typescript</option>"
						+ "</select></label><br>" +
						"<input type = 'submit' value = 'Show me the skills!' />" +
						"</form>" +
						"</body>" +
						"</html>";
		return html;
	}

	@PostMapping("success")
	@ResponseBody
	public String skillsTrackerSuccess(
			@RequestParam String username,
			@RequestParam String firstSkill,
			@RequestParam String secondSkill,
			@RequestParam String thirdSkill){
		String html =
				"<html>" +
						"<body>" +
						"<h1>Skills Tracker for " + username + "</h1>" +
						"<h2>Skills to learn</h2>" +
						"<ol>" +
						"<li>" + firstSkill + "</li>" +
						"<li>" + secondSkill + "</li>" +
						"<li>" + thirdSkill + "</li>" +
						"</ol>" +
						"</body>" +
						"</html>";
		return html;
	}

}
