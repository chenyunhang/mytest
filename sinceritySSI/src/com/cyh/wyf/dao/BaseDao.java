package com.cyh.wyf.dao;


public class BaseDao {
	

/*	protected SqlSession session;
	
	private static SqlSessionFactory sqlSessionFactory;     //一个项目只需要一个工厂就可以了
	
	static{
		//使用静态代码块，给静态变量sqlSessionFactory进行初始化
		String resource = "mybatis.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("ddddd");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void openConnection(){
		if(session == null){
			session = sqlSessionFactory.openSession(true);       //默认为自动提交模式
		}		
	}
	
	public void closeConnection(){
		if(session != null){
			this.session.close();
		}		
	}
	
	public void beginTransaction(){
		session = sqlSessionFactory.openSession(false);       //使用手动提交的方式，打开数据库
	}
	
	public void commit(){		
		if(session != null){
			this.session.commit();
		}		
	}
	
	public void rollback(){
		if(session != null){
			this.session.rollback();
		}
	}*/

	
	/**
	 *  根据ORACLE的翻页写法，对传入的sql改装成翻页算法的sql
	 * @param sql
	 * @param iStart
	 * @param iEnd
	 * @return
	 */
	protected String getTurnPageSql(String sql,int iStart,int iEnd){
		
		String newSql = "";
		newSql = "select * from (select rownum rnum ,tb.* from (" + sql + ") tb ) where rnum>=" + iStart + " and rnum<" + iEnd;
		
		return newSql;
	}
	
	/**
	 * 根据传入的sql，计算要查询的记录总数
	 * @param sql
	 * @return
	 */
/*	protected int getAllCount(String sql) throws Exception{
		int allCount = 0;
		
		String newSql = "select count(*)  from (" + sql +")tb";
		this.openConnection();
		PreparedStatement ps = this.connection.prepareStatement(newSql);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			while(rs.next()){
		      allCount = rs.getInt(1);	
		      break;
			}
		}
		
		return allCount;
	}*/

}
