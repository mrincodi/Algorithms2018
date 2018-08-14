package pino_generics;

public class MyGen <QQ>{
	QQ qq;

	MyGen ( QQ rr ){
		this.qq=rr;
	}

	String whatAmIUsing (){
		return qq.getClass().getName();
	}

	QQ actualObjectUsed (){
		return qq;
	}
}
