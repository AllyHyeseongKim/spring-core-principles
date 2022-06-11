package com.AllyHyeseongKim.core;

import com.AllyHyeseongKim.core.discount.DiscountPolicy;
import com.AllyHyeseongKim.core.discount.FixDiscountPolicy;
import com.AllyHyeseongKim.core.discount.RateDiscountPolicy;
import com.AllyHyeseongKim.core.member.MemberRepository;
import com.AllyHyeseongKim.core.member.MemberService;
import com.AllyHyeseongKim.core.member.MemberServiceImpl;
import com.AllyHyeseongKim.core.member.MemoryMemberRepository;
import com.AllyHyeseongKim.core.order.OrderService;
import com.AllyHyeseongKim.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
