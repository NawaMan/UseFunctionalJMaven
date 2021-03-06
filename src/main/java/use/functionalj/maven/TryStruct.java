package use.functionalj.maven;

import static functionalj.list.FuncList.listOf;
import static use.functionalj.maven.Item.theItem;
import static use.functionalj.maven.Order.theOrder;

import java.math.BigDecimal;
import java.time.LocalDate;

import functionalj.list.FuncList;
import functionalj.types.Choice;
import functionalj.types.Nullable;
import functionalj.types.Struct;
import lombok.val;
import use.functionalj.maven.Buyer;
import use.functionalj.maven.Item;
import use.functionalj.maven.Order;
import use.functionalj.maven.SaleTax;

public class TryStruct {
    
    @Struct void Item(String name, @Nullable String description, BigDecimal price) {}
    
    @Struct void Buyer(String name, Province province, LocalDate date) {}
    
    @functionalj.types.Struct static interface OrderSpec {
        Buyer buyer();
        FuncList<Item> items();
        
        default BigDecimal total() {
            val province = buyer().province();
            val total = items ()
                    .sum   (theItem.price)
                    .map   (province::addTax)
                    .orElse(BigDecimal.ZERO);
            return total;
        }
    }
    
    enum Province {
        ON(SaleTax.HST   (13)),
        SK(SaleTax.GSTPST(5, 6));
        
        public final SaleTax saleTax;
        
        Province(SaleTax saleTax) {
            this.saleTax = saleTax;
        }
        public BigDecimal addTax(BigDecimal subTotal) {
            val taxPercent = saleTax.match()
                    .gstpst(tax -> tax.gstPercent() + tax.pstPercent())
                    .hst   (tax -> tax.percent());
            return subTotal.multiply(new BigDecimal(taxPercent)).divide(new BigDecimal(100));
        }
    }
    
    @Choice interface SaleTaxSpec {
        void GSTPST(int gstPercent, int pstPercent);
        void HST(int percent);
    }
    
    public static void main(String[] args) {
        val buyer1 = new Buyer("Smith",   Province.ON, LocalDate.of(2019, 3,  10));
        val buyer2 = new Buyer("Johnson", Province.SK, LocalDate.of(2019, 10,  3));
        val order1 = new Order(buyer1, listOf(
                new Item("iPad",  new BigDecimal(500)),
                new Item("Case",  new BigDecimal(20))
                ));
        val order2 = new Order(buyer2, listOf(
                new Item("MacBook", new BigDecimal(1300)),
                new Item("Cable",   new BigDecimal(20))
                ));
        val orders = listOf(order1, order2);
        System.out.println(orders);
        System.out.println(orders.filter(theOrder.buyer.province.thatEquals(Province.ON)));
        System.out.println(orders.groupingBy(theOrder.buyer.province));
        System.out.println(orders.map(Order::total));
        System.out.println(orders.groupingBy(theOrder.buyer.date.month));
    }
    
}
