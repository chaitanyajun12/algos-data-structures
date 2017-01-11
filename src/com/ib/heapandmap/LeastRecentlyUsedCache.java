package com.ib.heapandmap;

import java.util.HashMap;

/**
 * Created by krishna.m1 on 19/12/16.
 */
public class LeastRecentlyUsedCache {
    public class Solution {
        private HashMap<Integer, Integer> map;
        private int size, capacity;

        public Solution(int capacity) {
            size = 0;
            this.capacity = capacity;
            map = new HashMap<>(capacity);
        }

        public int get(int key) {
            return map.get(key) == null ? -1 : map.get(key);
        }

        public void set(int key, int value) {
            if (map.containsKey(key)) {
                map.put(key, value);
            } else {
                if (size == capacity) {
                    removeLeastRecentlyItem();
                }

                map.put(key, value);
                size++;
            }
        }

        private void removeLeastRecentlyItem() {

        }
    }


    public static void main(String args[]) {

    }
}
