package dv.dyq.ai.object.base.cluster.bean;

public interface MeasureThing {
	
	float getDistence(MeasureThing other);//有可泛化的距离
	MeasureThing add(MeasureThing other);//线性可加的完备集
	MeasureThing muti(float x);//数乘
	boolean isSameThing(MeasureThing other);//可比性（默认有“0” 归零）
	MeasureThing getZero();

}
