package project.code01.supermarket;
import project.code01.supermarket.impl.SimpleShopman;
import project.code01.supermarket.interfaces.Customer;
import project.code01.supermarket.interfaces.Shopman;
import project.code01.supermarket.interfaces.SuperMarket;

import static project.code01.supermarket.util.ShoppingUtil.*;

public class ShoppingMainControl {
    public static void main(String[] args) {
        SuperMarket superMarket = createSuperMarket();

        Shopman shopman = new SimpleShopman(superMarket);

        boolean open = true;
        while (open) {
            new ShoppingTask(shopman).executeTask();
            output("是否继续营业？(Yes)");
            open = ! input().next().trim().equalsIgnoreCase("no");
        }

        superMarket.dailyReport();
    }

}

class ShoppingTask {

    private Shopman shopman;

    public ShoppingTask(Shopman shopman) {
        this.shopman = shopman;
    }

    public void executeTask() {
        Customer customer = createCustomer(true);

        shopman.serveCustomer(customer);

    }

}
