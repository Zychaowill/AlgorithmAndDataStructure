package com.buildupchao.algorithm.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * <p>
 *      Google bloom-filter from guava jar.
 *      Disadvantage: only support single-machine application, however, our application is generally distributed.
 * </p>
 *
 * @author buildupchao
 * @date 2019/12/05 10:00
 * @since JDK 1.8
 */
public class GoogleBloomFilterExample {

    public static void main(String[] args) {
        // create a bloom-filter used for checking 1500 integers, error rate: 0.01
        BloomFilter<Integer> bloomFilter = BloomFilter.create(
                Funnels.integerFunnel(),
                1500,
                0.01
        );

        System.out.println(bloomFilter.mightContain(25));
        System.out.println(bloomFilter.mightContain(30));

        bloomFilter.put(25);
        bloomFilter.put(30);

        System.out.println(bloomFilter.mightContain(25));
        System.out.println(bloomFilter.mightContain(30));
    }
}
