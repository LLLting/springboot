package com.how2java.springboot.web;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.springboot.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.how2java.springboot.dao.CategoryDAO;
import com.how2java.springboot.pojo.Category;

import java.util.List;

@Controller
public class CategoryController {
//	@Autowired CategoryDAO categoryDAO;

	@Autowired
	private CategoryMapper categoryMapper;
	
//    @RequestMapping("/listCategory")
//    public String listCategory(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
//    	start = start<0?0:start;
//
//    	Sort sort = new Sort(Sort.Direction.ASC, "id");
//    	Pageable pageable = new PageRequest(start, size, sort);
//    	Page<Category> page =categoryDAO.findAll(pageable);
//
//
//    	System.out.println(page.getNumber());
//    	System.out.println(page.getNumberOfElements());
//    	System.out.println(page.getSize());
//    	System.out.println(page.getTotalElements());
//    	System.out.println(page.getTotalPages());
//
//    	m.addAttribute("page", page);
//
//        return "listCategory";
//    }

    @RequestMapping("/addCategory")
    public String listCategory(Category c){
    	categoryMapper.save(c);
    	return "redirect:listCategory";
	}

	@RequestMapping("/deleteCategory")
	public String deleteCategory(Category c){
    	categoryMapper.delete(c.getId());
    	return "redirect:listCategory";
	}

	@RequestMapping("/updateCategory")
	public String updateCategory(Category c){
    	categoryMapper.update(c);
		return "redirect:listCategory";
	}

	@RequestMapping("/editCategory")
	public String listCategory(int id,Model m){
    	Category c = categoryMapper.get(id);
    	m.addAttribute("c",c);
    	return "editCategory";
	}

	@RequestMapping("/listCategory")
	public String listCategory(Model m,@RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue = "5")int size){
		PageHelper.startPage(start,size,"id asc");
		List<Category> cs = categoryMapper.findAll();
		PageInfo<Category> page = new PageInfo<>(cs);
		m.addAttribute("page",page);
		return "listCategory";
	}





//	@RequestMapping("/addCategory")
//    public String addCategory(Category c) throws Exception {
//    	categoryDAO.save(c);
//    	return "redirect:listCategory";
//    }
//    @RequestMapping("/deleteCategory")
//    public String deleteCategory(Category c) throws Exception {
//    	categoryDAO.delete(c);
//    	return "redirect:listCategory";
//    }
//    @RequestMapping("/updateCategory")
//    public String updateCategory(Category c) throws Exception {
//    	categoryDAO.save(c);
//    	return "redirect:listCategory";
//    }
//    @RequestMapping("/editCategory")
//    public String ediitCategory(int id,Model m) throws Exception {
//    	Category c= categoryDAO.getOne(id);
//    	m.addAttribute("c", c);
//    	return "editCategory";
//    }


}

