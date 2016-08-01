package cardgame;

public class SingleCard implements Comparable<SingleCard>{
	private char aCard;
	//4 是黑桃  3是红桃  2是梅花 1是方片
	private int cardColor;
	int flag=0;
	
	
	public SingleCard(char aCard,int cardColor) {
		this.aCard=aCard;
		this.cardColor=cardColor;
	}
	
	public char getaCard() {
		return aCard;
	}


	public int getCardColor() {
		return cardColor;
	}
	
	public void setaCard(char aCard) {
		this.aCard=aCard;
	}
	
	public void setCardColor(int color) {
		this.cardColor=color;
	}
	
	public boolean cardcompare(char o) {
		if (this.aCard=='2') {
			return true;
		}else if (this.aCard=='A') {
			if (o=='2') {
				return false;
			}else {
				return true;
			}
			//0当10，q要放出来
		}else if (this.aCard=='K') {
			if (o=='2') {
				return false;
			}else if (o=='A') {
				return false;
			}else {
				return true;
			}
		}else if (this.aCard=='Q') {
			if (o=='2') {
				return false;
			}else if (o=='A') {
				return false;
			}else if(o=='K'){
				return false;
			}else {
				return true;
			}
		}else if (this.aCard=='J') {
			if (o=='2') {
				return false;
			}else if (o=='A') {
				return false;
			}else if (o=='K') {
				return false;
			}else if (o=='Q') {
				return false;
			}else {
				return true;
			}
		}else if (this.aCard=='0') {
			if (o=='2') {
				return false;
			}else if (o=='A') {
				return false;
			}else if (o=='K') {
				return false;
			}else if (o=='Q') {
				return false;
			}else if (o=='J') {
				return false;
			}else{
				return true;
			}
		
		}else {
			if (o=='2') {
				return false;
			}else if (o=='A') {
				return false;
			}else if (o=='K') {
				return false;
			}else if (o=='Q') {
				return false;
			}else if (o=='J') {
				return false;
			}else if (o=='0'){
				return false;
			}else {
				return this.aCard>o?true:false;
			}
		}
	}


	@Override
	public int compareTo(SingleCard o) {
		if (this.getaCard()==o.getaCard()) {
			if (this.getCardColor()>o.getCardColor()) {
				return 1;
			}else if(this.getCardColor()==o.getCardColor()){
				return 0;
			}else {
				return -1;
			}
		}else if(this.cardcompare(o.getaCard())){
			return 1;
		}else {
			return -1;
		}
	}
	public String cardcolors() {
		if (this.cardColor==4) {
			return "黑桃";
		}else if (this.cardColor==3) {
			return "红桃";
		}else if (this.cardColor==2) {
			return "梅花";
		}else if (this.cardColor==1) {
			return "方片";
		}else {
			return null;
		}
	}
	public void print() {
		String colors=this.cardcolors();
		if (colors==null||colors=="") {
			System.out.print("i dont know what it is maybe it's a bug");
		}else if (this.aCard!='0') {
			System.out.print(""+colors+this.aCard+" ");
		}else {
			System.out.print(colors+"10"+" ");
		}
		
	}
	
}
