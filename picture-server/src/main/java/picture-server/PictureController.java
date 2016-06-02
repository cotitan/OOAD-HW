package src.main.java.tickets;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
// import org.apache.commons.lang.StringUtil;
// import org.hibernate.Session;

@RestController
@RequestMapping("/pictures")
public class PictureController {
    
	@RequestMapping("posters/{category}")
	public void getPosters(@PathVariable("category") String category,
		ServletRequest request,
		ServletResponse response) throws IOException {
		String fileName = "pictures/posters/" + category + ".jpg";

		File file = new File(fileName);           //判断文件是否存在如果不存在就返回默认图标
		
		if(!(file.exists() && file.canRead())) { 
			file = new File("pictures/posters/angry_bird.jpg");
		}
		FileInputStream inputStream = new FileInputStream(file); 
		byte[] data = new byte[(int)file.length()];
		int length = inputStream.read(data);
		inputStream.close();
		response.setContentType("image/jpg");
		OutputStream stream = response.getOutputStream();
		stream.write(data);
		stream.flush();
		stream.close();
	} 

	@RequestMapping("avatars/{category}")
	public void getAvatars(@PathVariable("category") String category,
		ServletRequest request,
		ServletResponse response) throws IOException {
		String fileName = "pictures/avatars/" + category + ".jpg";

		File file = new File(fileName);           //判断文件是否存在如果不存在就返回默认图标
		
		if(!(file.exists() && file.canRead())) { 
			file = new File("pictures/posters/angry_bird.jpg");
		}
		FileInputStream inputStream = new FileInputStream(file); 
		byte[] data = new byte[(int)file.length()];
		int length = inputStream.read(data);
		inputStream.close();
		response.setContentType("image/jpg");
		OutputStream stream = response.getOutputStream();
		stream.write(data);
		stream.flush();
		stream.close();
	} 

}