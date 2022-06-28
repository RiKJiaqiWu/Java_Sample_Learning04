package project.code01.supermarket.impl;
import project.code01.supermarket.interfaces.Card;
import project.code01.supermarket.interfaces.Customer;
import project.code01.supermarket.interfaces.ShoppingCart;

public class CashCard implements Card{
    private double point;

    public CashCard(double point) {
        this.point = point;
    }

    @Override
    public double processCardDiscount(double totalCost, double totalCostAfterDiscount,
                                      Customer customer, ShoppingCart shoppingCart) {
        // 如果折扣下来剩下的钱比点数少，那么就抵扣掉需要付的剩下的钱
        if (totalCostAfterDiscount < point) {
            point -= totalCostAfterDiscount;
            return totalCostAfterDiscount;
        } else {
            // 否则就抵扣掉所有的点
            point = 0;
            return point;
        }
    }

}
