package shop.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeService {
	
	@Autowired
	TypeRepository typeRepository;
	
	public void saveType(Type type) {
		typeRepository.save(type);
	}
	
	public Type findByName(String name) {
		return typeRepository.findByName(name);
	}
}
