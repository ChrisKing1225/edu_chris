package edu0425.spring.demo;

public class NodeDemo {

	private Integer data;//根节点值
	
	private NodeDemo left = null;

	private NodeDemo right = null;
	
	
	public NodeDemo(Integer root) {
		this.data = root;
	}
	
	public void insert(Integer data) {
		if(data<this.data) {
			if(this.left==null) {
				this.left=new NodeDemo(data);
			}else {
				this.left.insert(data);
			}
		}else if (data>this.data) {
			if(this.right==null) {
				this.right=new NodeDemo(data);
			}else {
				this.right.insert(data);
			}
		}else {
			this.data = data;
		}
	}
	
	public void inorder() {
		if(this.left !=null) {
			this.left.inorder();
		}
		System.out.print(this.data+",");
		if(this.right !=null) {
			this.right.inorder();
		}
	}
	
	
	
	
	
	
	
}
