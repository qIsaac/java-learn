package com.isaac.pattern.proxy;



/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 10:06 2018/7/24
 *
 *
 * Proxy is applicable whenever there is a need for a more versatile or sophisticated reference to an object than a simple pointer. Here are several common situations in which the Proxy pattern is applicable
 *      1.Remote proxy provides a local representative for an object in a different address space.
 *      2.Virtual proxy creates expensive objects on demand.
 *      3.Protection proxy controls access to the original object. Protection proxies are useful when objects should have different access rights.
 */
public class App {
    public static void main(String[] args) {
        WizardTowerProxy proxy = new WizardTowerProxy(new IvoryTower());
        proxy.enter(new Wizard("Red wizard"));
        proxy.enter(new Wizard("White wizard"));
        proxy.enter(new Wizard("Black wizard"));
        proxy.enter(new Wizard("Green wizard"));
        proxy.enter(new Wizard("Brown wizard"));
    }
}
