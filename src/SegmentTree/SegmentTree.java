package SegmentTree;

import java.util.ArrayList;
import java.util.List;

public class SegmentTree {
	private List<Integer> tree;
	private Integer sizeOfTree;
	private Integer sizeOfArray;

	public SegmentTree() {
		tree = new ArrayList<Integer>();
		sizeOfTree = 0;
		sizeOfArray = 0;
	}

	public SegmentTree(Integer sizeOfArray) {
		this();

		this.sizeOfArray = sizeOfArray;
		sizeOfTree = 4 * sizeOfArray;

		for (int i = 0; i < sizeOfTree; i++) {
			tree.add(0);
		}
	}

	public SegmentTree(List<Integer> array) {
		this(array.size());
		build(array);
	}

	private void build(List<Integer> array, Integer node, Integer beg, Integer end) {
		if (beg > end)
			return;

		if (beg == end) {
			// leaf
			tree.set(node, array.get(end)); // tree[node] = array[end];
			return;
		}

		Integer mid = (beg + end) / 2;

		build(array, 2 * node, beg, mid); // left
		build(array, 2 * node + 1, mid + 1, end); // right

		// tree[node] = tree[2 * node] + tree[2 * node + 1];
		tree.set(node, tree.get(2 * node) + tree.get(2 * node + 1));

	}

	public void build(List<Integer> array) {
		build(array, 1, 0, array.size() - 1);
	}

	private void update(Integer position, Integer value, Integer node, Integer beg, Integer end) {
		if (beg > end)
			return;

		if (beg == end) {
			if (position == end) {
				tree.set(node, value);
			}
			return;
		}

		Integer mid = (beg + end) / 2;

		if (position <= mid) {
			update(position, value, 2 * node, beg, mid);
		} else {
			update(position, value, 2 * node + 1, mid + 1, end);
		}

		// tree[node] = tree[2 * node] + tree[2 * node + 1];
		tree.set(node, tree.get(2 * node) + tree.get(2 * node + 1));

	}

	public void update(Integer position, Integer value) {
		update(position, value, 1, 0, sizeOfArray - 1);
	}

	private Integer sum(Integer I, Integer J, Integer node, Integer beg, Integer end) {

		if (beg > end)
			return 0;

		// no-overlap
		if (isNoOverlap(I, J, beg, end))
			return 0;

		if (isFullOverlap(I, J, beg, end)) {
			return tree.get(node);
		}

		// partial-overlap
		Integer mid = (beg + end) / 2;
		return sum(I, J, 2 * node, beg, mid) + sum(I, J, 2 * node + 1, mid + 1, end);

	}

	private boolean isFullOverlap(Integer I, Integer J, Integer beg, Integer end) {
		return (I <= beg && end <= J);
	}

	private boolean isNoOverlap(Integer I, Integer J, Integer beg, Integer end) {
		return (I > end || J < beg);
	}

	public Integer sum(Integer I, Integer J) {
		return sum(I, J, 1, 0, sizeOfArray - 1);
	}

}
