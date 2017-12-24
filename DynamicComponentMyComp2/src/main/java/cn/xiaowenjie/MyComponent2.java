package cn.xiaowenjie;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 测试组件2
 * 
 * @author 晓风轻 https://github.com/xwjie/DynamicComponentDemo
 *
 */
@Component
@Order(1)
public class MyComponent2 implements IComponent {

	public String getName() {
		return "COMP_SUB";
	}

	public String getDescript() {
		return "返回值相减结果";
	}

	public int doSomeThing(int i, int j) {
		return i - j;
	}

}
