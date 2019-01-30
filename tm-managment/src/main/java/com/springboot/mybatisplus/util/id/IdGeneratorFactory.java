package com.springboot.mybatisplus.util.id;


import cn.com.do1.xlg.constants.Constants;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ID生成器工厂<p>
 * 〈功能详细描述〉
 *
 * @author zixiao
 * @date 16/10/9
 */
public class IdGeneratorFactory {

    private static final IdGeneratorFactory ID_GENERATOR_FACTORY = new IdGeneratorFactory();

    private final ReentrantLock createLock = new ReentrantLock();

    private final ConcurrentHashMap<String/* dataCenterId+workerId */, IdWorker> idWorkerTable = new ConcurrentHashMap<String, IdWorker>(1);

    private IdGeneratorFactory(){}

    public static IdGeneratorFactory getInstance(){
        return ID_GENERATOR_FACTORY;
    }

    public IdWorker getAndCreate(int dataCenterId, int workerId){
        String key = dataCenterId + Constants.UNDERLINE + workerId;
        IdWorker instance = this.idWorkerTable.get(key);
        if (null != instance) {
            return instance;
        }
        try {
            createLock.lock();

            instance = this.idWorkerTable.get(key);
            if (null != instance) {
                return instance;
            }

            instance = new IdWorker(workerId, dataCenterId);
            this.idWorkerTable.put(key, instance);

            return instance;
        }finally {
            createLock.unlock();
        }
    }
}
