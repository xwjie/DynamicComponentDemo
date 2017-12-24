package cn.xiaowenjie.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.xiaowenjie.IComponent;
import cn.xiaowenjie.beans.ResultBean;

/**
 * 测试类
 * 
 * @author 肖文杰 https://github.com/xwjie/DynamicComponentDemo
 *
 */
@RequestMapping("/comp")
@RestController
public class MainController {

	@Autowired(required = false)
	List<IComponent> components;

	/**
	 * 查看所有组件
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public ResultBean<List<IComponent>> all() {
		return new ResultBean<List<IComponent>>(components);
	}

	/**
	 * 测试执行结果
	 * 
	 * @return
	 */
	@GetMapping("/exec")
	public ResultBean<List<String>> exec() {
		List<String> outputs = new ArrayList<String>();

		if (components != null) {
			for (IComponent comp : components) {
				outputs.add("组件名：" + comp.getName() + "，执行结果：" + comp.doSomeThing(10, 3));
			}
		}

		return new ResultBean<List<String>>(outputs);
	}
}
