import org.jsoup.Connection;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import java.io.IOException;

public class Q1 {
    public static void main(String[] args) throws IOException {
        String site = "https://finance.naver.com/item/main.nhn?code=005930";
        Connection con = Jsoup.connect(site);
        System.out.println("1. 사이트 연결 성공");

        Document doc = con.get();
        System.out.println("2. 연결된 사이트에서 문서를 다 가지고 오기 성공");
        System.out.println("3. 내용 =========================");
        System.out.println(doc);

        System.out.println("4. 전체문서 중에서 원하는 정보를 추출");

        System.out.println("Code : " + doc.select("span.code").text());
        System.out.println("Company Name : " + doc.select(".wrap_company a").text());
        System.out.println("Open Price : " + doc.select("p.no_today .blind").text());
        System.out.println("High Price : " + doc.select("td:not(.first) em.no_up .blind").text());

    }
}
