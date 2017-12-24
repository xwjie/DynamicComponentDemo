package cn.xiaowenjie;

import org.springframework.stereotype.Component;

/**
 * �������1
 * 
 * @author ������ https://github.com/xwjie/DynamicComponentDemo
 *
 */
@Component
public class MyComponent1 implements IComponent {

	public String getName() {
		return "COMP_ADD";
	}

	public String getDescript() {
		return "����ֵ��ӽ��";
	}

	public int doSomeThing(int i, int j) {
		return i + j;
	}

}
