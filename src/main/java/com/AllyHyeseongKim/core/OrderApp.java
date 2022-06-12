package com.AllyHyeseongKim.core;

import com.AllyHyeseongKim.core.member.Grade;
import com.AllyHyeseongKim.core.member.Member;
import com.AllyHyeseongKim.core.member.MemberService;
import com.AllyHyeseongKim.core.member.MemberServiceImpl;
import com.AllyHyeseongKim.core.order.Order;
import com.AllyHyeseongKim.core.order.OrderService;
import com.AllyHyeseongKim.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
//        MemberService memberService = new MemberServiceImpl(null);
//        OrderService orderService = new OrderServiceImpl(null, null);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
    }
}
