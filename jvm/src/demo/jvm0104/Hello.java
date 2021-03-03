package demo.jvm0104;

/**
 * 自己写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和 for，然后自己分析一下对应的字节码
 * @author zhoujian
 * @date 22:15 2021/2/13
 **/
public class Hello {

    public static void main(String[] args) {
        int index = 1;
        int count = 0;
        for (; index < 5; index ++){
            if (index % 2 == 0){
                count *= index;
            }else {
                count += index;
            }
        }
        System.out.println("at last, count is " + count);
    }
}