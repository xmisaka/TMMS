package ehcache;

import org.junit.Test;
import org.slf4j.LoggerFactory;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;


public class CacheOperationTest {
	 private final org.slf4j.Logger log = LoggerFactory.getLogger(CacheOperationTest.class);

	    /**
	     * 使用Ehcache默认配置(classpath下的ehcache.xml)获取单例的CacheManager实例
	     */
	    @Test
	    public void operation() {
	        CacheManager manager = CacheManager.newInstance("src/main/resources/ehcache.xml");

	        // 获得Cache的引用
	        Cache cache = manager.getCache("userCache");

	        // 将一个Element添加到Cache
	        cache.put(new Element("key1", "value1"));

	        // 获取Element，Element类支持序列化，所以下面两种方法都可以用
	        Element element1 = cache.get("key1");
	        System.out.println(element1.getLastUpdateTime());
	        // 获取非序列化的值
	        log.debug("key:{}, value:{}", element1.getObjectKey(), element1.getObjectValue());
	        // 获取序列化的值
	        log.debug("key:{}, value:{}", element1.getKey(), element1.getValue());

	        // 更新Cache中的Element
	        cache.put(new Element("key1", "value2"));
	        Element element2 = cache.get("key1");
	        log.debug("key:{}, value:{}", element2.getObjectKey(), element2.getObjectValue());

	        // 获取Cache的元素数
	        log.debug("cache size:{}", cache.getSize());

	        // 获取MemoryStore的元素数
	        log.debug("MemoryStoreSize:{}", cache.getMemoryStoreSize());

	        // 获取DiskStore的元素数
	        log.debug("DiskStoreSize:{}", cache.getDiskStoreSize());

	        // 移除Element
	        cache.remove("key1");
	        log.debug("cache size:{}", cache.getSize());

	        // 关闭当前CacheManager对象
	        manager.shutdown();

	        // 关闭CacheManager单例实例
	        CacheManager.getInstance().shutdown();
	    }
}
