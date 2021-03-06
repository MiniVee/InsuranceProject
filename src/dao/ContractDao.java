package dao;

import java.util.ArrayList;

import entity.Contract;

public interface ContractDao {
	public boolean add(Contract contract);
	public boolean delete(Contract contract);
	public Contract search(String clientID, String productName);
	public ArrayList<Contract> searchByClient(String clientID);
	public ArrayList<Contract> searchBySalesPerson(String salesPerson);
	public boolean update(Contract contract);
	public ArrayList<Contract> findAll();
}