package com.AllyHyeseongKim.core.order;

import com.AllyHyeseongKim.core.annotation.MainDiscountPolicy;
import com.AllyHyeseongKim.core.discount.DiscountPolicy;
import com.AllyHyeseongKim.core.discount.FixDiscountPolicy;
import com.AllyHyeseongKim.core.discount.RateDiscountPolicy;
import com.AllyHyeseongKim.core.member.Member;
import com.AllyHyeseongKim.core.member.MemberRepository;
import com.AllyHyeseongKim.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
