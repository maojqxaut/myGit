

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程业务处理工具类
 * 
 * @author Nicholas
 * @version
 */
public final class PoolUtil {

    private static final int POOL_THREAD_COUNT = 5;

    /**
     * 计算线程池数量
     * 
     * @param dataSize
     * @return
     */
    private static int calcPoolSize(int dataSize) {
        int poolSize = 1;
        if (dataSize > POOL_THREAD_COUNT) {
            poolSize = POOL_THREAD_COUNT;
        } else {
            poolSize = dataSize;
        }
        return poolSize;
    }

    /**
     * 无返回结果的多线程业务处理
     * 
     * @param callables
     * @throws Exception
     */
    public static void excute(List<Callable<Void>> callables)
            throws Exception {
        ExecutorService pool = null;
        int poolSize = calcPoolSize(callables.size());
        try {
            pool = Executors.newFixedThreadPool(poolSize);
            CompletionService<Void> competionService = new ExecutorCompletionService<Void>(
                    pool);
            for (Callable<Void> callable : callables) {
                competionService.submit(callable);
            }
            for (int i = 0; i < callables.size(); i++) {
                competionService.take().get();
            }
        } catch (Exception e) {
            throw e;
        } finally {
            // 关闭线程池
            if (pool != null) {
                pool.shutdown();
            }
        }
    }

    public static int getPoolThreadCount() {
        return POOL_THREAD_COUNT;
    }
}
