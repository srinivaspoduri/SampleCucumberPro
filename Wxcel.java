package one;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Wxcel {

	@Test
	public void sa() throws IOException
	{
		SearchinExcel("A","ONE");
		SearchinExcel("B","TWO");
		SearchinExcel("C","THREE");
		SearchinExcel("D","FOUR");
		SearchinExcel("E","FIVE");
		SearchinExcel("F","6");
		SearchinExcel("G","7.77");
	}

	public void SearchinExcel(String strSheetName,String strSearchValue) throws IOException
	{
		Workbook workbook;
		FileInputStream fio = null ;

		File folderDownloads = new File(System.getProperty("user.home")+"/Downloads");
		File[] objfiles = folderDownloads.listFiles();
		Arrays.sort(objfiles,LastModifiedFileComparator.LASTMODIFIED_REVERSE);
		String strFilePath = System.getProperty("user.home")+"/Downloads/"+objfiles[0].getName();

		System.out.println(strFilePath);
		File objReportFile = new File(strFilePath);
		if(objReportFile != null)
		{
			fio	= new FileInputStream(objReportFile);
		}
		if(strFilePath.endsWith(".xls"))
		{
			workbook = new HSSFWorkbook(fio);
		}
		else
		{
			workbook = new XSSFWorkbook(fio);
		}

		Sheet objSheet = workbook.getSheet(strSheetName);

		for(int i=0;i<=objSheet.getLastRowNum();i++)
		{
			if(objSheet.getRow(i)!= null)
			{
				for(int j=0;j<objSheet.getRow(i).getLastCellNum();j++)
				{
					if(objSheet.getRow(i).getCell(j)!=null)
					{
						if(objSheet.getRow(i).getCell(j).toString().trim().equalsIgnoreCase(strSearchValue))
						{
							System.out.println("Value found Successfully. in " + i + "   Row and "+ j +"  Column"  + strSearchValue);
						}
					}
					else
					{
						continue;
					}
				}
			}
			else
			{
				continue;
			}
		}
		fio.close();
		workbook.close();
	}
}