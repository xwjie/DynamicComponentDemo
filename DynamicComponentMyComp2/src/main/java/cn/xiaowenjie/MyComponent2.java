package cn.xiaowenjie;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * �������2
 * 
 * @author ������ https://github.com/xwjie/DynamicComponentDemo
 *
 */
@Component
@Order(1)
public class MyComponent2 implements IComponent {

	public String getName() {
		return "COMP_SUB";
	}

	public String getDescript() {
		return "����ֵ������";
	}

	public int doSomeThing(int i, int j) {
		return i - j;
	}

}
