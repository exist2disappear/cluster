package dv.dyq.ai.object.base.cluster.kmean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dv.dyq.ai.object.base.cluster.bean.ClusterSet;
import dv.dyq.ai.object.base.cluster.bean.MeasureThing;
import dv.dyq.ai.object.base.cluster.sample.D2PointSample;

public class Kmean {
	private int kValue;
	private List<MeasureThing> mSample;
	List<ClusterSet> setList;
	List<MeasureThing> mean;
	List<MeasureThing> lastmean;
	Random rand = new Random();
	
	public Kmean(int k){
		if(k<= 0){
			System.out.println("k<= 0");
			return;
		}
		kValue = k;
		lastmean = new ArrayList<MeasureThing>(kValue);
		mean = new ArrayList<MeasureThing>(kValue);
		setList = new ArrayList<ClusterSet>(kValue);
		for(int i=0;i<kValue;i++){
			setList.add(new ClusterSet(D2PointSample.ZERO));
		}
	}
	
	public void setSamlpe(List<MeasureThing> sample){
		mSample = sample;
	}
	
	public void doCount(){
		if(mSample == null || mSample.size() < kValue){
			System.out.println("sample < kValue");
			return;
		}
		float besterr = Integer.MAX_VALUE;
		List<MeasureThing> bestmean = new ArrayList<MeasureThing>();
		//init;换初始值
		for(int time = 0;time<50;time++){
			
			int tryTime = 0;
			lastmean.clear();
			mean.clear();
			for(int i=0;i<kValue;i++){
				
				mean.add(mSample.get(rand.nextInt(mSample.size()-1)));
			}
			
			float err = 0.0f;
			while(!isSame(lastmean, mean)){
				err= 0.0f;
				lastmean.clear();
				for (int i=0;i<mean.size();i++){
					lastmean.add(mean.get(i));
					setList.get(i).clearSet();
				}
				for(MeasureThing sample:mSample){
					int minSetIndex = 0;
					float minDistence = sample.getDistence(mean.get(0));
//				System.out.println("point :"+ sample+"to index : 0 is :"+sample.getDistence(mean.get(0)));
					for(int i=1;i<mean.size();i++){
//					System.out.println("point :"+ sample+"to index : "+i+" is :"+sample.getDistence(mean.get(i)));
						if(minDistence>sample.getDistence(mean.get(i))){
							minDistence = sample.getDistence(mean.get(i));
							minSetIndex = i;
						}
					}
//				System.out.println("point :"+ sample+" put to index"+minSetIndex);
					setList.get(minSetIndex).add(sample);
					err += minDistence;
				}
				
				mean.clear();
				for(ClusterSet set:setList){
					mean.add(set.getSetMean());
					System.out.print(set.getSetMean()+",");
				}
				tryTime++;
//				System.out.println("tryTime :"+ tryTime);
//				System.out.println("err :"+ err);
			}
			
			//show
			System.out.println("err :"+ err);
			for(ClusterSet set:setList){
				set.print();
			}
			if(besterr>err){
				besterr = err;
				bestmean.clear();
				for(MeasureThing item:mean){
					bestmean.add(item);
				}
			}
		}
		System.out.println("err :"+ besterr);
		for(MeasureThing item:bestmean){
			System.out.print(item+",");
		}
		
	}
	private boolean isSame(List<MeasureThing> a,List<MeasureThing> b){
		if(a != null && b!= null && a.size() == b.size()){
			for (int i=0;i<a.size();i++){
				if(!a.get(i).isSameThing(b.get(i))){
					return false;
				}
			}
			return true;
		}
		return false;
	}

}
