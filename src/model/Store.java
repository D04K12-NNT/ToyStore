package model;

import java.util.List;

public interface Store {

	public void insertProduct(Toy item) throws Exception;

	public Toy searchProductByCode(String code) throws Exception;

	public List<Toy> orderByASC() throws Exception;

	public List<Toy> listExpiration() throws Exception;
}
