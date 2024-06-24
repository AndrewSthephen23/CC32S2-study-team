package org.example;

interface TowerFactory {
    Tower createTower();
}

class CannonTowerFactory implements TowerFactory {
    @Override
    public Tower createTower() {
        return new CannonTower();
    }
}

class LaserTowerFactory implements TowerFactory {
    @Override
    public Tower createTower() {
        return new LaserTower();
    }
}

class ArrowTowerFactory implements TowerFactory {
    @Override
    public Tower createTower() {
        return new ArrowTower();
    }
}
