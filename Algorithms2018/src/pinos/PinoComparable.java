package pinos;

public class PinoComparable implements java.lang.Comparable <PinoComparable>{

	String value;
	
	public PinoComparable (String v){
		this.value=v;
	}
	
	public static void main(String[] args) {
		PinoComparable a = new PinoComparable("abc");
		PinoComparable b = new PinoComparable("def");
		
		System.out.println(a.compareTo(b));

	}

	@Override
	public int compareTo(PinoComparable s) {
		return this.value.compareTo(s.value);
	}

	
}
