package sortingAlgorithm;

import java.util.Arrays;

/**
 * 和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(n log n）的时间复杂度。代价是需要额外的内存空间。
 * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 归并排序是一种稳定的排序方法。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 * @author yuxiaoyu
 *
 */
public class MergeSort {

	/**
     * 归并排序
     * 把长度为n的输入序列分成两个长度为n/2的子序列；
     * 对这两个子序列分别采用归并排序；
     * 将两个排序好的子序列合并成一个最终的排序序列。
     *
     * @param array
     * @return
     */
    public static int[] mergeSort(int[] array) {
        if (array.length < 2) 
        		return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])		// >:顺序  <:倒序
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }
    
    public static void main(String[] args) {
		int[] array = new int[]{8,9,1,7,2,3,5,4,6,0};
		array = mergeSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
 	}
}