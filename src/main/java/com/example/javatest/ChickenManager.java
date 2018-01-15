package com.example.javatest;

import java.util.Arrays;

/**
 * ChickenManager
 * 数组对象的动态扩充
 * Created by My on 2018/1/15.
 */

public class ChickenManager {
    private Chicken[] chickens;
    private int count;

    // 数组初始长度根据外部决定
    public ChickenManager(int size) {
        if (size > 0) {
            chickens = new Chicken[size];
        } else {
            chickens = new Chicken[3];
        }

    }

    public void add(Chicken chicken) {
        if (count < chickens.length) {
            chickens[count] = chicken;
        } else {
            // 这里动态扩充使用增加1位的算法避免数组中出现null对象不方便遍历
            int newLen = chickens.length + 1;
            chickens = Arrays.copyOf(chickens, newLen);
            chickens[count] = chicken;
        }
        count++;
    }

    public boolean delete(int id) {
        for (int i = 0; i < chickens.length; i++) {
            if (chickens[i].getId() == id) {
                Chicken[] newChickens = new Chicken[chickens.length - 1];
                System.arraycopy(chickens, 0, newChickens, 0, i);
                System.arraycopy(chickens, i + 1, newChickens, i, chickens.length - 1 - i);
                chickens = newChickens;
                // 这里很关键，找到一定要退出，不然数组长度变化后会报越界异常
                return true;
            }
        }
        return false;
        // 还有一种算法也不错，有空要实现，直接挪
    }

    /**
     * 更新年龄
     *
     * @param c chicken
     */
    public boolean update(Chicken c) {
        Chicken chicken = this.find(c.getId());
        if (chicken != null) {
            chicken.setName(c.getName());
            chicken.setAge(c.getAge());
            return true;
        }
        return false;
    }

    public Chicken find(int id) {
        for (Chicken chicken : chickens) {
            if (chicken.getId() == id) {
                return chicken;
            }
        }
        return null;
    }

    public void query() {
        /*for(int i = 0;i<chickens.length;i++){
            System.out.println(chickens[i]);
        }*/
        System.out.println(Arrays.toString(chickens));
    }
}
