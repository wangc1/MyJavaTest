package cardgame;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		PockerCard pockerCard =new PockerCard();
		List<SingleCard> all=pockerCard.xipai();
		System.out.println();
		for (SingleCard singleCard : all) {
			singleCard.print();
		}
	}

}
