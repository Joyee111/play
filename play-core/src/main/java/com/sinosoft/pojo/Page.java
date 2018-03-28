package com.sinosoft.pojo;

import java.io.Serializable;
import java.util.List;


/**
 * 分页实体类
 * @author mengyang
 *
 */
public class Page<T>  implements Serializable{
	
	private int total;
	private List<T> rows;
	private int pageTotal;
	
	
	public Page() {
		super();
	}

	public Page(int total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	
	

	public Page(int total, List<T> rows, int pageTotal) {
		super();
		this.total = total;
		this.rows = rows;
		this.pageTotal = pageTotal;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	
	
	
	
	
}
