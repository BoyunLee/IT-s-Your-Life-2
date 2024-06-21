package C_20240618;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {

        // 1. 두 개의 정수 배열을 생성 첫 번째 배열은 1에서 50 사이의 랜덤 값 10개 두 번째 배열은 51에서 100 사이의 랜덤 값 10개
        Random rand = new Random();
        int[] A = new int[10];
        int[] B = new int[10];
        for (int i = 0; i < A.length; i++) {
            A[i] = rand.nextInt(50) + 1;
        }
        for (int i = 0; i < B.length; i++) {
            B[i] = rand.nextInt(50) + 51;
        }
        System.out.println("배열 1 : " + Arrays.toString(A));
        System.out.println("배열 2 : " + Arrays.toString(B));

        // 2. 두 배열을 하나로 합친 후, 합친 배열의 중복 값을 제거
        Set<Integer> mergedSet = new HashSet<>();
        for (int num : A) {
            mergedSet.add(num);
        }
        for (int num : B) {
            mergedSet.add(num);
        }
        System.out.println("중복 값 제거된 배열 : " + mergedSet);

        // 3. 중복 값이 제거된 배열을 오름차순으로 정렬
        List<Integer> sortedList = new ArrayList<>(mergedSet);
        Collections.sort(sortedList);

        System.out.println("오름차순 정렬된 배열 : " + sortedList);

        // 4. 정렬된 배열에서 최대값과 최소값을 찾아 출력
        Integer[] arr = sortedList.toArray(new Integer[0]);
        int max = arr[arr.length - 1];
        int min = arr[0];
        System.out.println("최대값 : " + max);
        System.out.println("최소값 : " + min);

        // 5. 최대값과 최소값의 위치(인덱스)를 출력
        int maxIndex = Arrays.binarySearch(arr, max);
        int minIndex = Arrays.binarySearch(arr, min);

        System.out.println("최대값의 위치 : " + maxIndex);
        System.out.println("최소값의 위치 : " + minIndex);


    }
}
