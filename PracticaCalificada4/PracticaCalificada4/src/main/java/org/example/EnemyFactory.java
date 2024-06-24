package org.example;

interface EnemyFactory {
    Enemy createEnemy();
}

class BasicEnemyFactory implements EnemyFactory {
    @Override
    public Enemy createEnemy() {
        return new BasicEnemy();
    }
}

class FastEnemyFactory implements EnemyFactory {
    @Override
    public Enemy createEnemy() {
        return new SpeedyEnemy();
    }
}

class BossEnemyFactory implements EnemyFactory {
    @Override
    public Enemy createEnemy() {
        return new BossEnemy();
    }
}
