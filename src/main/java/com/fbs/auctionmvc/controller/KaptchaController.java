package com.fbs.auctionmvc.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author FanBS
 * 验证码的Controller
 * 1.添加kaptcha的jar包
 * 2.在controller创建一个kaptcha成员变量
 * 3.通过kaptcha对象提供的方法：生成文本、生成图片
 * 4.把文本内容存在session中
 * 5.把生成的图片以流的方式响应给客户端
 */
@Controller
public class KaptchaController {
	@Autowired
	//定义一个Producer类型的属性用来调用这个对象属性的方法来生成文本内容、生成图片
	private Producer producer;

	@RequestMapping("/Kaptcha")
	public void getKaptcha(HttpSession session,HttpServletResponse response){
		//利用声明的Producer类型的属性调用createTest()来生成文本内容
		String text = producer.createText();
		//把生成的文本内容存放到session作用域中
		session.setAttribute("kaptcha", text);
		//利用声明的Producer类型的属性调用cteateImage()来生成图片
		//即把生成的文本内容放在一张图片中
		BufferedImage image = producer.createImage(text);
		try {
			//通过图片工具类，把图片写入到响应输出流
			ImageIO.write(image, "jpg", response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
