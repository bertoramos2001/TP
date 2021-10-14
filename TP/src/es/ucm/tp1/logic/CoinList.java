package es.ucm.tp1.logic;

public class CoinList {
	private Coin coins[];
	private static int numCoins;

	public CoinList(int arrLength) {
		coins = new Coin[arrLength];
		numCoins = 0;
	}
	
	public void add(Coin c) {
		coins[numCoins] = c;
		numCoins += 1;
	}
	
	public void deleteCoinList() {
		for(int i = 0; i < numCoins; i++)
		coins[i] = null;
		numCoins = 0;
	}
	
	public void remove(Coin c) {
		 Coin aux[] = new Coin[coins.length];
		 int i = 0;
		 for (Coin actualCoin : coins) {
			 if ((actualCoin != c) && (actualCoin != null)) {
				 aux[i] = actualCoin;
				 i += 1;
			 }
		 }
		 coins = aux;
		 numCoins = i;
	}
	
	public Coin getCoinInPosition(int x, int y) {
		for (int i = 0; i < numCoins; i++) {
			if (coins[i].getX() == x && coins[i].getY() == y) {
				return coins[i];
			}
		}
		return null;
	}
	
	public int getTotalCoins() {
		return numCoins;
	}

}
