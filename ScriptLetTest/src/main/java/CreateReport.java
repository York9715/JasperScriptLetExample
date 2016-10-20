import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.york.jasper.jasperapp.*;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

public class CreateReport {

	public static void main(String[] args) {
		String path = "C:\\york\\1.Projects\\38. JasperReports\\app\\test\\ScriptLetTest\\src\\main\\resources";
		// String masterReportFileName = path + "/jasper_report_template.jrxml";
		// String subReportFileName = path + "/address_report_template.jrxml";
		String destFileName = path + "/jasper_report_template.jrprint";
		String jasperMasterReport = path + "/jasper_report_template.jasper";
		String pdfName = path + "/jasper_report_template.pdf";

		try {
			/* Compile the master and sub report */
			// JasperReport jasperMasterReport =
			// JasperCompileManager.compileReport(masterReportFileName);
			// JasperReport jasperSubReport =
			// JasperCompileManager.compileReport(subReportFileName);

			Map<String, Object> parameters = new HashMap<String, Object>();
			// parameters.put("subreportParameter", null);
			parameters.put("chen", "chen1");
			parameters.put("york", "york1");

			List<Map<String, ?>> maps = new ArrayList<Map<String, ?>>();
			for (int i = 0; i < 1; i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("name", "Shoud not be here");
				map.put("country", "Shoud not be here");
				maps.add(map);
			}
			JRMapCollectionDataSource dataSource = new JRMapCollectionDataSource(
					maps);

			JasperFillManager.fillReportToFile(jasperMasterReport,
					destFileName, parameters, dataSource);

			export(destFileName, pdfName);

			System.out.println("PDF created...");
		} catch (JRException e) {

			e.printStackTrace();
		}
		System.out.println("Done filling!!! ...");
	}

	public static void export(String sourceFileName, String pdfName) {
		try {
			// 1- export to PDF
			JasperExportManager.exportReportToPdfFile(sourceFileName, pdfName);
			// exporter.exportReport();
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

}