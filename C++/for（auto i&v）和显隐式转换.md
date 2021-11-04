##### v是一个可遍历的容器或流，比如vector类型，i就用来在遍历过程中获得容器里的每一个元素。

#### for（auto &i：v）

```c++
//i的值改变可以影响v的值改变
string s = "hello";
for (auto &i : s )
i = toupper(i);//改成大写
cout<<s<<endl; 
```



#### for（auto i：v）

```c++
//i的值改变可以影响v的值改变
string s = "hello";
for (auto i : s )
i = toupper(i);//char i 将一个一个地被隐式转换为char的int值改成大写
cout<<s<<endl; //s的值不改变
```

#### int toupper（int i）

```c++
//它实际返回的是一个可被隐式转换为char的int值
```

#### 隐显式转换

1.显式

```c++
(float)123=123.0
```

1.隐式

```c++
1.算术表达式中，短字节向高字节，char->int;int->double
2.赋值表达式中，等号右边表达式的值的类型自动隐式地转换为左边变量的类型，并赋值给它 
3.函数调用时，将实参的值传递给形参，系统首先会自动隐式地把实参的值的类型转换为形参的类型，然后再赋值给形参；
4.函数有返回值时，系统首先会自动隐式地将返回表达式的值的类型转换为函数的返回类型，然后再赋值给调用函数返回。
5.子类父类调用中，也使用子类对象代替父类对象
class A{};
class B: public A
{};//B是子类
void Fun(A& a);
B b;
Fun(b);
6.类对象赋值时候，可以间接一下，不能太直接的
class Test
{
	public:
		Test(int i);
};

Test t1 = 1;//正确，由于强制类型转换，1先被Test构造函数构造成Test对象，然后才被赋值给t1，可能bug！！！
Test t2(1);//正确

解决办法1-explicit关键字
 class Test
{
	public:
		explicit Test(int i);
};
Test t2 = 1;//编译报错
Test t2(2);//编译没问题

解决办法2-间接一下
void fun(Test& t);
fun(1);//这样调用是没有问题的，隐式类型转换会把1转换成Test的对象。
```

3.总结

```c++
隐式类型转换是从小到大的转换。在数据类型上表现是少字节数据类型，转换成多字节数据类型，保证数据的完整性；
在类上表现，从子类转换成父类，保证类对象功能的正常。
```

##### 补充：c++的柯里化？？不学，就是皮好像js自带还有python也自带

柯里化的意思是利用隐式转换达到    “100”+200=300  的目的

https://zhuanlan.zhihu.com/p/46738827