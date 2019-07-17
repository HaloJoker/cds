package com.bfgy.cds.common.config;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页类<br/>
 * @version V1.0
 */

@NoArgsConstructor
@Data
public class PageWrapper<T> {

	/**
	 * 数据内容
	 */
	private List<T> content;
	/**
	 * 页码
	 */
	private int pageNum;
	/**
	 * 每页条数
	 */
	private int pageSize;
	/**
	 * 总页数
	 */
	private long totalPage;
	/**
	 * 记录总条数
	 */
	private long totalSize;
	
	public PageWrapper(int pageNum, int pageSize, long totalSize, int totalPage, List<T> content) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.totalSize = totalSize;
		this.content = content;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}
	
	/**
     * 根据pageNum和pageSize计算当前页第一条记录在总结果集中的位置,序号从1开始.
     */
    public int getFirst() {
        return ((pageNum - 1) * pageSize) + 1;
    }
    
    public long wapper(long totalSize) {
    		this.totalSize = totalSize ;
    		
    		if (totalSize % this.getPageSize() == 0 ) {
    			totalPage = Math.floorDiv(totalSize, this.getPageSize()) ;
    		}else {
    			totalPage = Math.floorDiv(totalSize, this.getPageSize()) + 1 ;
    		}
    		
        return totalPage ;
    }
	
}
