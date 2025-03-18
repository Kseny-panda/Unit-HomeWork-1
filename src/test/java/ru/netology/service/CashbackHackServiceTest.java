package ru.netology.service;

import org.testng.Assert;

import static org.testng.Assert.*;

public class CashbackHackServiceTest {

    CashbackHackService service = new CashbackHackService();

    // Нет товаров в корзине
    @org.testng.annotations.Test
    public void shouldWithoutPurchases() {

        Assert.assertEquals(service.remain(0), 1000);
    }

    // Минимальная покупка
    @org.testng.annotations.Test
    public void shouldMinPurchases() {

        Assert.assertEquals(service.remain(1), 999);
    }

    // Покупка в пределах границ
    @org.testng.annotations.Test
    public void shouldPurchaseWithinBorders() {

        Assert.assertEquals(service.remain(999), 1);
    }

    // Покупка по верхней минимальной границе для начисления кешбека
    @org.testng.annotations.Test
    public void shouldPurchaseUpperLimit() {

        Assert.assertEquals(service.remain(1000), 0);
    }

    // Покупка выше верхней границы минимальной покупки для начисления кешбека
    // для нового расчета программа предлагает добавить товар.
    @org.testng.annotations.Test
    public void shouldAboveUpperLimit() {

        Assert.assertEquals(service.remain(1001), 999);
    }
}