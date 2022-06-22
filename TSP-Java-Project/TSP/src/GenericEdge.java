
public class GenericEdge<T> {
	
	T from;
	T to;
	int cost;
	boolean visted;

	public boolean isVisted() {
		return visted;
	}
	public void setVisted(boolean visted) {
		this.visted = visted;
	}
	public GenericEdge()
	{
		this.from=null;
		this.to=null;
		this.cost=0;
		this.visted=false;
	}
	public GenericEdge(T token,T token2,int weight, boolean T )
	{
		this.from= token;
		this.to=token2;
		this.cost=weight;
		this.visted=T;
	}
	
	public GenericEdge(T token,int weight)
	{
		this.to=token;
		this.cost=weight;
		
	}
	public T getFrom() {
		return from;
	}

	public void setFrom(T from) {
		this.from = from;
	}

	public T getTo() {
		return to;
	}

	public void setTo(T to) {
		this.to = to;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	

}
