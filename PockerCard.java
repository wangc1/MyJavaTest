package cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PockerCard {
	private List<SingleCard> allCard =new ArrayList<>(52);
	
	public PockerCard() {
		this.init();
		this.printallorder();
	}
	
	public void init(){
		for (int i = 1; i <5; i++) {
			allCard.add(new SingleCard('2', i));
			allCard.add(new SingleCard('0', i));
			allCard.add(new SingleCard('J', i));
			allCard.add(new SingleCard('Q', i));
			allCard.add(new SingleCard('K', i));
			allCard.add(new SingleCard('A', i));
			for (int j = 51; j <=57 ; j++) {
				allCard.add(new SingleCard((char)j, i));
			}
		}	
	}
	

	public List<SingleCard> xipai() {
		int count=0;
		int k;
		this.resetflag();
		List<SingleCard> temp=allCard;
		while (count==temp.size()) {
			for (SingleCard singleCard : temp) {
				k=findposition(singleCard,temp);
				if (temp.get(k).flag==0&&singleCard.flag==0) {
				swaps(temp.indexOf(singleCard),k,temp);
				for (SingleCard singleCard1 : temp) {
					if (singleCard1==temp.get(k)||singleCard1==singleCard) {
						singleCard1.flag=1;
						count++;
					}
				}
			}
					
				if (count==temp.size()) {
					break;
						
				}
			}
		}
		return temp;
	}
	
	public List<SingleCard> fapai() {
		return allCard;
	}
	
	public void printall() {
		for (SingleCard singleCard : allCard) {
			singleCard.print();
		}
	}
	public void printallorder() {
		this.resetflag();
		int count=0;
		SingleCard singleCard=null;
		SingleCard max=null;
		while(count<allCard.size()) {
			max=new SingleCard('3', 1);
			for (int i=0;i<allCard.size();i++) {
				singleCard=allCard.get(i);
				if (((singleCard.compareTo(max))>0)&&(singleCard.flag==0)) {
					max=singleCard;
				}
			}
			for (SingleCard singleCard2 : allCard) {
				if (singleCard2.compareTo(max)==0) {
					singleCard2.flag=1;
				}
			}
			max.print();
			count++;
		}
	}
	public void resetflag() {
		for (SingleCard singleCard : allCard) {
			singleCard.flag=0;
		}
	}
	
	public int findposition(SingleCard iCard,List<SingleCard> temps ) {
		Random newrandom=new Random();
		int k;
		for (;;) {
			k=newrandom.nextInt(52);
			if (k==temps.indexOf(iCard)) {
				continue;
			}else if (temps.get(k).flag==1) {
				continue;
			}else {
				return k;
			}
		}
	}
	//swap the singcard number and color
	public void swaps(int k,int j,List<SingleCard> temp) {
		char temp1;
		int temp2;
		//ocard=k tcard=j
		temp1=temp.get(k).getaCard();
		temp.get(k).setaCard(temp.get(j).getaCard());
		temp.get(j).setaCard(temp1);
		
		temp2=temp.get(k).getCardColor();
		temp.get(k).setCardColor(temp.get(j).getCardColor());
		temp.get(j).setCardColor(temp2);
	}
	
}
