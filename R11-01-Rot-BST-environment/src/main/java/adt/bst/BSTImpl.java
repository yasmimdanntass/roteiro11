package adt.bst;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(root);
	}

	private int height(BSTNode node) {
		int height = -1;

		if (node != null && !node.isEmpty()){
			BSTNode leftNode = (BSTNode) node.getLeft();
			BSTNode rightNode = (BSTNode) node.getRight();
			height = 1 + Math.max(height(leftNode), height(rightNode));
		}

		return height;
	}

	@Override
	public BSTNode<T> search(T element) {
		return searchTree(root, element);
	}

	private BSTNode<T> searchTree(BSTNode<T> node, T element) {
		BSTNode rNode = null;

		if (node.isEmpty() || element.equals(node.getData())){
			rNode = node;
		} else if (element.compareTo(node.getData()) == -1){
			rNode = searchTree((BSTNode) node.getLeft(), element);
		} else {
			rNode = searchTree((BSTNode) node.getRight(), element);
		}

		return rNode;
	}

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode auxNode = this.root;
		while (!auxNode.isEmpty()){
			auxNode = (BSTNode) auxNode.getRight();
		}
		return auxNode;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode auxNode = this.root;
		while (!auxNode.isEmpty()){
			auxNode = (BSTNode) auxNode.getLeft();
		}
		return auxNode;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
