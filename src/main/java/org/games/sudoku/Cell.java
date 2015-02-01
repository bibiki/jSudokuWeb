package org.games.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author muzir
 * 
 */

public class Cell {

	public Cell() {
		this._initializeDomainList();
	}

	public Cell(Integer value) {
		this._value = value;
		this._initializeDomainList();
	}

	public Cell(Cell paramCell) {
		this._value = paramCell._value;
		this._initializeDomainList();
	}

	/*
	 * toString method of the Cell object (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String strResult = "";
		strResult = "'" + _value+"'";
		return strResult;
	}

	/**
	 * Choice a random number from cell domain list
	 * 
	 * @return
	 */
	public Integer getRandomChoice() {
		int randomIndex = -1;
		int listSize = this._domainList.size();
		if (listSize == 0) {
			return -1;
		}
		Random random = new Random();
		randomIndex = random.nextInt(listSize);
		return this._domainList.get(randomIndex);
	}

	/**
	 * Clear domain list and initialize the list again
	 */
	public void clearDomainList() {
		this._domainList.clear();
		this._initializeDomainList();
	}

	/**
	 * Initialize domain list between 1..9
	 */
	private void _initializeDomainList() {
		for (int i = 1; i < 10; i++) {
			_domainList.add(i);
		}// end of for loop
	}

	public List<Integer> get_domainList() {
		return _domainList;
	}

	public void set_domainList(List<Integer> _domainList) {
		this._domainList = _domainList;
	}

	public Integer get_value() {
		return _value;
	}

	public void set_value(Integer _value) {
		this._value = _value;
	}

	private Integer _value = 0;
	private List<Integer> _domainList = new ArrayList<Integer>(10);
}
