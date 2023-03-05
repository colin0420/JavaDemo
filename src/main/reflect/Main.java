package src.main.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 根据class 对象创建一个实例
        Class<?> clazz = Class.forName("src.main.reflect.TargetObject");
        TargetObject targetObject = (TargetObject) clazz.newInstance();

        // 获取取所有public方法
        Method[] methods = clazz.getMethods();
        System.out.println(Arrays.toString(methods));

        // 获取所有方法，public和private方法
        Method[] methodsDeclared = clazz.getDeclaredMethods();
        System.out.println(Arrays.toString(methodsDeclared));

        // 获取指定方法并调用
        Method method = clazz.getMethod("publicMethod", String.class);
        method.invoke(targetObject, "Reflect Test");

        // 对指定参数进行修改
        Field field = clazz.getDeclaredField("value");
        field.setAccessible(true);
        field.set(targetObject, "Reflect Test");

        // 调用private方法进行输出
        Method declaredMethod = clazz.getDeclaredMethod("privateMethod");
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(targetObject);
    }
}
