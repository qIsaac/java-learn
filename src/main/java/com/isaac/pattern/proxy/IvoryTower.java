package com.isaac.pattern.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 13:37 2018/7/24
 */
@Slf4j
public class IvoryTower implements WizardTower {
    @Override
    public void enter(Wizard wizard) {
        log.info("{} enters the tower.", wizard);
    }
}
