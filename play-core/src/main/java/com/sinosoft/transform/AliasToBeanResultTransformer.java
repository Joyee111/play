package com.sinosoft.transform;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.property.ChainedPropertyAccessor;
import org.hibernate.property.PropertyAccessor;
import org.hibernate.property.PropertyAccessorFactory;
import org.hibernate.property.Setter;
import org.hibernate.transform.AliasedTupleSubsetResultTransformer;
/**
 * 
 * @author wangj
 * @date 2018年3月6日
 * @ClassName: AliasToBeanResultTransformer
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 */
public class AliasToBeanResultTransformer extends AliasedTupleSubsetResultTransformer {
	private final Class resultClass;
	private boolean isInitialized;
	private String[] aliases;
	private Setter[] setters;

	public AliasToBeanResultTransformer(Class resultClass) {
		if (resultClass == null) {
			throw new IllegalArgumentException("resultClass cannot be null");
		}
		isInitialized = false;
		this.resultClass = resultClass;
	}

	@Override
	public boolean isTransformedValueATupleElement(String[] aliases, int tupleLength) {
		return false;
	}

	@Override
	public Object transformTuple(Object[] tuple, String[] aliases) {
		Object result;

		try {
			if (!isInitialized) {
				initialize(aliases);
			} else {
				check(aliases);
			}

			result = resultClass.newInstance();

			for (int i = 0; i < aliases.length; i++) {
				if (setters[i] != null) {
					setters[i].set(result, tuple[i], null);
				}
			}
		} catch (InstantiationException e) {
			throw new HibernateException("Could not instantiate resultclass: " + resultClass.getName());
		} catch (IllegalAccessException e) {
			throw new HibernateException("Could not instantiate resultclass: " + resultClass.getName());
		}

		return result;
	}

	private void initialize(String[] aliases) {
		PropertyAccessor propertyAccessor = new ChainedPropertyAccessor(
				new PropertyAccessor[] { PropertyAccessorFactory.getPropertyAccessor(resultClass, null),
						PropertyAccessorFactory.getPropertyAccessor("field") });
		this.aliases = new String[aliases.length];
		setters = new Setter[aliases.length];
		for (int i = 0; i < aliases.length; i++) {
			String alias = aliases[i];
			if (alias != null) {
				this.aliases[i] = alias;
				try{
					setters[i] = propertyAccessor.getSetter(resultClass, alias);
				}catch(Exception e){
				}
				
			}
		}
		isInitialized = true;
	}

	private void check(String[] aliases) {
		if (!Arrays.equals(aliases, this.aliases)) {
			throw new IllegalStateException("aliases are different from what is cached; aliases="
					+ Arrays.asList(aliases) + " cached=" + Arrays.asList(this.aliases));
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		AliasToBeanResultTransformer that = (AliasToBeanResultTransformer) o;

		if (!resultClass.equals(that.resultClass)) {
			return false;
		}
		if (!Arrays.equals(aliases, that.aliases)) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = resultClass.hashCode();
		result = 31 * result + (aliases != null ? Arrays.hashCode(aliases) : 0);
		return result;
	}
}
