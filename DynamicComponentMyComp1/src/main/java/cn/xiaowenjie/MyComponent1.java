package cn.xiaowenjie;

import org.springframework.stereotype.Component;

/**
 * 测试组件1
 * 
 * @author 晓风轻 https://github.com/xwjie/DynamicComponentDemo
 *
 */
@Component
public class MyComponent1 implements IComponent {

	public String getName() {
		return "COMP_ADD";
	}

	public String getDescript() {
		return "返回值相加结果";
	}

	public int doSomeThing(int i, int j) {
		return i + j;
	}

}
