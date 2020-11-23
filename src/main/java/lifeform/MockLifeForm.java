package lifeform;

/**
 * @author Adam Haertter - modified by Scott Bucher
 *
 */
public class MockLifeForm extends LifeForm {

  /**
   * Creates an instance of MockLifeForm, an object nearly identical to the
   * abstract class LifeForm. Mainly used for testing purposes
   * 
   * @param name   The name of the MockLifeForm
   * @param points The Health Points of the MockLifeForm
   */
  public MockLifeForm(String name, int points) {
    super(name, points);
    maxSpeed = 1;
  }

  /**
   * Creates an instance of MockLifeForm, an object nearly identical to the
   * abstract class LifeForm. Mainly used for testing purposes
   * 
   * @param name   The name of the MockLifeForm
   * @param points The Health Points of the MockLifeForm
   * @param atk    The Attack Strength of the MockLifeForm
   */
  public MockLifeForm(String name, int points, int atk) {
    super(name, points, atk);
    maxSpeed = 1;
  }

  /**
   * Prints "Mock"
   */
  public String toString() {
    return "Mock";
  }
}
