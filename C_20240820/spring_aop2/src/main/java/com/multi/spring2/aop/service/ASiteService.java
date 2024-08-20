package com.multi.spring2.aop.service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Component
public class ASiteService implements ASiteInterface {
    @Override
    public void task1() {
        // 실제 비즈니스 로직이 여기에 위치합니다.
        int[] numbers = new int[1000];
        /*코드 작성*/
        Random random = new Random();
        int sum = 0;

        // 랜덤한 값 만들어 배열에 넣은 후, 꺼내어 모두 더하여 출력하는 비지니스 로직
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100); // 0 ~ 99 사이의 랜덤 값 생성
            sum += numbers[i];
        }

        // 합계 출력
        System.out.println("Sum of all numbers: " + sum);

        try {
            Thread.sleep(3000); // 2초간 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void task2() {
        // 실제 비즈니스 로직이 여기에 위치합니다.
        // 큰 텍스트 문자열
        String largeText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                + "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
                + "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
                + "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. "
                + "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. "
                + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. ";

        // 특정 단어의 출현 빈도를 계산하기 위한 맵
        Map<String, Integer> wordCount = new HashMap<>();

        // 문자열 처리 및 단어 빈도 계산하여 가장 많이 출현한 단어와 그 빈도수를 출력하는 코드 작성
        /*코드 작성*/
        StringTokenizer st = new StringTokenizer(largeText, " .,;");
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        String mostWord = null;
        int maxCount = Collections.max(wordCount.values());

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == maxCount) {
                System.out.println("Most word : count =  " + entry.getKey() + " : " + maxCount);
            }
        }

        try {
            Thread.sleep(1000); // 1초간 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

