package dv.dyq.ai.object.base.cluster.bean;



public class D2Pint implements MeasureThing{
	public float mX;
	public float mY;
	public final static  D2Pint ZERO = new D2Pint(0f,0f);
	public D2Pint(float x,float y){
		mX = x;
		mY = y;
	}
	
	@Override
	public String toString() {
		
		return "("+mX+","+mY+")";
	}

	@Override
	public float getDistence(MeasureThing other) {
		if(other instanceof D2Pint){
			D2Pint point = (D2Pint)other;
			return (float)Math.sqrt((mX-point.mX)*(mX-point.mX)+(mY-point.mY)*(mY-point.mY));
		}else{
			return Float.MAX_VALUE;
		}
	}

	@Override
	public MeasureThing add(MeasureThing other) {
		if(other instanceof D2Pint){
			
			return new D2Pint(mX+((D2Pint)other).mX,mY+((D2Pint)other).mY);
		}
		return this;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof D2Pint){
			return (mX==((D2Pint)obj).mX)&&(mY==((D2Pint)obj).mY);
		}
		return false;
	}

	@Override
	public boolean isSameThing(MeasureThing other) {
		if(other instanceof D2Pint){
			return (mX==((D2Pint)other).mX)&&(mY==((D2Pint)other).mY);
		}
		return false;
	}

	@Override
	public MeasureThing muti(float x) {
		
		return new D2Pint(mX*x, mY*x);
	}

	@Override
	public MeasureThing getZero() {
		
		return ZERO;
	}

}
