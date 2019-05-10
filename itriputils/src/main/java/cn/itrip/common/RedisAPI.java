package cn.itrip.common;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis工具类
 */
public class RedisAPI {
	
	public JedisPool jedisPool;
	
	public JedisPool getJedisPool() {
		return jedisPool;
	}
	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
	/**
	 * 设置key和value
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(String key,String value){
		try{
			Jedis jedis = jedisPool.getResource();
			jedis.set(key, value);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 将验证码存入redis中
	 * @param key
	 * @param seconds 有效期
	 * @param value
	 * @return
	 */
	public boolean set(String key,int seconds,String value){
		try{
			Jedis jedis = jedisPool.getResource();
			jedis.setex(key,seconds,value);
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 判断某个key是否存在
	 * @param key
	 * @return
	 */
	public boolean exist(String key){
		try{
			Jedis jedis = jedisPool.getResource();
			return jedis.exists(key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 返还到连接池
	 * @param pool
	 * @param redis
	 */
	public static void returnResource(JedisPool pool,Jedis redis){
		if(redis != null){
			pool.returnResource(redis);
		}
	}
	
	/**
	 * 获取数据
	 * @param key
	 * @return
	 */
	public String get(String key){
		String value = null;
		Jedis jedis = null;
		try{
			jedis = jedisPool.getResource();
			value = jedis.get(key);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//返还到连接池
			returnResource(jedisPool, jedis);
		}
		
		return value;
	}
	
	/**
	 * 查询key的有效期,当 key 不存在时，返回 -2 。 当 key 存在但没有设置剩余生存时间时，返回 -1 。 否则，以秒为单位，返回 key 的剩余生存时间。
	 * 注意：在 Redis 2.8 以前，当 key 不存在，或者 key 没有设置剩余生存时间时，命令都返回 -1 。
	 * @param key
	 * @return 剩余多少秒
	 */
	public Long ttl(String key){
		try{
			Jedis jedis = jedisPool.getResource();
			return jedis.ttl(key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return (long) -2;
	}
	
	/**
	 * 删除
	 * @param key
	 */
	public void delete(String key){
		try{
			Jedis jedis = jedisPool.getResource();
			jedis.del(key);
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
