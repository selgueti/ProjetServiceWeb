package fr.uge.projet.change;

public class ChangeService {
	public long change(String currencySrc, String currencyDest, long amount) {
		return (long) (amount*1.23);
	}
}
