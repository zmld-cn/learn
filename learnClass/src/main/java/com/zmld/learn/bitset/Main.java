package com.zmld.learn.bitset;

import java.util.BitSet;

public class Main {

    public static void main(String[] args) {
        // 构造方法BitSet()，BitSet(int size)
        BitSet bitSet = new BitSet(10);

        boolean b1 = bitSet.get(0); // false
        // void set(int index),设置对应下标为true
        // void set(int index, boolean v) 设置对应下标为指定值
        // void set(int startIndex, int endIndex)
        // void set(int startIndex, int endIndex, boolean v)
        // 设置bitSet对应下标
        bitSet.set(0);
        // git(int index)方法，如果有set则为true,否则为false
        boolean b2 = bitSet.get(0); // true

        // get(int fromIndex, int toIndex)，
        // 返回一个新的BitSet，它由此BitSet中从fromIndex（包括）到toIndex（不包括）范围内的位组成。
        bitSet.set(0);
        bitSet.set(1);
        bitSet.set(2);
        bitSet.set(3);
        BitSet bitSet1 = bitSet.get(1, 3); // {0,1}

        // 返回此BitSet中设置为true的个数
        int cardinality = bitSet.cardinality();// 4

        // void clear() 把bitSet所有位设置为false
        // void clear(int index) 把index位置设置为false
        // void clear(int startIndex, int endIndex) 把startIndex(包括)到endIndex(不包括)设置为false
        bitSet.clear(1); //{0,1,2,3} -> {0,2,3}
        bitSet.clear(2,3); //{0,1,2,3} -> {0,3}

        //void flip(int index)
        //void flip(int startIndex, int endIndex)
        //翻转对应位置的值，即为true->false或者false->true
        bitSet.flip(1); //{0,1,2,3} -> {0,1,3}
        bitSet.flip(1,3); //{0,1,2,3} -> {0,2,3}

        //boolean intersects(BitSet bitSet)
        //如果本bitSet中有参数bitSet相同的位置为true，返回结果为ture
        BitSet temp1 = new BitSet();
        temp1.set(2); // {0,2,3}
        boolean intersects = bitSet.intersects(temp1); // true

        //boolean isEmpty()
        // 如果此BitSet中没有包含任何设置为true的位，则返回 true
        boolean empty = bitSet.isEmpty();// false

        // int length()
        // 返回此BitSet的"逻辑大小"：BitSet中最高设置位的索引加 1。
        int length = bitSet.length(); // 4

        //int nextClearBit(int startIndex)
        //返回第一个设置为false的位的索引，这发生在指定的起始索引或之后的索引上。
        int nextClear = bitSet.nextClearBit(0); // 1 {0,2,3}

        //int nextSetBit(int startIndex)
        //返回第一个设置为true的位的索引，这发生在指定的起始索引或之后的索引上。
        int nextSet = bitSet.nextSetBit(0); // 0 {0,2,3}

        //int size()
        // 返回此BitSet表示位值时实际使用空间的位数。
        int size = bitSet.size(); // 64

        //String toString()
        String s = bitSet.toString(); // {0,2,3}

        //void and(BitSet set) 与
        //void or(BitSet set) 或
        //void xor(BitSet set) 异或(相同为0，不同为1)
        BitSet bits1 = new BitSet(16);
        BitSet bits2 = new BitSet(16);
        for(int i=0; i<16; i++) {
            if((i%2) == 0) bits1.set(i);
            if((i%5) != 0) bits2.set(i);
        }
        // bits1={0, 2, 4, 6, 8, 10, 12, 14}
        // bits2={1, 2, 3, 4, 6, 7, 8, 9, 11, 12, 13, 14}
        bits2.and(bits1); //bits2={2, 4, 6, 8, 12, 14}
        bits2.or(bits1); //bits2={0, 2, 4, 6, 8, 10, 12, 14}
        bits2.xor(bits1);//bits2={}
        //bits2.andNot(bits1); //相当于bits1-bits2（存在bits1但是不存在bits2中的位）
    }
}
