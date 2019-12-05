package com.buildupchao.algorithm.bloomfilter;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * <p>
 *     test cases for bloom-filter.
 * </p>
 *
 * @author buildupchao
 * @date 2019/12/05 09:46
 * @since JDK 1.8
 */
public class MyBloomFilterTest {

    @Test
    public void testAdd() {

    }

    @Test
    public void testContains() {
        MyBloomFilter bloomFilter = new MyBloomFilter();

        String myWebSiteLink = "http://www.buildupchao.cn";
        String myNickName = "大超";
        Integer myAge = 25;

        // check when does not contain elements.
        System.out.println(bloomFilter.contains(myWebSiteLink));
        System.out.println(bloomFilter.contains(myNickName));
        System.out.println(bloomFilter.contains(myAge));

        bloomFilter.add(myWebSiteLink);
        bloomFilter.add(myNickName);
        bloomFilter.add(myAge);

        // check when contains elements.
        System.out.println(bloomFilter.contains(myWebSiteLink));
        System.out.println(bloomFilter.contains(myNickName));
        System.out.println(bloomFilter.contains(myAge));
    }
}