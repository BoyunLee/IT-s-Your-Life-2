package com.multi.spring2.webSocket.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//서버에서 받은 데이터를 채팅창에 들어와 있는 멤버 브라우저에게
//보낼 데이터를 넣을 vo ==>messageBroker가 json으로 만들어서 브라우저에 보낸다.
//@sendTo("topic/messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputMessage2 {

        private String from;
        private String text;
        private String menu;
}