# spring�¶�̬ע�������һ�ּ򵥵Ľ��˼·

�����У�ʵ������Զ�ע��ķ����в��٣�����ʹ��jdk�Դ��� Service Provider Interface��SPI��Ҳ�ܼ򵥡������ʹ��spring��ܣ����������ṩ����һ��˼·��������spring�����ɨ���ע�Ṧ�ܣ�15�д��벻��ʵ���Զ�ע��������ܡ����һ����Ŀ��ʹ�������ַ�ʽ������ǳ��򵥣�Ŀǰ����û��ʲô�����⡣

# ��������ӿ�

�½�һ����Ŀ������ӿڡ�

```Java
package cn.xiaowenjie;

/**
 * ����ӿ���
 * 
 * @author Ф�Ľ� https://github.com/xwjie/DynamicComponentDemo
 *
 */
public interface IComponent {

  String getName();

  String getDescript();

  int doSomeThing(int i, int j);
}
```

���⣬����Ҫ����spring�����԰�spring�����ŵ���������Ľӿ���Ŀ�У���������ʵ�ֽӿڵ���Ŀ�Ͳ�����Ҫ�����������ˡ�

# ʵ���Լ������

�ǳ��򵥣��½�һ����Ŀ������ӿ���Ŀ��������ʵ�ֽӿڼ��ɡ���Ҫ����������� `@Component` ��


```Java
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
```

# ������

�½�����Ŀ����spring�ҵ�����ʵ���˽ӿڵ�������ɡ���ʵ��2�д��롣��Ҫ�� `required = false` ,����û���κ������ʱ��ᱨ��

```Java
  @Autowired(required = false)
  List<IComponent> components;
```


�������룺


```Java
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
 * ������
 * 
 * @author Ф�Ľ� https://github.com/xwjie/DynamicComponentDemo
 *
 */
@RequestMapping("/comp")
@RestController
public class MainController {

  @Autowired(required = false)
  List<IComponent> components;

  /**
   * �鿴�������
   * 
   * @return
   */
  @GetMapping("/all")
  public ResultBean<List<IComponent>> all() {
    return new ResultBean<List<IComponent>>(components);
  }

  /**
   * ����ִ�н��
   * 
   * @return
   */
  @GetMapping("/exec")
  public ResultBean<List<String>> exec() {
    List<String> outputs = new ArrayList<String>();

    if (components != null) {
      for (IComponent comp : components) {
        outputs.add("�������" + comp.getName() + "��ִ�н����" + comp.doSomeThing(10, 3));
      }
    }

    return new ResultBean<List<String>>(outputs);
  }
}
```

������������ʵ�ֵ������Ŀ��

![](ide1.png)

![](ide2.png)


���Խ����

![](1.png)

![](2.png)

# ָ�������˳��

ʹ�� `@Order` ע�⼴�ɡ�

```Java
@Component
@Order(1)
public class MyComponent2 implements IComponent
```

# �ܽ�

ʹ��spring���Զ�ɨ��ע�ᣬʵ�������ǳ��򵥣����շ�����ʱ��Ҳ�ܷ��㣬������Ĺ��̴��jar���ӽ�ȥ���ɡ�