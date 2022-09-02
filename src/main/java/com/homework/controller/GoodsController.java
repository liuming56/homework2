package com.homework.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.homework.pojo.Goods;
import com.homework.service.BrandService;
import com.homework.service.ClassifyService;
import com.homework.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoodsController {
    @Autowired
    private GoodsService gs;
    @Autowired
    private ClassifyService cs;
    @Autowired
    private BrandService bs;
    @GetMapping("/find")
    public String findGoods(Model model, @RequestParam(value = "cid", defaultValue = "0") int cid, String bname, String keyword, String ordclu, Integer order, Integer pno){
//        int id1 = cid != null ? cid : 0;
        int ord = order != null ? order : 0;
        IPage<Goods> page = gs.getGoods(cid, bname, keyword, pno, ordclu, ord);
//        page.getRecords().forEach(System.out::println);
        model.addAttribute("info", page);
        model.addAttribute("classes", cs.getClassifies());
        model.addAttribute("brands", bs.getBrands(cid));
        return "goods";
    }
}
