package com.sinosoft.transform;

import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.ToListResultTransformer;
/**
 * 
 * @author wangj
 * @date 2018年3月6日
 * @ClassName: Transformers
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 */
final public class Transformers {

	private Transformers() {}
	
	/**
	 * Each row of results is a <tt>Map</tt> from alias to values/entities
	 */
	public static final AliasToEntityMapResultTransformer ALIAS_TO_ENTITY_MAP =
			AliasToEntityMapResultTransformer.INSTANCE;

	/**
	 * Each row of results is a <tt>List</tt> 
	 */
	public static final ToListResultTransformer TO_LIST = ToListResultTransformer.INSTANCE;
	
	/**
	 * Creates a resulttransformer that will inject aliased values into 
	 * instances of Class via property methods or fields.
	 */
	public static ResultTransformer aliasToBean(Class target) {
		return new AliasToBeanResultTransformer(target);
	}
	
}