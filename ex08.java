public class ex08 {
    public static void main(String[] args) {
        System.out.println("Report service: \n");
        ReportGenerator pdfReport = new PDFReportGenerator("Sales Report");
        ReportGenerator excelReport = new ExcelReportGenerator("Financial Summary");
        ReportDeliveryService delivery = new ReportDeliveryService();
        
        pdfReport.generate();
        pdfReport.preview();
        delivery.sendEmail(pdfReport);
        
        excelReport.generate();
        delivery.uploadToCloud(excelReport);
        System.out.println();
    }
}

interface ReportGenerator {
    void generate();
    void export();
    void preview();
}

class PDFReportGenerator implements ReportGenerator {
    String reportName;
    String createdDate;
    String format;
    
    public PDFReportGenerator(String reportName) {
        this.reportName = reportName;
        this.createdDate = java.time.LocalDate.now().toString();
        this.format = "PDF";
    }
    
    public void generate() {
        System.out.println("Generating PDF report: " + reportName);
    }
    
    public void export() {
        System.out.println("Exporting PDF to file");
    }
    
    public void preview() {
        System.out.println("Previewing PDF report");
    }
}

class ExcelReportGenerator implements ReportGenerator {
    String reportName;
    String createdDate;
    String format;
    
    public ExcelReportGenerator(String reportName) {
        this.reportName = reportName;
        this.createdDate = java.time.LocalDate.now().toString();
        this.format = "Excel";
    }
    
    public void generate() {
        System.out.println("Generating Excel report: " + reportName);
    }
    
    public void export() {
        System.out.println("Exporting Excel to file");
    }
    
    public void preview() {
        System.out.println("Previewing Excel report");
    }
}

class ReportDeliveryService {
    String deliveryMethod;
    String recipient;
    int reportsDelivered;
    
    void sendEmail(ReportGenerator report) {
        report.export();
        System.out.println("Emailing report");
    }
    
    void uploadToCloud(ReportGenerator report) {
        report.export();
        System.out.println("Uploading report to cloud");
    }
    
    void printReport(ReportGenerator report) {
        report.generate();
        System.out.println("Printing report");
    }
}