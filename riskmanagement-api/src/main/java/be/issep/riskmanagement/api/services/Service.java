package be.issep.riskmanagement.api.services;

import java.util.List;

public interface Service<T, D, K> {
	
	public T get(K id);
	
	public List<T> all();
	
	public T add(D dto);
	
	public void delete(K id);
}
