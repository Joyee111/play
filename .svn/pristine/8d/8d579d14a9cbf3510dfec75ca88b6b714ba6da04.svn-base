package com.sinosoft.core.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sinosoft.core.dao.PersonRepositoryImpl;
import com.sinosoft.entity.UserEntity;
import com.sinosoft.entity.UserInfoEntity;

/**
 * 
 * @ClassName: ShowPersonInfoItemDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangj
 * @date 2018年3月6日
 *
 * @param <T>
 */
@Repository
public class ShowPersonInfoItemDaoImpl<T> implements ShowPersonInfoItemDao {
	
	   @Autowired
	    private SessionFactory sessionFactory;
	    
	    private Class<T> persistentClass;
	    
	    private HibernateTemplate hibernateTemplate;

	    private Session getCurrentSession() {
	        return this.sessionFactory.openSession();
	    }

	    public UserEntity load(Long id) {
	        return (UserEntity)getCurrentSession().load(UserEntity.class,id);
	    }


	    public List<UserEntity> findAll() {
	    	return (List<UserEntity>) hibernateTemplate.loadAll(this.persistentClass);
	    }

	    public void persist(UserEntity entity) {
	        getCurrentSession().persist(entity);
	    }

	    public Long save(UserEntity entity) {
	        return (Long)getCurrentSession().save(entity);
	    }

	    public void saveOrUpdate(UserEntity entity) {
	        getCurrentSession().saveOrUpdate(entity);
	    }
	    @Override
	    public void delete(Long id) {
	        UserEntity userEntity = load(id);
	        getCurrentSession().delete(userEntity);
	    }

	    public HibernateTemplate getHibernateTemplate() {
	        return this.hibernateTemplate;
	    }
		@Override
		public List getPersonInfo(String sql) {
			List<UserEntity> list = null;
			Session session =getCurrentSession();
			try{
				
				Query query = session.createQuery(sql);
				
				list = query.list();
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				session.close();
			}
			return list;
		}

		@Override
		public UserEntity get(Long id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void save(UserInfoEntity user) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object find(Criterion... criterions) throws Exception {
			List<T> result = buildCriteria(criterions).setCacheable(isUseCache).list();
			if (result == null || result.size() < 1) {
				return null;
			}
			return result.get(0);
		}


		/**
		 * 组建Criteria
		 * @param criterions 
		 * @param orders
		 * @return
		 * @throws Exception
		 */
		protected Criteria buildCriteria(Criterion... criterions) throws Exception {
			Criteria criteria = getSession().createCriteria(entityClass);
			if (criterions != null) {
				for (Criterion criterion : criterions) {
					criteria.add(criterion);
				}
			}

			return criteria;
		}

		/**
		 * 返回当前session
		 * @return session
		 */
		protected Session getSession() {
			Session session = sessionFactory.getCurrentSession();
			return session;
		}
		protected Class entityClass;
		protected boolean isUseCache = false;

		@Override
		public <T> List<T> findByHql(String hql, Map<String, Object> args) throws Exception {
			Query query = getSession().createQuery(hql);
			Iterator totalIt = args.keySet().iterator();
			query.setProperties(args);
			return query.setCacheable(isUseCache).list();
		}


}
