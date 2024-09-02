package com.multi.spring2.young.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;


    public class ApiTest {

        public static void main(String[] args) {
            try {
                // API URL 설정
                String apiUrl = "https://apis.data.go.kr/4050000/apt/getApt?serviceKey=63Jk4KYSAeT0Kif97Z6jQm7H4vk6jMJSJ29jfJB4wMtKA%2FDfN7igbdpFRmXbS%2BfopaXmPMqvIhJWeVLeuy2DXw%3D%3D&pageNo=3&numOfRows=5";

                // URL 객체 생성
                URL url = new URL(apiUrl);

                // HttpURLConnection 객체 생성 및 설정
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

                // 응답 코드 확인
                int responseCode = conn.getResponseCode();
                System.out.println("Response Code: " + responseCode);

                // 응답 헤더에서 Content-Type 확인
                String contentType = conn.getContentType();
                String charset = "UTF-8"; // 기본값

                if (contentType != null && contentType.contains("charset=")) {
                    charset = contentType.split("charset=")[1];
                }

                // InputStreamReader와 BufferedReader로 응답 데이터 읽기
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                // 리소스 해제
                in.close();
                conn.disconnect();

                // URL 디코딩 (필요한 경우)
                String decodedResponse = URLDecoder.decode(response.toString(), charset);

                // Jackson을 사용하여 JSON 파싱
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(decodedResponse);

                // 콘솔에 파싱된 JSON 데이터를 예쁘게 출력
                System.out.println("Formatted JSON Response:");
                System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }