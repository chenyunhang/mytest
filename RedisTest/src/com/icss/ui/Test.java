package com.icss.ui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;
import com.icss.util.RedisUtil;


public class Test {
	
	  public static void testString(Jedis jedis) {
          //-----添加数据----------  
           jedis.set("name","xinxin");//向key-->name中放入了value-->xinxin  
           System.out.println(jedis.get("name"));//执行结果：xinxin  
           
           jedis.append("name", " is my lover"); //拼接
           System.out.println(jedis.get("name")); 
           
           jedis.del("name");  //删除某个键
           System.out.println(jedis.get("name"));
           
           //设置多个键值对
           jedis.mset("name","liuling","age","23","qq","476777XXX");
           jedis.incr("age"); //进行加1操作
           System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));		           
	 }
	  
	  
	  
	    public static void testList(Jedis jedis){  
		           //开始前，先移除所有的内容  
		           jedis.del("java framework");  
		           System.out.println(jedis.lrange("java framework",0,-1)); 
		           
		           //先向key java framework中存放三条数据  
		           jedis.lpush("java framework","spring");  
		           jedis.lpush("java framework","struts");  
		           jedis.lpush("java framework","hibernate");  
		           //再取出所有数据jedis.lrange是按范围取出，  
		           // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有  
		           System.out.println(jedis.lrange("java framework",0,-1));  
		           
		           jedis.del("java framework");
		           jedis.rpush("java framework","spring");  
		           jedis.rpush("java framework","struts");  
		           jedis.rpush("java framework","hibernate"); 
		           System.out.println(jedis.lrange("java framework",0,-1));
		}  
	    
	    public static void testSet(Jedis jedis){  
	           //添加  
	           jedis.sadd("user","liuling");  
	           jedis.sadd("user","xinxin");  
	           jedis.sadd("user","ling");  
	           jedis.sadd("user","zhangxinxin");
	           jedis.sadd("user","who");  
	           //移除  
	           jedis.srem("user","who");  
	           System.out.println(jedis.smembers("user"));          //获取所有加入的value  
	           System.out.println(jedis.sismember("user", "who"));  //判断 who 是否是user集合的元素  
	           System.out.println(jedis.srandmember("user"));  
	           System.out.println(jedis.scard("user"));				//返回集合的元素个数  
	    }  
	    
	    public static void testMap(Jedis jedis) {
	           //-----添加数据----------  
	           Map<String, String> map = new HashMap<String, String>();
	           map.put("name", "xinxin");
	           map.put("age", "22");
	           map.put("qq", "123456");
	           jedis.hmset("user",map);
	           //取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List  
	           //第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数  
	           List<String> rsmap = jedis.hmget("user", "name", "age", "qq");
	           System.out.println(rsmap);  
	     
	           //删除map中的某个键值  
	           jedis.hdel("user","age");
	           System.out.println(jedis.hmget("user", "age")); //因为删除了，所以返回的是null  
	           System.out.println(jedis.hlen("user"));         //返回key为user的键中存放的值的个数2 
	           System.out.println(jedis.exists("user"));       //是否存在key为user的记录 返回true  
	           System.out.println(jedis.hkeys("user"));        //返回map对象中的所有key  
	           System.out.println(jedis.hvals("user"));        //返回map对象中的所有value 
	     
	           Iterator<String> iter = jedis.hkeys("user").iterator();  
	           while (iter.hasNext()){  
	               String key = iter.next();  
	               System.out.println(key+":"+jedis.hmget("user",key));  
	           }  
		}  	
	
	public static void main(String[] args) {
		
		Jedis jedis = RedisUtil.getJedis();
		Test.testSet(jedis);
		RedisUtil.returnResource(jedis);
	}

}
