package comm.example.dao;

import java.util.List;

import comm.example.model.Login;

public interface TodoDAO {
	public List<Login> getCred(String uName);

}
