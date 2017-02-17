package dv.dyq.ai.object.base.cluster.sample;


import java.util.ArrayList;
import java.util.List;

import dv.dyq.ai.object.base.cluster.bean.D2Pint;
import dv.dyq.ai.object.base.cluster.bean.MeasureThing;

public class D2PointSample {
	public final  static D2Pint ZERO = new D2Pint(0,0);
	public  List<MeasureThing> sample = new ArrayList<MeasureThing>();
	public D2PointSample(){
		init1();
	}
	
	public void init1(){
		sample.add(new D2Pint(2,1));
		
		sample.add(new D2Pint(2,5));
		sample.add(new D2Pint(2,7));
		sample.add(new D2Pint(1,7));
		sample.add(new D2Pint(1,5));
		sample.add(new D2Pint(1,6));
		sample.add(new D2Pint(1.5f,6));
		sample.add(new D2Pint(1.5f,6.5f));
		sample.add(new D2Pint(3.5f,1));
		sample.add(new D2Pint(3,1));
		sample.add(new D2Pint(3,2));
		sample.add(new D2Pint(6,2));
		sample.add(new D2Pint(7,1));
		sample.add(new D2Pint(7,3));
		sample.add(new D2Pint(8,4));
		sample.add(new D2Pint(1,5.5f));
		sample.add(new D2Pint(8,3f));
		
	}
	

}
