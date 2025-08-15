package me.icemoon.hot150.array;

import java.util.*;

/**
 * @author Yulong
 * @create 2025/7/24
 * @description O(1) 时间插入、删除和获取随机元素
 */
public class _0380_RandomizedSet {
    class RandomizedSet {
        HashMap<Integer, Integer> map;
        List<Integer> list;
        Random random;// 存储元素及其索引

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false; // 如果值已存在，返回false
            }
            map.put(val, list.size()); // 将值和其索引存入map
            list.add(val); // 将值添加到list的末尾
            return true; // 返回true表示插入成功
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false; // 如果值不存在，返回false
            }
            int index = map.get(val); // 获取值的索引
            int last = list.get(list.size() - 1); // 获取list中的最后一个元素
            list.set(index, last); // 将最后一个元素移动到被删除元素的位置
            map.put(last, index); // 更新最后一个元素在map中的索引
            list.remove(list.size() - 1); // 移除list中的最后一个元素
            map.remove(val); // 从map中删除被删除的元素
            return true; // 返回true表示删除成功
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size())); // 返回list中的随机元素
        }
    }

}
