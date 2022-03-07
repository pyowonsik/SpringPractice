package hello.core.order;

// 주문 서비스
public interface OrderService {
    Order createOrder(Long memberId,String itemName,int itemPrice);

}
