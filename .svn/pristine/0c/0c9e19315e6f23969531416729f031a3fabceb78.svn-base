package com.sinosoft.core.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sinosoft.entity.UserEntity;
import com.sinosoft.entity.UserInfoEntity;
/**
 * @author wangj
 * @date 2018年3月6日
 * @ClassName: PersonRepositoryImpl
 * @Description: TODO(dao层实现)
 *
 * @param <T>
 */
@Repository
public class PersonRepositoryImpl<T> implements PersonRepository {
	protected Class entityClass;
	protected boolean isUseCache = false;
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

	public T find(Criterion... criterions) throws Exception {
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
		Criteria criteria = getCurrentSession().createCriteria(entityClass);
		if (criterions != null) {
			for (Criterion criterion : criterions) {
				criteria.add(criterion);
			}
		}

		return criteria;
	}
    public List<UserEntity> findAll() {
    	return (List<UserEntity>) hibernateTemplate.loadAll(this.persistentClass);
    }

    public void persist(UserEntity entity) {
        getCurrentSession().persist(entity);
    }

    public void save(UserEntity entity) {
        getCurrentSession().save(entity);
    }

    public void saveOrUpdate(UserEntity entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Long id) {
        UserEntity userEntity = load(id);
        getCurrentSession().delete(userEntity);
    }

    public void flush() {
        getCurrentSession().flush();
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
		 return (UserEntity)getCurrentSession().get(UserEntity.class,id);
	}

	@Override
	public void save(UserInfoEntity user) {
		getCurrentSession().saveOrUpdate(user);
		
		
	}



}
