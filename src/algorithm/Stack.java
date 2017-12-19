package algorithm;

/**
 * Created by baymux on 2017/12/19.
 *
 * @author baymux
 **/
public class Stack {
}

/**
 * 准备栈数据
 * @author baymux
 */
class StackData{
    String name;
    int age;
}


/**
 * 栈数据类型
 * @author baymux
 */
class StackType{
    static final int MAXLEN = 50;
    /**
     * 数据元素
     */
    StackData[] stackData = new StackData[MAXLEN+1];
    /**
     * 栈顶
     */
    int top;
}