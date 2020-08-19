package com.spring.boot.landesk.auto.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.boot.landesk.auto.dao.CoreApps;
import com.spring.boot.landesk.auto.main.AddCol;
import com.spring.boot.landesk.auto.main.CsvToXlsx;

@Controller
public class UploadController {

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String homePage() {
		return "upload";
	}

	@RequestMapping(value = { "/upload" }, method = RequestMethod.POST)
	public ModelAndView fileUpload(@RequestParam("files") MultipartFile[] file, RedirectAttributes redirect,
			HttpServletRequest req) {

		ModelAndView mav = null;
		try {
			mav = new ModelAndView();
			mav.setViewName("displayCore");

			byte[] bytes1 = file[0].getBytes();
			Path path1 = Paths.get("D:\\workspace\\" + file[0].getOriginalFilename());
			Files.write(path1, bytes1);

			ArrayList<String> coreAppsList = AddCol.readExcel("D:\\workspace\\" + path1.getFileName());
			List<CoreApps> coreApps = AddCol.setDataToCoreList(coreAppsList);
			System.out.println(coreApps);

			req.getSession().setAttribute("coreApps", coreApps);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}

	@RequestMapping(value = { "/rename" }, method = RequestMethod.POST)
	public ModelAndView renameReport(@RequestParam("files") MultipartFile[] file, RedirectAttributes redirect,
			HttpServletRequest req) {

		ModelAndView mav = null;
		try {
			mav = new ModelAndView();
			mav.setViewName("upload");

//			byte[] bytes1 = file[0].getBytes();
//			Path path1 = Paths.get("D:\\workspace\\" + file[0].getOriginalFilename());
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy");
			LocalDateTime now = LocalDateTime.now();
			String date = dtf.format(now);

			//Hardcode the filename here
			String var = "D:\\workspace\\download(15).xls";
			String path = "D:\\\\workspace\\\\CoreApps_ReportRequests" + date + ".xls";

			
			File oldName = new File(var);
			File newName = new File(path);

			if (oldName.renameTo(newName)) {
				System.out.println("renamed");
			} 
			else {
				System.out.println("Error");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value = { "/convertToExcel" }, method = RequestMethod.POST)
	public ModelAndView convertToExcel(@RequestParam("files") MultipartFile[] file, RedirectAttributes redirect,
			HttpServletRequest req) {

		ModelAndView mav = null;
		try {
			mav = new ModelAndView();
			mav.setViewName("upload");
			
			byte[] bytes1 = file[0].getBytes();
			Path path1 = Paths.get("D:\\workspace\\" + file[0].getOriginalFilename());
			CsvToXlsx.convert(path1);
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return mav;
		}

}
