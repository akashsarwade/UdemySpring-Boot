package com.upload.file.s3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ch.qos.logback.core.model.Model;

@Controller
public class MainController {

	@GetMapping("")
	public String viewHomePage() {
		return "upload";

	}

	@PostMapping("/upload")
	public String handleUploadForm(org.springframework.ui.Model model, String description,
			@RequestParam("file") MultipartFile multipart) {
		String fileName = multipart.getOriginalFilename();

		System.out.println("Description: " + description);
		System.out.println("filename: " + fileName);

		String message = "";

		try {
			S3Util.uploadFile(fileName, multipart.getInputStream());
			message = "Your file has been uploaded successfully!";
		} catch (Exception ex) {
			message = "Error uploading file: " + ex.getMessage();
		}

		model.addAttribute("message", message);

		return "message";
	}
}
