package C_20240618;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[20];

        // 1. 랜덤한 값 1부터 100 사이의 값을 20개 만들어 배열에 넣어 출력
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100) + 1;
        }
        System.out.println("Original Array : " + Arrays.toString(array));

        // 2. 배열에 들어있는 값의 최대값을 찾아 출력
        int max = array[0];
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
        }
        System.out.println("Maximum Value : " + max);

        // 3. 배열에 들어가 있는 값 중 최대값이 들어있는 위치를 출력
        System.out.println("Index of Maximum Value : " + maxIndex);

        // 4. 배열에 있는 값들을 오름차순으로 정렬
        Arrays.sort(array);
        System.out.println("Array in Ascending Order : " + Arrays.toString(array));

        // 5. 오름차순으로 정렬한 값들을 내림차순으로 정렬하기 위해 위치를 변경(Reverse)
        reverseArray(array);
        System.out.println("Array in Descending Order : " + Arrays.toString(array));

        // 6. 값들의 중복이 제거된 값들의 목록과 개수를 출력
        Set<Integer> uniqueValues = new LinkedHashSet<>();
        for (int value : array) {
            uniqueValues.add(value);
        }
        System.out.println("Unique Values : " + uniqueValues);
        System.out.println("Count of Unique Values : " + uniqueValues.size());
    }

    // 배열을 뒤집는 메소드
    public static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}