package TestData;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import ConstantsData.ConstantData;
import Utilities.CommonFunctions;
import Utilities.FetchDataFromExcel;

public class TestDataExcel {
	
	public static Map getDataFromExcel() throws IOException
	{
		FetchDataFromExcel obj=new FetchDataFromExcel(ConstantData.ExcelDataPath1,ConstantData.SheetName);
		
		Map<String,Object> mp=new LinkedHashMap<String,Object>();
		mp.put("name",FetchDataFromExcel.getData(1, 0));
		mp.put("gender",FetchDataFromExcel.getData(1, 1));
		mp.put("status",FetchDataFromExcel.getData(1, 2));
		mp.put("email",CommonFunctions.getRandomEmail());
		
		return mp;
		
		
		
	}
	
	

}
