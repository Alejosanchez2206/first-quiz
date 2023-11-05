package org.velezreyes.quiz.question6;

public class VendingMachineImpl {
  public static VendingMachine getInstance() {
    void insertCoin(int valueInCents);
    Drink getDrink(String drinkName) throws NotEnoughMoneyException, UnknownDrinkException;
    return null;
  }
}
public class ScottCola implements Drink {
    private boolean fizzy = true;

    @Override
    public boolean isFizzy() {
        return fizzy;
    }
}

public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}

public class UnknownDrinkException extends Exception {
    public UnknownDrinkException(String message) {
        super(message);
    }
}

public class KarenTea implements Drink {
    private int costInCents = 100; // Costo superior a 75 centavos
    private boolean fizzy = false;

    @Override
    public boolean isFizzy() {
        return fizzy;
    }
}

public class VendingMachineImpl implements VendingMachine {
    private int insertedCoins = 0;
    private Drink currentDrink = null;

    @Override
    public void insertCoin(int valueInCents) {
        insertedCoins += valueInCents;
    }

    @Override
    public Drink getDrink(String drinkName) throws NotEnoughMoneyException, UnknownDrinkException {
        if ("ScottCola".equals(drinkName)) {
            if (insertedCoins < 3 * 25) {
                throw new NotEnoughMoneyException("Not enough money for ScottCola.");
            }
            currentDrink = new ScottCola();
            insertedCoins -= 3 * 25;
        } else if ("KarenTea".equals(drinkName)) {
            if (insertedCoins < 75) {
                throw new NotEnoughMoneyException("Not enough money for KarenTea.");
            }
            currentDrink = new KarenTea();
            insertedCoins -= 75;
        } else {
            throw new UnknownDrinkException("Unknown drink: " + drinkName);
        }
        return currentDrink;
    }

    @Override
    public void reset() {
        insertedCoins = 0;
        currentDrink = null;
    }
}
