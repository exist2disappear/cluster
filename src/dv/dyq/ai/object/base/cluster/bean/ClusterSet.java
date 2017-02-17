package dv.dyq.ai.object.base.cluster.bean;

import java.util.ArrayList;
import java.util.List;

import dv.dyq.ai.object.base.cluster.sample.D2PointSample;

public class ClusterSet {
	
	private static MeasureThing ZERO;
	List<MeasureThing> mumberList = new ArrayList<MeasureThing>();
	public ClusterSet(MeasureThing zero){
		ZERO = zero;
	}
	
	

	public void clearSet(){
		mumberList.clear();
	}
	
	public void print(){
		for(MeasureThing item:mumberList){			
			System.out.print(item.toString()+",");
		}
		System.out.println("");
	}
	
	public void add(MeasureThing thing){
		mumberList.add(thing);
	}
	
	public MeasureThing getSetMean(){
		if(mumberList== null ||mumberList.size()==0){
			return ZERO;
		}
		if(mumberList.size()==1){
			return mumberList.get(0);
		}
		if(mumberList.size()>1){
			MeasureThing mean = mumberList.get(0);
			for(int i = 1; i<mumberList.size();i++){
				mean = mean.add(mumberList.get(i));
			}
			return mean.muti(1.0f/mumberList.size());
		}
		return ZERO;
	}

}
