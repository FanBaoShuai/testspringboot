package com.fbs.auctionmvc.controller;

import com.fbs.auctionmvc.entity.Auction;
import com.fbs.auctionmvc.entity.Record;
import com.fbs.auctionmvc.entity.User;
import com.fbs.auctionmvc.service.AuctionService;
import com.fbs.auctionmvc.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class AuctionController {
	@Autowired
	private AuctionService auctionService;
	@Autowired
	private RecordService recordService;

	/**
	 * 展示全部拍卖品的方法
	 * 因为要判断是普通用户还是管理员所以根据Session作用域中的user对象的管理员标记来所判断
	 * @param map 要把查询出来的全部的数据展示到jsp界面通过Map集合来存放查询出来的集合在jsp中进行展示
	 * @param auction 因为要用到动态sql查询所以需要传入一个auction对象来充当查询的条件
	 * @param session 用来获得在登陆时放入Session作用域中的user对象从而判断是普通用户还是管理员
	 * @return 展示要用到作用域所以转发到pmspgly.jsp
	 */
	@RequestMapping("/selectAll")
	public String selectAll(Map map,Auction auction,HttpSession session){
		User user = (User)session.getAttribute("user");
		List<Auction> listAuction = auctionService.selectAll(auction);
		System.out.println("======================="+listAuction+"=========================");
		map.put("listAuction", listAuction);
		return "pmspgly";
	}
	/**
	 * 这是添加的方法
	 * 添加的时候因为要上传图片所以要用到文件上传
	 * @param auction 添加的时候要从jsp中获取到添加的信息所以要定义一个对象类型的属性来收jsp传过来的属性值
	 * @param touxiang 这个是jsp页面上的图片的name属性值通过定义的MultipartFile类型的属性值来接受上传过来的图片
	 * @return 重定向到查询全部拍卖品的Controller中
	 */
	@RequestMapping("/add")
	public String add(Auction auction,MultipartFile touxiang,HttpServletRequest request){
		//获取上传上来的文件的名字
		String fileName = touxiang.getOriginalFilename();
		//对上传上来的文件进行重命名
		fileName = new Date().getTime()+"_"+fileName;
		try {
			//把接收到的文件转换为磁盘文件
			//存放的路径有可能不存在所以需要进行try-catch处理
			/*touxiang.transferTo(new File("D:\\apache-tomcat-6.0.29\\webapps\\auctionmvc"+fileName));*/
			String realPath = request.getRealPath("images");
			touxiang.transferTo(new File(realPath+"\\"+fileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//把文件的名字放入的auction对象中用以对auction_pic属性赋值
		auction.setAuction_pic(fileName);
		auctionService.add(auction);
		return "redirect:/selectAll.do";
	}
	/**
	 * 这是修改的方法
	 * @param auction 定义Auction类型的对象变量用来接收jsp中传过来的数据
	 * @param touxiang 定义MultipartFile类型的属性touxiang(属性名要和jsp中的上传文件的name值一样)
	 * @param request
	 * @return 重定向到展示全部的Controller里面
	 */
	@RequestMapping("/update")
	public String update(Auction auction,MultipartFile touxiang,HttpServletRequest request){
		//判断jsp传过来的文件名是否是空字符串
		if(!"".equals(touxiang.getOriginalFilename())){
			String realPath = request.getRealPath("/images");
			//定义一个变量用来利用时间戳来给上传的文件起一个新的名字
			String newFileName = new Date().getTime()+"_"+touxiang.getOriginalFilename();
			//利用MultipartFile的trabsferTo方法来定义文件上传过来后的路径
			try {
				System.out.println(realPath+"*******************");
				touxiang.transferTo(new File(realPath+"/"+newFileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//把新定义的文件的名字赋值给Auction对象的auction_pic属性
			auction.setAuction_pic(newFileName);
		}
		//获取到jsp里面已经修改后的属性
		auctionService.update(auction);
		return "redirect:/selectAll.do";
	}
	@RequestMapping("/delete")
	public String delete(int id){
		auctionService.delete(id);
		return "redirect:/selectAll.do";
	}
	@RequestMapping("/selectOne")
	public String selectOne(Map map,int id){
		Auction auction = auctionService.selectOne(id);
		map.put("auction", auction);
		return "update";
	}

	@RequestMapping("/selectOne1")
	public String selectOne1(Map map,int id){
		Auction auction = auctionService.selectOne(id);
		List<Record> recordList = recordService.selectAll(id);
		map.put("auction", auction);
		map.put("recordList", recordList);
		return "jpy";
	}
}
