package com.multi.spring2.city.controller;

import com.multi.spring2.city.domain.CityVO;
import com.multi.spring2.city.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {

    //구현부분
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        System.out.println("CityController created");
        this.cityService = cityService;
    }

    @GetMapping
    public String index() {
        return "city/city";
    }

    @PostMapping("/insert")
    public String insert(CityVO cityVO, Model model) {
        System.out.println(cityVO);
        // CityVO 객체를 사용해 새로운 도시 데이터를 추가합니다.
        String result = cityService.insert(cityVO);
        System.out.println("--------->> " + result);
        // 결과를 Model에 추가하여 뷰에 전달
        model.addAttribute("result", result);
        // 결과를 보여줄 뷰 이름을 반환
        return "city/insert_result";
    }

    @GetMapping("/all")
    public ModelAndView all() {
        // 모든 도시 목록을 가져옵니다.
        List<CityVO> all = cityService.all();
        System.out.println("--------->> " + all);
        // ModelAndView 객체에 도시 목록을 추가합니다.
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("all", all);
        modelAndView.setViewName("city/all_result");
        return modelAndView;
    }
}
