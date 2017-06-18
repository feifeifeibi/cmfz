package com.baizhi.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisUtil {
	//重量级资源，线程安全
	private static SqlSessionFactory sqlSessionFactory ;
	private static final ThreadLocal<SqlSession> tol = new ThreadLocal<SqlSession>();
	
	static{
		try {
			//获取读取配置文件的输入流
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			
			//通过工厂获取sqlsession
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获取sqlSession对象
	 * @return
	 */
	public static SqlSession getSqlSession(){
		SqlSession sqlSession = tol.get();
		if(sqlSession==null){
			sqlSession = sqlSessionFactory.openSession();
			tol.set(sqlSession);
		}
		return sqlSession;
	}
	
	/**
	 * 释放资源
	 */
	public static void release(){
		
		SqlSession sqlSession = tol.get();
		if(sqlSession!=null){
			sqlSession.close();
			tol.remove();
		}
	}
	
	
	/**
	 * 获取dao对象的方法
	 * 
	 */
	public static Object getMapper(Class clazz){
		return getSqlSession().getMapper(clazz);
	}
	
	/**
	 * 提交事务的方法
	 */
	public static void commit(){
		getSqlSession().commit();
		release();
	}
	
	/**
	 * 回滚事务的方法
	 */
	public static void rollback(){
		getSqlSession().rollback();
		release();
	}
	
}
