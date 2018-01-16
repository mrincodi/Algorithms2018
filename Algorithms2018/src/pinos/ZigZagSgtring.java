package pinos;

public class ZigZagSgtring {

	public String convert(String A, int B) {
		StringBuffer  [] buffers = new StringBuffer [ B ];

		for ( int i = 0; i < B; i ++){
			buffers[i] = new StringBuffer();
		}

//		StringBuffer resultBuffer = new StringBuffer();
//		int index = 0;
//		int nextStep = 1;
//		for ( int i = 0; i < A.length(); i++ ){
//			buffers[index].append (A.charAt (i));
//			index += nextStep;
//			if (index == B){
//				nextStep *= -1;
//				index = index + nextStep;
//			}
//		}
//
//		for ( int i = 0; i < B; i++){
//			resultBuffer.append (buffers[i].toString());
//		}
	//	return resultBuffer.toString();
return null;


	}

	public static void main(String[] args) {
		String s = "HOLA123";
		String r = new ZigZagSgtring().convert(s, 3);
		System.out.println (r);

	}

}
