package com.isaac.pattern.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 10:14 2018/7/24
 */
@Slf4j
public class WizardTowerProxy implements WizardTower {

    private static final int NUM_WIZARD_ALLOWED = 3;

    private int numWizard;

    private final WizardTower wizardTower;

    public WizardTowerProxy(WizardTower wizardTower) {
        this.wizardTower = wizardTower;
    }


    @Override
    public void enter(Wizard wizard) {
        if (numWizard < NUM_WIZARD_ALLOWED) {
            wizardTower.enter(wizard);
            numWizard ++;
        } else {
            log.info("{} is not allowed to enter!", wizard);
        }
    }

}
