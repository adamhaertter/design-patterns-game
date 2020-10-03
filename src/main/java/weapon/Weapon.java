package weapon;

import gameplay.TimerObserver;

/**
 * @author Brennan Mulligan
 * 
 */
public interface Weapon extends TimerObserver {
  
  public int fire(int distance) throws WeaponException;
  
  public int getBaseDamage();
  
  public int getCurrentAmmo();
  
  public int getMaxAmmo();
  
  public int getMaxRange();
  
  public int getRateOfFire();
  
  public int getShotsLeft();
  
  public void reload();
  
  public String toString();
}