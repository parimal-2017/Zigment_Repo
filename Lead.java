public class Lead {
    private String name;
    private String companySize;
    private String annualBudget;
    private String industry;
    private String urgency;
    private int score;

    // Constructor
    public Lead(String name, String companySize, String annualBudget, String industry, String urgency) {
        this.name = name;
        this.companySize = companySize;
        this.annualBudget = annualBudget;
        this.industry = industry;
        this.urgency = urgency;
        this.score = calculateLeadScore();
    }

    // Getters
    public String getName() { return name; }
    public int getScore() { return score; }

    // Calculate lead score based on criteria
    private int calculateLeadScore() {
        return scoreForCompanySize() +
               scoreForAnnualBudget() +
               scoreForIndustry() +
               scoreForUrgency();
    }

    private int scoreForCompanySize() {
        switch (companySize) {
            case "1-50 employees": return 10;
            case "51-200 employees": return 20;
            case "201-1000 employees": return 30;
            case "1000+ employees": return 40;
            default: return 0;
        }
    }

    private int scoreForAnnualBudget() {
        switch (annualBudget) {
            case "Less than $10,000": return 10;
            case "$10,000 - $50,000": return 20;
            case "$50,001 - $100,000": return 30;
            case "More than $100,000": return 40;
            default: return 0;
        }
    }

    private int scoreForIndustry() {
        switch (industry) {
            case "Technology": return 30;
            case "Finance": return 20;
            case "Healthcare": return 25;
            case "Retail": return 15;
            case "Other": return 10;
            default: return 0;
        }
    }

    private int scoreForUrgency() {
        switch (urgency) {
            case "Immediate": return 40;
            case "Short-term": return 30;
            case "Medium-term": return 20;
            case "Long-term": return 10;
            default: return 0;
        }
    }
}
