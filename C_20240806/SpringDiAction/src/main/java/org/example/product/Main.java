package org.example.product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // XML 설정 파일을 기반으로 스프링 컨텍스트를 초기화합니다.
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Customer 빈을 가져옵니다.
        Customer customer = context.getBean("customer", Customer.class);

        // 상품을 장바구니에 추가합니다.
        Product product1 = context.getBean("product1", Product.class);
        Product product2 = context.getBean("product2", Product.class);

        customer.addProductToCart(product1);
        customer.addProductToCart(product2);

        // 결제 처리를 수행합니다.
        customer.checkout();
    }
}
