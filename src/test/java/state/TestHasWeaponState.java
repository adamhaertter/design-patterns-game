package state;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import environment.Environment;
import exceptions.WeaponException;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import weapon.MockWeapon;
import weapon.Pistol;
import weapon.Weapon;

public class TestHasWeaponState {
  @Test
  public void testNoTarget() throws WeaponException {
    LifeForm lf = new MockLifeForm("Terry", 20);
    Environment env = new Environment(5, 5);
    AIContext context = new AIContext(lf, env);
    Weapon weapon = new MockWeapon();

    lf.pickUpWeapon(weapon);
    weapon.fire(5);
    assertEquals(context.getCurrentState(), context.getHasWeaponState());
  }

  @Test
  public void testSameType() {
    Human terry = new Human("Terry", 20, 0);
    Human jerry = new Human("Jerry", 20, 0);
    Environment env = new Environment(5, 5);
    env.addLifeForm(terry, 3, 3);
    env.addLifeForm(jerry, 2, 3);
    AIContext context = new AIContext(terry, env);
    Pistol weapon = new Pistol();

    terry.attack(jerry, 1);
    assertEquals(jerry.getCurrentLifePoints(), 20);
  }

  @Test
  public void testDifferentType() {
    Human terry = new Human("Terry", 20, 10);
    Alien jerry = new Alien("Jerry", 20);
    Environment env = new Environment(5, 5);
    env.addLifeForm(terry, 3, 3);
    env.addLifeForm(jerry, 2, 3);
    AIContext context = new AIContext(terry, env);
    Pistol weapon = new Pistol();

    terry.attack(jerry, 1);
    assertEquals(jerry.getCurrentLifePoints(), 15);
  }

  @Test
  public void testOneShotLeft() throws WeaponException {
    Human terry = new Human("Terry", 20, 10);
    Alien jerry = new Alien("Jerry", 20);
    Environment env = new Environment(5, 5);
    env.addLifeForm(terry, 3, 3);
    env.addLifeForm(jerry, 2, 3);
    AIContext context = new AIContext(terry, env);
    Pistol weapon = new Pistol();

    weapon.fire(1);
    weapon.fire(1);
    weapon.fire(1);
    weapon.fire(1);
    weapon.fire(1);
    weapon.fire(1);
    weapon.fire(1);
    weapon.fire(1);
    weapon.fire(1);

    terry.attack(jerry, 1);
    assertEquals(jerry.getCurrentLifePoints(), 15);
  }

  @Test
  public void testOutOfRange() {
    Human terry = new Human("Terry", 20, 10);
    Alien jerry = new Alien("Jerry", 20);
    Environment env = new Environment(600, 5);
    env.addLifeForm(terry, 599, 3);
    env.addLifeForm(jerry, 2, 3);
    AIContext context = new AIContext(terry, env);
    Pistol weapon = new Pistol();

    terry.attack(jerry, 597);
    assertEquals(jerry.getCurrentLifePoints(), 20);
  }

  @Test
  public void testIfDead() {
    Human terry = new Human("Terry", 20, 10);
    Alien jerry = new Alien("Jerry", 20);
    Environment env = new Environment(5, 5);
    env.addLifeForm(terry, 3, 3);
    env.addLifeForm(jerry, 2, 3);
    AIContext context = new AIContext(terry, env);
    Pistol weapon = new Pistol();

    terry.takeHit(20);
    terry.attack(jerry, 1);
    assertEquals(jerry.getCurrentLifePoints(), 15);
  }
}
