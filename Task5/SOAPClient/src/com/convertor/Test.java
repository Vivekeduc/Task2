package com.convertor;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import com.convertor.CurrencyConvertorStub.DollarToRupee;
import com.convertor.CurrencyConvertorStub.DollarToRupeeResponse;

public class Test {
	public static void main(String[] args) throws RemoteException{
		CurrencyConvertorStub convertorStub = new CurrencyConvertorStub();
		DollarToRupee dollarToRupee = new DollarToRupee();
		dollarToRupee.setNoOfRupee(200);
		DollarToRupeeResponse dollarToRupeeResponse=convertorStub.dollarToRupee(dollarToRupee);
		System.out.println(dollarToRupeeResponse.get_return());
		
	}
   
   
}
