package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.MyDataMongoRepository;

@Controller
public class helloController {

	@Autowired
	MyDataMongoRepository repository;
	
	/**	
	 * @brief form 데이터를 몽고 DB로 부터 불러오고 템플릿으로 표현 하는 메소드
	 * 
	 * @author 박종민
	 * @date   2019-06-13 목요일
	 */
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView main(ModelAndView mav) {
		mav.setViewName("main");
		Iterable<MyDataMongo> list = repository.findAll();
		mav.addObject("datalist", list);				
		return mav;
	}
	/**
	 * @brief 이름, 전화번호, 메일, 성별, 금액 입력, 이자율, 대출기간, 월불입금, 원금 및 이자합계, 이자액, 기타사항 데이터를 입력 받는 페이지를 나타내는 메소드
	 */
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public ModelAndView insert(ModelAndView mav) {
		mav.setViewName("insert");
		return mav;
	}
	/**
	 * @brief 템플릿으로부터 입력된 성적데이터를 db에 저장
	 * @param name		사용자 이름
	 * @param first 	전화번호 앞자리	
	 * @param second	전화번호 두번째자리
	 * @param third		전화번호 세번째자리		
	 * @param email		이메일	
	 * @param sex		성별
	 * @param principal	금액 입력
	 * @param interest	이자율
	 * @param years		대출기간
	 * @param payment	월불입금
	 * @param total		원금 및 이자합계
	 * @param totalinterest 이자액
	 * 
	 */
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@Transactional(readOnly=false)
	public ModelAndView insert(
			@RequestParam("name") String name,
			@RequestParam("first") int first,
			@RequestParam("second") int second,
			@RequestParam("third") int third,
			@RequestParam("email") String email,
			@RequestParam("principal") int principal,
			@RequestParam("interest") double interest,
			@RequestParam("years") double years,
			@RequestParam("payment") double payment,
			@RequestParam("total") double total,
			@RequestParam("totalinterest") double totalinterest,
			@RequestParam("textarea") String textarea,
			
			ModelAndView mav) {

		MyDataMongo mydata = new MyDataMongo(name, first, second, third, email, principal, interest, years, payment, total, totalinterest, textarea);	//몽고 db에 데이터 저장을 위해 객체 생성
		repository.save(mydata);	//db에 값 저장
		return new ModelAndView("redirect:/");
	}
}
