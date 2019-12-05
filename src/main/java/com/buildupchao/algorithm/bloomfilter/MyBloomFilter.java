package com.buildupchao.algorithm.bloomfilter;

import java.util.BitSet;

/**
 * <p>
 *    how realize a bloom-filter:
 *    Firstly, a suitable bit-array used for saving data.
 *    Secondly, some kinds of hash functions.
 *    Thirdly, offer method that add elements into bloom-filter (bit-array).
 *    Finally, offer method that check if an element exists in bloom-filter.
 * </p>
 *
 * @author buildupchao
 * @date 2019/12/04 18:10
 * @since JDK 1.8
 */
public class MyBloomFilter {

    /**
     * the capacity of bloom-filter.
     */
    private static final int DEFAULT_SIZE = 2 << 24;


    /**
     * different hash functions.
     */
    private static final int[] SEEDS = new int[] {3, 13, 46, 71, 91, 134};

    /**
     * bit-array. the value of element is only 0 or 1.
     */
    private BitSet bits = new BitSet(DEFAULT_SIZE);

    /**
     * store class array that each one owns hash function.
     */
    private SimpleHash[] hashFunctions = new SimpleHash[SEEDS.length];

    /**
     * initialize some different hash function of class.
     */
    public MyBloomFilter() {
        for (int i = 0; i < SEEDS.length; i++) {
            hashFunctions[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
        }
    }

    /**
     * add element into bit-array.
     *
     * @param value
     */
    public void add(Object value) {
        for (SimpleHash hashFunction : hashFunctions) {
            bits.set(hashFunction.hash(value), true);
        }
    }

    /**
     * check if the element exists in bit-array.
     *
     * @param value
     * @return
     */
    public boolean contains(Object value) {
        boolean ret = true;
        for (SimpleHash hashFunction : hashFunctions) {
            ret = ret && bits.get(hashFunction.hash(value));
        }
        return ret;
    }

    /**
     * used for hash operation.
     */
    public static class SimpleHash {
        private int capacity;
        private int seed;

        public SimpleHash(int capacity, int seed) {
            this.capacity = capacity;
            this.seed = seed;
        }

        public int hash(Object value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (capacity - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
        }
    }
}
