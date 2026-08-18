package com.klef.soa.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klef.soa.entity.Product;
import com.klef.soa.repository.ProductRepository;
@Service
public class ProductImp implements ProductService {
	@Autowired
	private ProductRepository repo;
	
	@Override
	public Product addproduct(Product p) {
	return repo.save(p);
	}

	@Override
	public Product updatestock(Product p) {
		Optional<Product>optional=repo.findById(p.getId());
		if(optional.isPresent()) {
			Product product=optional.get();
			product.setStock(p.getStock());
			return repo.save(p);
		}
		else{
			return null;
		}
	}

	@Override
	public Product deleteProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findbycategory(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findbypricerange(int price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product sortbyprice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product searchbyname(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
