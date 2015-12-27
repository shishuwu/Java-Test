package com.jasons.algo.sort;

import org.junit.Test;

/**
 * 快速排序也是分治法思想的一种实现，他的思路是
 * http://www.cnblogs.com/hexiaochun/archive/2012/09/03/2668324.html
 * 
 * <pre>
 *  - 找基准值： 使数组中的每个元素与基准值（Pivot，通常是数组的首个值，A[0]）比较，
 * 	- 数组中比基准值小的放在基准值的左边,形成左部；
 *  - 大的放在右边，形成右部；
 *  
 *  - 接下来将左部和右部分别递归地执行上面的过程：选基准值，小的放在左边，大的放在右边。。。直到排序结束。
 * </pre>
 * 
 * @author shishu
 *
 */
public class QuickSort {

	/**
	 * 先按照数组为数据原型写出算法，再写出扩展性算法。数组{49,38,65,97,76,13,27}
	 * 
	 * @param array
	 * @param left
	 * @param right
	 */
	public static void quickSort(int[] array, int left, int right) {
		int pivotKey;
		if (left < right) {
			pivotKey = partitionByPivotValue(array, left, right);
			// 对左右数组递归调用快速排序，直到顺序完全正确
			quickSort(array, left, pivotKey - 1);
			quickSort(array, pivotKey + 1, right);
		}
	}

	/**
	 * pivotValue作为枢轴，较之小的元素排序后在其左，较之大的元素排序后在其右
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	public static int partitionByPivotValue(int[] array, int left, int right) {
		// 选第一个作为中柚值
		int pivotValue = array[left];

		// 枢轴选定后永远不变，最终在中间，前小后大
		while (left < right) {
			while (left < right && array[right] >= pivotValue) {
				--right;
			}
			// 将比枢轴小的元素移到低端，此时right位相当于空，等待低位比pivotkey大的数补上
			array[left] = array[right];
			while (left < right && array[left] <= pivotValue) {
				++left;
			}
			// 将比枢轴大的元素移到高端，此时left位相当于空，等待高位比pivotkey小的数补上
			array[right] = array[left];
		}
		// 当left == right，完成一趟快速排序，此时left位相当于空，等待pivotkey补上
		array[left] = pivotValue;
		return left;
	}

	// ====================================
	@Test
	public void test() {
		int[] array = { 49, 38, 65, 97, 76, 13, 27 };
		quickSort(array, 0, array.length - 1);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " -- ");
		}
	}
}
