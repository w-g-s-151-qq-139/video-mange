package com.zhiyou100.web.util;

import java.util.List;

public class Page<T> {
    
	private int total;//������
	private int page;//��ǰҳ
	private int size;//ÿҳ��ʾ������
    private List<T> rows;//���ݼ���
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
    
	
    
}
