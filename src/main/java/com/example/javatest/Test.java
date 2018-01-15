package com.example.javatest;

import java.util.Arrays;

/**
 * 对象数组就是数组里的每个元素都是类的对象，赋值时先定义对象，然后将对象直接赋给数组。
 * 示例：
 * Chicken[] cs= new Chicken[10];
 * 使用对象数组实现多个Chicken的管理。
 */
public class Test {

    public static void main(String[] args) {

        ChickenManager chickenManager = new ChickenManager(3);
        // 添加对象
        chickenManager.add(new Chicken(1, "小小", 1));
        chickenManager.add(new Chicken(2, "中中", 2));
        chickenManager.add(new Chicken(3, "大大", 3));
        chickenManager.add(new Chicken(4, "老老", 4));
        chickenManager.add(new Chicken(5, "aa", 5));
        chickenManager.add(new Chicken(6, "bb", 6));
        chickenManager.add(new Chicken(7, "cc", 7));

        System.out.println("----------query---------");
        // 查询结果
        chickenManager.query();

        System.out.println("----------find---------");
        // 根据id查找指定对象
        Chicken chicken = chickenManager.find(9);
        System.out.println(chicken);

        System.out.println("----------delete---------");
        // 删除指定对象
        boolean isDelete = chickenManager.delete(1);
        System.out.println(isDelete ? "删除成功" : "删除失败");
        chickenManager.query();

        System.out.println("----------update---------");
        // 更新一个对象
        boolean isUpdate = chickenManager.update(new Chicken(1, "小小", 10));
        System.out.println(isUpdate ? "更新成功" : "更新失败");
        chickenManager.query();

    }


}
