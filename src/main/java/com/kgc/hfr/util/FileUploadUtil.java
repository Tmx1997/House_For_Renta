package com.kgc.hfr.util;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileUploadUtil {

	public static Map<String, Object> fileUploadUtil(MultipartRequest request, String fileName, String targetPage) {
		Map<String, Object> map = new HashMap<>();
		List<String> pathList = new ArrayList<>();
		List<MultipartFile> multipartFileList = request.getFiles(fileName);
		try {
			for (int i = 0; multipartFileList != null && i < multipartFileList.size(); i++) {
				MultipartFile multipartFile = multipartFileList.get(i);
				//获取图片的名称   part  D:imgsa.jsp   q.qwe.qwe.qwe.12.asd.asd.as.jsp
				String originalFilename = multipartFile.getOriginalFilename();
				//获取文件类型
				String lastPath = originalFilename.substring(originalFilename.lastIndexOf("."));
				//uuid
				String uuidPath = UUID.randomUUID().toString();
				//获取日期包
				String datePath = new SimpleDateFormat("yyyy\\MM\\dd\\HH\\mm\\ss").format(new Date());
				//完成路径
				File file = new File(targetPage, datePath);
				//判断文件夹是否存在
				if (!file.exists()) {
					file.mkdirs();
				}
				String endPath = targetPage + datePath + "\\" + uuidPath + lastPath;
				//上传文件
				File f=new File(endPath);
				multipartFile.transferTo(f);
				//  去掉路径的 D:/
				pathList.add(endPath.substring(endPath.indexOf(":") + 2));
			}

			map.put("pathList", pathList);
			map.put("status", 1);
			return map;
		} catch (IOException e) {
			e.printStackTrace();
			map.put("status", 0);
			return map;
		}
	}

	public static Map<String, Object> fileUpLoad(String targetPath, CommonsMultipartFile picture) {
		Map<String,Object>map=new HashMap<>();
		//文件名
		String fname = picture.getOriginalFilename();
		//后缀
		String lastPath = fname.substring(fname.lastIndexOf("."));
		String uuidPath = UUID.randomUUID().toString();
		//获取日期包
		String datePath = new SimpleDateFormat("yyyy\\MM\\dd\\HH\\mm\\ss").format(new Date());
		//完成路径
		File file = new File(targetPath, datePath);
		//判断文件夹是否存在
		if (!file.exists()) {
			file.mkdirs();
		}
		String savePath = datePath + "\\" + uuidPath + lastPath;
		String endPath = targetPath + savePath;
		File f=new File(endPath);
		try {
			picture.transferTo(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		map.put("savePath",savePath );
		map.put("file",f);
		return map;

	}
}

