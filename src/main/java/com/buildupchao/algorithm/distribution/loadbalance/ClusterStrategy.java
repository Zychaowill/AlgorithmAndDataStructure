package com.buildupchao.algorithm.distribution.loadbalance;

import java.util.List;

/**
 * @author buildupchao
 * @date: 2019/5/12 21:51
 * @since JDK 1.8
 */
public interface ClusterStrategy {

    /**
     * 负载均衡算法接口
     * @param ipList ip地址列表
     * @return 通过负载均衡算法选中的ip地址
     */
    String select(List<String> ipList);
}
