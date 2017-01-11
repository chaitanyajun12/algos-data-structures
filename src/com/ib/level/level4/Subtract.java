package com.ib.level.level4;

/**
 * Created by krishna.m1 on 16/12/16.
 */
public class Subtract {
    public interface Pair<K, V> {
        public K getKey();
        public V getValue();
    }

    public static class OrderedPair<K, V> implements Pair<K, V> {

        private K key;
        private V value;

        public OrderedPair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey()	{ return key; }
        public V getValue() { return value; }
    }
    public static void main(String args[]) {
        OrderedPair pair1 = new OrderedPair<>(1, "sadf");
        System.out.println((String) pair1.getValue());
    }
}
