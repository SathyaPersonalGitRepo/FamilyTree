package com.hierarchy.family;

/**
 * 
 * @author sadasari
 *  
 *    Container that holds data common across all nodes.
 */

public class Data {

	private Integer parentId;

	private Integer nodeId;

	private String name;

	public Data() {

	}

	public Data(Integer parentId, Integer nodeId, String name) {

		super();

		this.parentId = parentId;

		this.nodeId = nodeId;

		this.name = name;

	}

	@Override
	public String toString() {

		return "Data [parentId=" + parentId + ", nodeId=" + nodeId + ", name="
				+ name + "]";

	}

	public Integer getParentId() {

		return parentId;

	}

	public void setParentId(Integer parentId) {

		this.parentId = parentId;

	}

	public Integer getNodeId() {

		return nodeId;

	}

	public void setNodeId(Integer nodeId) {

		this.nodeId = nodeId;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

}
