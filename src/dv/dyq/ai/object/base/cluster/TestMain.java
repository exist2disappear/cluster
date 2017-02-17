package dv.dyq.ai.object.base.cluster;

import dv.dyq.ai.object.base.cluster.kmean.Kmean;
import dv.dyq.ai.object.base.cluster.sample.D2PointSample;

public class TestMain {
	
	public static void main(String[] args) {
		Kmean test = new Kmean(3);
		D2PointSample sample = new D2PointSample();
		test.setSamlpe(sample.sample);
		test.doCount();
	}

}
