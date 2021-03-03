# Week_01 学习笔记

## 第一题

自己写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和 for，然后自己分析一下对应的字节码，有问题群里讨论。

```text
执行命令：命令执行路径：E:\Download\Git\JAVA-000\Week_01，即在 Week_01 目录下

编译：javac -d . -encoding UTF-8 Hello.java （指定编码方式为UTF-8，并输出到当前目录）

执行：java com\geek\Hello.class

反编译：javap -c -verbose com.geek.Hello
```

### 源码

```java
package com.geek;

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
```

### 字节码

```java
Classfile /E:/Download/Git/JAVA-000/Week_01/com/geek/Hello.class
Last modified 2021-2-14; size 726 bytes
        MD5 checksum 39637821d5911ced3dc95e53aba6be40
        Compiled from "Hello.java"
public class com.geek.Hello
        minor version: 0
        major version: 52
        flags: ACC_PUBLIC, ACC_SUPER
        Constant pool:
        #1 = Methodref          #11.#21        // java/lang/Object."<init>":()V
        #2 = Fieldref           #22.#23        // java/lang/System.out:Ljava/io/PrintStream;
        #3 = Class              #24            // java/lang/StringBuilder
        #4 = Methodref          #3.#21         // java/lang/StringBuilder."<init>":()V
        #5 = String             #25            // at last, count is
        #6 = Methodref          #3.#26         // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        #7 = Methodref          #3.#27         // java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        #8 = Methodref          #3.#28         // java/lang/StringBuilder.toString:()Ljava/lang/String;
        #9 = Methodref          #29.#30        // java/io/PrintStream.println:(Ljava/lang/String;)V
        #10 = Class              #31            // com/geek/Hello
        #11 = Class              #32            // java/lang/Object
        #12 = Utf8               <init>
  #13 = Utf8               ()V
          #14 = Utf8               Code
          #15 = Utf8               LineNumberTable
          #16 = Utf8               main
          #17 = Utf8               ([Ljava/lang/String;)V
          #18 = Utf8               StackMapTable
          #19 = Utf8               SourceFile
          #20 = Utf8               Hello.java
          #21 = NameAndType        #12:#13        // "<init>":()V
          #22 = Class              #33            // java/lang/System
          #23 = NameAndType        #34:#35        // out:Ljava/io/PrintStream;
          #24 = Utf8               java/lang/StringBuilder
          #25 = Utf8               at last, count is
          #26 = NameAndType        #36:#37        // append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
          #27 = NameAndType        #36:#38        // append:(I)Ljava/lang/StringBuilder;
          #28 = NameAndType        #39:#40        // toString:()Ljava/lang/String;
          #29 = Class              #41            // java/io/PrintStream
          #30 = NameAndType        #42:#43        // println:(Ljava/lang/String;)V
          #31 = Utf8               com/geek/Hello
          #32 = Utf8               java/lang/Object
          #33 = Utf8               java/lang/System
          #34 = Utf8               out
          #35 = Utf8               Ljava/io/PrintStream;
          #36 = Utf8               append
          #37 = Utf8               (Ljava/lang/String;)Ljava/lang/StringBuilder;
          #38 = Utf8               (I)Ljava/lang/StringBuilder;
          #39 = Utf8               toString
          #40 = Utf8               ()Ljava/lang/String;
          #41 = Utf8               java/io/PrintStream
          #42 = Utf8               println
          #43 = Utf8               (Ljava/lang/String;)V
          {
public com.geek.Hello();
        descriptor: ()V
        flags: ACC_PUBLIC
        Code:
        stack=1, locals=1, args_size=1
        0: aload_0
        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
        4: return
        LineNumberTable:
        line 8: 0

public static void main(java.lang.String[]);
        descriptor: ([Ljava/lang/String;)V
        flags: ACC_PUBLIC, ACC_STATIC
        Code:
        stack=3, locals=3, args_size=1
        0: iconst_1
        1: istore_1
        2: iconst_0
        3: istore_2
        4: iload_1
        5: iconst_5
        6: if_icmpge     32
        9: iload_1
        10: iconst_2
        11: irem
        12: ifne          22
        15: iload_2
        16: iload_1
        17: imul
        18: istore_2
        19: goto          26
        22: iload_2
        23: iload_1
        24: iadd
        25: istore_2
        26: iinc          1, 1
        29: goto          4
        32: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
        35: new           #3                  // class java/lang/StringBuilder
        38: dup
        39: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
        42: ldc           #5                  // String at last, count is
        44: invokevirtual #6                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        47: iload_2
        48: invokevirtual #7                  // Method java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        51: invokevirtual #8                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        54: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        57: return
        LineNumberTable:
        line 11: 0
        line 12: 2
        line 13: 4
        line 14: 9
        line 15: 15
        line 17: 22
        line 13: 26
        line 20: 32
        line 21: 57
        StackMapTable: number_of_entries = 4
        frame_type = 253 /* append */
        offset_delta = 4
        locals = [ int, int ]
        frame_type = 17 /* same */
        frame_type = 3 /* same */
        frame_type = 5 /* same */
        }
        SourceFile: "Hello.java"
```

字节码含义说明：

- iconst_1: （如：int num = 1;）

  - i: int类型值 
  - const: 常量值
  - 1: 表示该常量的实际数值
    
- istore_1: 
  - i: int类型值
  - store: 栈操作，将数据从操作数栈写回本地变量表
  - 1: 对应本地变量表中的 slot 值
    
- bipush 5:
  - bipush: 指令的作用是将**单字节的整型常量值**（-128～127）推入
    操作数栈顶，跟随有一个参数，指明推送的常量
  - 5: bipush指令跟随的参数，此处为5
    
- if_icmpge 32
  - if: if，判断语句
  - cmp: 比较
  - great，比较大小，一个值是否大于或等于另外一个值
  - 32: 指令标号，表示如果满足 if 条件，则跳转到标号为32的指令继续执行
  
- irem:
  - i: int类型值
  - rem: 求余指令
    
- ifne:
  - 当栈顶int类型数值不等于0时跳转

- imul:
  - i: int类型值
  - rem: 乘法指令

- goto 26:
  - 无条件跳转指令
  - 26: 指令标号，表示跳转到索引为26的指令继续执行

- iadd:
  - i: int类型值
  - add: 加法指令

- iinc:
  - i: int类型值
  - inc: 自增指令

- getstatic #2:
  - 访问类字段（static字段，或者称为类变量）的指令
  - **#2**：接收的操作数，是为指向常量池的索引
  
- new #3:
  - 创建类实例的指令,它接收一个操作数，为指向常量池的索引，表示要创建的类型，执行完成后，将对象的引用压入栈
  - **#3**：接收的操作数，是为指向常量池的索引
  
- dup:
  - 是将栈顶数值复制一份并送入至栈顶,因为**invokespecial**会消耗掉一个当前类的引用，因而需要复制一份
  
- invokespecial #4:
  - 方法调用指令
  - 用于调用一些需要特殊处理的实例方法，包括实例初始化方法（构造器）、私有方法和父类方法。这些方法都是**静态类型绑定**的，不会在调用时进行动态派发
  - **#3**：接收的操作数，是为指向常量池的索引

- ldc #5:
  - 常量入栈指令，将常量压入操作数栈
  - 该指令可以接收一个8位的参数，该参数指向常量池中的int、float或者String的索引，将指定的内容压入堆栈
  - **#5**，接收的操作数，是为指向常量池的索引
  
### 参考资料

- [JVM字节码指令集概述](https://segmentfault.com/a/1190000037628881)
- 深入理解Java虚拟机

## 第二题

自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。